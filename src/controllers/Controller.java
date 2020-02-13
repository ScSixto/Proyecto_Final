package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.json.simple.DeserializationException;

import exceptions.EmptyFieldsException;
import exceptions.NumberNegativeException;
import exceptions.FileFormatInvalid;
import exceptions.UnfoundObjectException;
import general.HandlerLanguage;
import models.*;
import persistence.FileManager;
import views.ConstantsGUI;
import views.JFramePrincipal;
import views.UtilView;

public class Controller implements ActionListener {

	public static final String SPECIES_JSON_FILE_PATH = "resources/Especies.JSON";
	public static final String CULTIVE_JSON_FILE_URL = "https://www.datos.gov.co/resource/yi68-jjgw.json";
	public static final String FILE_PATH_JSON = "resources/exports/TownAndCultives.json";
	public static final String FILE_PATH_XML = "resources/exports/TownAndCultives.xml";
	public static final String FILE_PATH_TXT = "resources/exports/TownAndCultives.txt";
	public static final String FILE_PATH_BIN = "resources/exports/TownAndCultives.bin";
	public static final String NAME_FILE_CONFIG = "config.init";
	public static final char CULTIVE_PER_TOWN_REPORT = 'T';
	public static final char CULTIVE_PER_SPECIES_REPORT = 'S';
	public static final char CULTIVE_PER_YEAR_REPORT = 'Y';
	public static final char TYPE_XML = 'X';
	public static final char TYPE_JSON = 'J';
	public static final char TYPE_TXT = 'T';
	public static final char TYPE_BIN = 'B';

	private FishFarmManager farmManager;
	private FileManager fileManager;
	private JFramePrincipal frame;

	private HandlerLanguage config = null;
	private String languageDefault;
	private char charOfTableReport;

	public Controller() {
		this.farmManager = new FishFarmManager();
	    this.fileManager = new FileManager();
		this.fileManager = new FileManager();
		this.init();
	}

	private void init() {
		this.readRecords();
		this.loadConfiguration();
		frame = new JFramePrincipal(this);
		this.getLanguageDefault();
        showCultivesTable();
    }

    private void readRecords(){
        this.readSpeciesFile();
        this.readCultivesFile();
    }

