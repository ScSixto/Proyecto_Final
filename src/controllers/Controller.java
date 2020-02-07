package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import org.json.simple.DeserializationException;

import exeptions.UnfoundObject;
import general.HandlerLanguage;
import models.Cultive;
import models.FishFarmManager;
import models.Town;
import models.Util;
import persistence.JsonFile;
import views.ConstantsGUI;
import views.JFramePrincipal;
import views.UtilView;

public class Controller implements ActionListener{
	
	public static final String SPECIES_JSON_FILE_PATH = "resources/Especies.JSON";
	public static final String CULTIVE_JSON_FILE_URL = "https://www.datos.gov.co/resource/yi68-jjgw.json";
	public static final String NAME_FILE_CONFIG = "config.init";
	public static final char CULTIVE_PER_TOWN_REPORT = 'T';
	public static final char CULTIVE_PER_SPECIES_REPORT = 'S';
	public static final char CULTIVE_PER_YEAR_REPORT = 'Y';
	
	private FishFarmManager farmManager;
	private JsonFile fileManager;
	private JFramePrincipal frame;
	
	private HandlerLanguage config = null;
	private String languageDefault;
	private char charOfTableReport;

	public Controller(){
		this.farmManager = new FishFarmManager();
	    this.fileManager = new JsonFile();
//	    this.farmManager.showConsoleReport();
//---------------------------------------------------------------------------------------------------
//	    this.farmManager.showConsoleReport();
//	    this.farmManager.reportdelreport();
//---------------------------------------------------------------------------------------------------
		this.init();
	}
	
    private void init(){
    	this.readRecords();
	    this.loadConfiguration();
		frame = new JFramePrincipal(this);	
		this.getLanguageDefault();
        showCultivesTable();
//---------------------------------------------------------------------------------------------------
//        farmManager.showConsoleReportReport();
//---------------------------------------------------------------------------------------------------
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
	                cultive = FishFarmManager.createCultive((Integer)cultiveObj[1], this.farmManager.getSpecies(speciesPosition), (Integer)cultiveObj[3], (Integer)cultiveObj[4], Util.toKilograms((Double)cultiveObj[5]),(Double)cultiveObj[6]);
	                try{
	                    this.farmManager.addCultive(cultive, this.farmManager.getTownId(this.farmManager.searchTownByName((String)cultiveObj[0])));
	                }catch(UnfoundObject e){
	                    Town town = FishFarmManager.createTown((String)cultiveObj[0]);
	                    town.addCultive(cultive);
	                    this.farmManager.addTown(town);
	                }
            	}catch(UnfoundObject e){
            		System.out.println(e.getMessage());
//            		e.printStackTrace();
            	}
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(DeserializationException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }


	public String getLanguageDefault(){
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

	public void loadLanguage() throws IOException{
		try {
			config.loadLanguage();
		} catch (Exception e) {			
		}
	}

	public void saveConfig() throws IOException{
		try {
			new HandlerLanguage(NAME_FILE_CONFIG).saveLanguage();
		} catch (Exception e) {
		}
	}

	public void changeToEnglish() throws IOException{
		HandlerLanguage.language = "resources/language/languageUS.properties";
		saveConfig();
		loadLanguage();		
	}

	public void changeToSpanish() throws IOException{
		HandlerLanguage.language = "resources/language/languageES.properties";
		saveConfig();
		loadLanguage();
	}


	//	Controlador carga idioma de lo que necesita	
	public void loadConfiguration(){
		if(config == null){
			config = new HandlerLanguage(NAME_FILE_CONFIG);
		}
		try{
			config.loadLanguage();
		}catch(IOException e){
			System.err.println("file not found : NAME_FILE_CONFIG");
		}
	}
	
	private void manageChangeLanguageUS(){
		try {
			changeToEnglish();
		} catch (IOException e1) {
			e1.printStackTrace();
		}			
		manageChangeLanguage();
		
	}
	
	private void manageChangeLanguageES(){
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
		case OPEN_LENGUAGE_DIALOG:
			frame.openDialogLanguage();
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
		case GRAPHIC_REPORT_ONE:
			showCultivatedAndHarvestedFishesPerYear();
			break;
		case GRAPHIC_REPORT_TWO:
			showHarvestedFishesPertownPerYear();
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
		}
	}
	
	private void manageChangeLanguage(){
		frame.changeLanguage();		
	}
	
	private void showCardImage(String key){
		frame.showCardImage(key);
	}
	
	private void endProgram() {
		if(frame.showMessageConfirmationEndProgram() == frame.jOptionPaneYesOption()) {
			frame.showMessageEndProgram();
			System.exit(0);	
		}
	}

	private void showPanelInitial() {
		showCardImage(ConstantsGUI.PANEL_INITIAL);
	}

	private void showCultivesTable(){
		frame.showTableCultives(UtilView.showCultivesTable(farmManager.townsAndCultives()));
	}
	
	private void showPanelButtonTableReports(){
		showCultivesTable();
		showCardImage(ConstantsGUI.PANEL_TABLE_REPORTS);
	}
	private void showPanelTableCultives() {
		showCultivesTable();
		showCardImage(ConstantsGUI.PANEL_TABLE_CULTIVES);
	}
	
	// private void showPanelTableReports() {
	// 	showCardImage(ConstantsGUI.PANEL_TABLE_REPORTS);
	// }
	
	private void showCultivatedAndHarvestedFishesPerYear(){
		frame.showGraphicReport(this, farmManager.getFishesPerYear(FishFarmManager.HARVESTED_FISHES_STATE), ConstantsGUI.T_TEXT_REPORT_GRAPHICS_ONE, ConstantsGUI.CIRCLE_GRAPHIC);
		showCardImage(ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS);
	}

	private void showHarvestedFishesPertownPerYear(){
		frame.showGraphicReport(this, farmManager.getFishesPerYear(FishFarmManager.HARVESTED_FISHES_STATE), ConstantsGUI.T_TEXT_REPORT_GRAPHICS_TWO, ConstantsGUI.CIRCLE_GRAPHIC);
		showCardImage(ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS);
	}

	private void showCultivatedFishesSpeciesPerYear(){
		frame.showGraphicReport(this, farmManager.getFishesPerYear(FishFarmManager.HARVESTED_FISHES_STATE), ConstantsGUI.T_TEXT_REPORT_GRAPHICS_THREE, ConstantsGUI.CIRCLE_GRAPHIC);
		showCardImage(ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS);
	}

	private void showTownEarningsPerYear(){
		frame.showGraphicReport(this, farmManager.getFishesPerYear(FishFarmManager.HARVESTED_FISHES_STATE), ConstantsGUI.T_TEXT_REPORT_GRAPHICS_FOUR, ConstantsGUI.CIRCLE_GRAPHIC);
		showCardImage(ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS);
	}

	private void showFishesSpeciesWeight(){
		frame.showGraphicReport(this, farmManager.getFishesPerYear(FishFarmManager.HARVESTED_FISHES_STATE), ConstantsGUI.T_TEXT_REPORT_GRAPHICS_FIVE, ConstantsGUI.CIRCLE_GRAPHIC);
		showCardImage(ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS);
	}

	private void showFishFoodUsing(){
		frame.showGraphicReport(this, Util.convertToReportFood(farmManager.getFishFoodQuantityPerType()), ConstantsGUI.T_TEXT_REPORT_GRAPHICS_SIX, ConstantsGUI.CIRCLE_GRAPHIC);
		showCardImage(ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS);
	}

	private void showWaterTypeUsing(){
		frame.showGraphicReport(this, Util.convertToReportWaterType(farmManager.getWaterTypeQuantityPerType()), ConstantsGUI.T_TEXT_REPORT_GRAPHICS_ONE, ConstantsGUI.CIRCLE_GRAPHIC);
		showCardImage(ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS);
	}

	private void showGraphicButtonPanel() {
		showCardImage(ConstantsGUI.PANEL_GRAPHIC_REPORTS);
	}
	
	private void showPanelTables(String title) {
		showCardImage(ConstantsGUI.PANEL_SHOW_TABLE_REPORTS);
		frame.addLabel(title);
	}
	
	private void showReportCultivesPerTown() {
		charOfTableReport = CULTIVE_PER_TOWN_REPORT;
		frame.addItemsComboBox(Util.transformTownsArray(farmManager.toObjectVectorTown()));
		showPanelTables(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_EIGHT);
	}
	
	private void showReportCultivesPerYear() {
		charOfTableReport = CULTIVE_PER_YEAR_REPORT;
		frame.addItemsComboBox(Util.transformYearsArray(farmManager.getCultiveYearList()));
		showPanelTables(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_NINE);
	}
	
	private void showReportCultivesPerSpecie() {
		charOfTableReport = CULTIVE_PER_SPECIES_REPORT;
		frame.addItemsComboBox(farmManager.getSpeciesName());
		showPanelTables(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_TEN);
	}
	
	private void getItemForTablesReport() {
		switch (charOfTableReport) {
		case CULTIVE_PER_TOWN_REPORT:
			System.out.println(frame.getItemComboBox());
			frame.getInformationCultives(UtilView.showCultivesTable(farmManager.cultivesPerTownReport((String)frame.getItemComboBox())));
			break;
		case CULTIVE_PER_YEAR_REPORT:
			frame.getInformationCultives(UtilView.showCultivesTable(farmManager.getCultivesPerYear(Util.veryfyObject(frame.getItemComboBox()))));
			break;
		case CULTIVE_PER_SPECIES_REPORT:
			frame.getInformationCultives(UtilView.showCultivesTable(farmManager.getCultivesPerSpecies((String)frame.getItemComboBox())));
			break;

		}
	}
	public static void main(String[] args) {
		new Controller();
	}
}