    private void readSpeciesFile(){
        try{
            ArrayList<Object[]> speciesList = this.fileManager.readSpeciesList(SPECIES_JSON_FILE_PATH, true);
            for(Object[] speciesObj: speciesList){
                farmManager.addSpecies(FishFarmManager.createSpecies((int)speciesObj[0],(String)speciesObj[1], (double)speciesObj[2], Util.getWaterType((String)speciesObj[3]), Util.getFood((String)speciesObj[4])));
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(DeserializationException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void readCultivesFile(){
        Cultive cultive;
        int speciesPosition;
        try{
            ArrayList<Object[]> cultiveList = this.fileManager.readCultiveList(CULTIVE_JSON_FILE_URL, false);
            for(Object[] cultiveObj: cultiveList){
            	try {
            		speciesPosition = this.farmManager.searchSpeciesByName((String)cultiveObj[2]);
	                cultive = FishFarmManager.createCultive((Integer)cultiveObj[1], this.farmManager.getSpecies(speciesPosition), (Integer)cultiveObj[3], (Integer)cultiveObj[4], Util.toKilograms((Double)cultiveObj[5]));
	                try{
	                    this.farmManager.addCultive(cultive, this.farmManager.getTownId(this.farmManager.searchTownByName((String)cultiveObj[0])));
	                }catch(UnfoundObjectException e){
	                    Town town = FishFarmManager.createTown((String)cultiveObj[0]);
	                    town.addCultive(cultive);
	                    this.farmManager.addTown(town);
	                }
            	}catch(UnfoundObjectException e){}
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(DeserializationException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

	public String getLanguageDefault() {
		languageDefault = Locale.getDefault().getLanguage();
		String language = "Spanish";
		switch (languageDefault) {
		case "es":
			language = "Spanish";
		case "us":
			language = "English";
		}
		return language;
	}

	public void loadLanguage() throws IOException {
		try {
			config.loadLanguage();
		} catch (Exception e) {
		}
	}

	public void saveConfig() throws IOException {
		try {
			new HandlerLanguage(NAME_FILE_CONFIG).saveLanguage();
		} catch (Exception e) {
		}
	}

	public void changeToEnglish() throws IOException {
		HandlerLanguage.language = "resources/language/languageUS.properties";
		saveConfig();
		loadLanguage();
	}

	public void changeToSpanish() throws IOException {
		HandlerLanguage.language = "resources/language/languageES.properties";
		saveConfig();
		loadLanguage();
	}

	public void loadConfiguration() {
		if (config == null) {
			config = new HandlerLanguage(NAME_FILE_CONFIG);
		}
		try {
			config.loadLanguage();
		} catch (IOException e) {
			System.err.println("file not found : NAME_FILE_CONFIG");
		}
	}

	private void manageChangeLanguageUS() {
		try {
			changeToEnglish();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		manageChangeLanguage();

	}

	private void manageChangeLanguageES() {
		try {
			changeToSpanish();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		manageChangeLanguage();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.repaintPanel();
		switch (Commands.valueOf(e.getActionCommand())) {
		case CHANGE_ENGLISH:
			manageChangeLanguageUS();
			break;
		case CHANGE_SPANISH:
			manageChangeLanguageES();
			break;
		case EXIT:
			endProgram();
			break;
		case TABLE_REPORTS:
			showPanelButtonTableReports();
			break;
		case PANEL_INITIAL:
			showPanelInitial();
			break;
		case GRAPHIC_REPORTS:
			showGraphicButtonPanel();
			break;
		case BEFORE_CARD_GRAPHIC_REPORT:
			showBeforeCardGraphicReport();
			break;
		case NEXT_CARD_GRAPHIC_REPORT:
			showNextCardGraphicReport();
			break;
		case BEFORE_GENERAL_CARD_GRAPHIC_REPORT:
			showBeforeGeneralCardGraphicReport();
			break;
		case NEXT_GENERAL_CARD_GRAPHIC_REPORT:
			showNextGeneralCardGraphicReport();
			break;
		case GRAPHIC_REPORT_ONE:
			showCultivatedFishesPerYear();
			break;
		case GRAPHIC_REPORT_TWO:
			showHarvestedFishesPerTownPerYear();
			break;
		case GRAPHIC_REPORT_THREE:
			showCultivatedFishesSpeciesPerYear();
			break;
		case GRAPHIC_REPORT_FOUR:
			showTownEarningsPerYear();
			break;
		case GRAPHIC_REPORT_FIVE:
			showFishesSpeciesWeight();
			break;
		case GRAPHIC_REPORT_SIX:
			showFishFoodUsing();
			break;
		case GRAPHIC_REPORT_SEVEN:
			showWaterTypeUsing();
			break;
		case REPORT_EIGHT:
			showReportCultivesPerTown();
			break;
		case REPORT_NINE:
			showReportCultivesPerYear();
			break;
		case REPORT_TEN:
			showReportCultivesPerSpecie();
			break;
		case GET_INFO_TABLES:
			getItemForTablesReport();
			break;
		case PANEL_TABLE_CULTIVES:
			showPanelTableCultives();
			break;
		case OPEN_DIALOG_ADD:
			showDialogAdd();
			break;
		case CLOSE_DIALOGS:
			frame.closeDialog();
			break;
		case CREATE_CULTIVE:
			createAndShowCultive();
			break;
		case OPEN_DIALOG_EDIT:
			frame.showDialogSearchEdit();
			break;
		case EDIT_CULTIVE:
			getInformationAndEditCultive();
			break;
		case DELETE_CULTIVE:
			deleteCultive();
			break;
		case SEARCH_CULTIVE:
			showDialogEdit();
			break;
		case NO_OPTION:
			frame.noOption();
			break;
		case YES_OPTION:
			frame.yesOption();
			break;
		case OPEN_DIALOG_DELETE:
			frame.showDialogDeleteCultive();
			break;
		case EXPORT_BIN:
			exportFiles(TYPE_BIN);
			break;
		case EXPORT_JSON:
			exportFiles(TYPE_JSON);
			break;
		case EXPORT_TXT:
			exportFiles(TYPE_TXT);
			break;
		case EXPORT_XML:
			exportFiles(TYPE_XML);
			break;
		case OPEN_DIALOG_EXPORT:
			frame.openDialogExport();
			break;
		}
	}
	
	private void showBeforeGeneralCardGraphicReport() {
		frame.showBeforeGeneralCardGraphicReport();
	}

	private void showNextGeneralCardGraphicReport() {
		frame.showNextGeneralCardGraphicReport();
	}

	private void showNextCardGraphicReport() {
		frame.showNextCardGraphicReport();
	}

	private void showBeforeCardGraphicReport() {
		frame.showBeforeCardGraphicReport();
	}

	private void manageChangeLanguage() {
		frame.changeLanguage();
	}

	private void showCardImage(String key) {
		frame.showCardImage(key);
	}
	
	private void endProgram() {
		if(frame.messageQuestionExit() == ConstantsGUI.YES_OPTION) 
			System.exit(0);	
		else 
			frame.ubicateWarningDialoge();
	}

	private void showPanelInitial() {
		showCardImage(ConstantsGUI.PANEL_INITIAL);
	}

	private void showCultivesTable() {
		frame.showTableCultives(UtilView.formatCultivesTable(farmManager.townsAndCultives()));
	}

	private void showPanelButtonTableReports() {
		showCultivesTable();
		showCardImage(ConstantsGUI.PANEL_TABLE_REPORTS);
	}

	private void showPanelTableCultives() {
		showCultivesTable();
		showCardImage(ConstantsGUI.PANEL_TABLE_CULTIVES);
	}

	private void showCultivatedFishesPerYear() {
		frame.showGraphicReport(this,Util.convertToReportPerYear(farmManager.getFishesPerYear(FishFarmManager.CULTIVATED_FISHES_STATE)),ConstantsGUI.GRAPHIC_TITLE_CULTIVATED_AND_HARVESTED_FISHES_PER_YEAR,ConstantsGUI.CIRCLE_GRAPHIC);
		showCardImage(ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS);
	}

	private void showHarvestedFishesPerTownPerYear() {
		frame.showGraphicReport(this,Util.convertToReportPerTownPerYear(farmManager.getFishKilogramsPerState(FishFarmManager.HARVESTED_FISHES_STATE)),ConstantsGUI.GRAPHIC_TITLE_HARVESTED_FISHES_PER_TOWN_PER_YEAR,ConstantsGUI.POINT_GRAPHIC);
		showCardImage(ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS);
	}

	private void showCultivatedFishesSpeciesPerYear() {
		frame.showGraphicReport(this,Util.convertToReportPerSpeciesPerYear(farmManager.getHarvestedFishKilogramsPerSpeciesPerYear()),ConstantsGUI.GRAPHIC_TITLE_CULTIVATED_FISHES_SPECIES_KG_PER_YEAR,ConstantsGUI.BAR_GRAPHIC);
		showCardImage(ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS);
	}

	private void showTownEarningsPerYear() {
		frame.showGraphicReport(this, Util.convertToReportPerTownPerYear(farmManager.getEarningsPerTownPerYear()),ConstantsGUI.GRAPHIC_TITLE_TOWN_EARNINGS_PER_YEAR,ConstantsGUI.POINT_GRAPHIC);
		showCardImage(ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS);
	}

	private void showFishesSpeciesWeight() {
		frame.showGraphicReport(this, Util.convertToReportPerSpecies(farmManager.getAverageWeightPerSpeciesKg()),ConstantsGUI.GRAPHIC_TITLE_SPECIES_WEIGHT,ConstantsGUI.BAR_GRAPHIC);
		showCardImage(ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS);
	}

	private void showFishFoodUsing() {
		frame.showGraphicReport(this, Util.convertToReportFood(farmManager.getFishFoodQuantityPerType()),ConstantsGUI.GRAPHIC_TITLE_FISH_FOOD_USING,ConstantsGUI.CIRCLE_GRAPHIC);
		showCardImage(ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS);
	}

	private void showWaterTypeUsing() {
		frame.showGraphicReport(this, Util.convertToReportWaterType(farmManager.getWaterTypeQuantityPerType()),ConstantsGUI.GRAPHIC_TITLE_WATER_TYPE_USING,ConstantsGUI.CIRCLE_GRAPHIC);
		showCardImage(ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS);
	}

	private void showGraphicButtonPanel() {
		showCardImage(ConstantsGUI.PANEL_GRAPHIC_REPORTS);
	}

	private void showReportCultivesPerTown() {
		charOfTableReport = CULTIVE_PER_TOWN_REPORT;
		frame.addItemsComboBox(Util.transformTownsArray(farmManager.toObjectVectorTown()),ConstantsGUI.T_TEXT_REPORT_GRAPHICS_EIGHT);
		showCardImage(ConstantsGUI.PANEL_SHOW_TABLE_REPORTS);
	}

	private void showReportCultivesPerYear() {
		charOfTableReport = CULTIVE_PER_YEAR_REPORT;
		frame.addItemsComboBox(Util.transformYearsArray(farmManager.getCultiveYearList()),ConstantsGUI.T_TEXT_REPORT_GRAPHICS_NINE);
		showCardImage(ConstantsGUI.PANEL_SHOW_TABLE_REPORTS);
	}

	private void showReportCultivesPerSpecie() {
		charOfTableReport = CULTIVE_PER_SPECIES_REPORT;
		frame.addItemsComboBox(farmManager.getSpeciesName(),ConstantsGUI.T_TEXT_REPORT_GRAPHICS_TEN);
		showCardImage(ConstantsGUI.PANEL_SHOW_TABLE_REPORTS);
	}

	private void getItemForTablesReport() {
		switch (charOfTableReport) {
		case CULTIVE_PER_TOWN_REPORT:frame.getInformationCultives(UtilView.formatCultivesTable(farmManager.cultivesPerTownReport((String) frame.getItemComboBox())));
			break;
		case CULTIVE_PER_YEAR_REPORT:
			frame.getInformationCultives(UtilView.formatCultivesTable(farmManager.getCultivesPerYear(Util.veryfyObject(frame.getItemComboBox()))));
			break;
		case CULTIVE_PER_SPECIES_REPORT:
			frame.getInformationCultives(UtilView.formatCultivesTable(farmManager.getCultivesPerSpecies((String) frame.getItemComboBox())));
			break;
		}
	}

	private void showDialogAdd() {
		frame.showDialogAdd(Util.transformTownsArray(farmManager.toObjectVectorTown()),farmManager.getSpeciesName());
	}

	private void createAndShowCultive() {
		try {
			frame.isEmptyComponentsAddDialog();
			createAndAddCultive();
			frame.messageCorrectAddCultive();
			showCultivesTable();
			frame.closeDialog();
		} catch (EmptyFieldsException e) {
			frame.setMessageError(e.getMessage());
		} catch (NumberNegativeException e) {
			frame.setMessageError(e.getMessage());
		} catch (NumberFormatException e) {
			frame.messageNumberFormat();
		}

	}
	

	private void createAndAddCultive() throws NumberNegativeException {
		Object[] infoCultives = Util.convertInformation(frame.createCultive());
		Cultive cultive;
		int speciesPosition;
		try {
			speciesPosition = this.farmManager
					.searchSpeciesByName((String) infoCultives[2]);
			cultive = FishFarmManager.createCultive((int) infoCultives[1],
					this.farmManager.getSpecies(speciesPosition),
					(int) infoCultives[3], (int) infoCultives[4],
					(double) infoCultives[5]);
			this.farmManager.addCultive(cultive, this.farmManager
					.getTownId(this.farmManager
							.searchTownByName((String) infoCultives[0])));
		} catch (UnfoundObjectException e) {
			frame.messageUnfoundObject();
		}
	}

	private void deleteCultive() {
		try {
			frame.verifyComponentsDeleteDialog();
			Object[] info = farmManager.searchCultiveDelete(frame.getIdCultiveDelete());
			if (frame.messageQuestionDeleteCultive() == ConstantsGUI.YES_OPTION) {
				farmManager.deleteCultive(info);
				frame.messageCorrectDeleteCultive();
				showCultivesTable();
				frame.closeDialog();
			}
		} catch (EmptyFieldsException e) {
			frame.setMessageError(e.getMessage());
		} catch (UnfoundObjectException e) {
			frame.messageUnfoundObject();
		}catch (NumberFormatException e) {
			frame.messageNumberFormat();
		}
	}

	private void showDialogEdit() {
		try {
			frame.verifyComponentsEditDialogSearch();
			int id = frame.getIdCultiveEditSearch();
			HashMap<String, Object[]> infoCultive = farmManager.getCultive(id);
			frame.closeDialog();
			frame.showDialogEdit(Util.transformTownsArray(farmManager.toObjectVectorTown()),farmManager.getSpeciesName(), infoCultive);
		} catch (EmptyFieldsException e) {
			frame.setMessageError(e.getMessage());
		} catch (UnfoundObjectException e) {
			frame.messageUnfoundObject();
		} catch (NumberFormatException e) {
			frame.messageNumberFormat();
		}
	}

	private void getInformationAndEditCultive() {
		try {
			frame.isEmptyComponentsEditDialog();
			editCultive();
			if (frame.messageQuestionEditCultive() == ConstantsGUI.YES_OPTION) {
				editCultive();
				frame.messageCorrectEditCultive();
				showCultivesTable();
				frame.closeDialog();
			}
		} catch (EmptyFieldsException e) {
			frame.setMessageError(e.getMessage());
		}catch (NumberNegativeException e) {
			frame.setMessageError(e.getMessage());
		}catch (NumberFormatException e) {
			frame.messageNumberFormat();
		}
	}
	
	private void editCultive() throws NumberNegativeException {
		Object [] infoCultives = Util.convertInformation(frame.CultiveEdited());
		try {
			try {
				infoCultives[2] = this.farmManager.getSpecies(this.farmManager.searchSpeciesByName((String)infoCultives[2]));
			} catch (UnfoundObjectException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NumberFormatException e) {
			frame.messageNumberFormat();
		}
	}
	
	private void exportFiles(char typeFile) {
		try {
			switch (typeFile) {
			case TYPE_XML:
				fileManager.writeXmlFile(farmManager.toObjectVectorTown(), FILE_PATH_XML);
				break;
			case TYPE_JSON:
				fileManager.writeJsonFile(farmManager.toObjectVectorTown(), FILE_PATH_JSON);
				break;
			case TYPE_TXT:
				fileManager.writeTxtFile(farmManager.toObjectVectorTown(), FILE_PATH_TXT);
				break;
			case TYPE_BIN:
				fileManager.writeBinFile(farmManager.toObjectVectorTown(), FILE_PATH_BIN);
				break;
			}
			frame.confirmationExportFile();
		} catch (IOException | FileFormatInvalid e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}