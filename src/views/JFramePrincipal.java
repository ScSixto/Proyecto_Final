package views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import exeptions.EmptyFieldsException;
import general.HandlerLanguage;
import views.dialogs.JDialogAddAndEditCultives;
import views.dialogs.JDialogMessages;
import views.dialogs.JDialogSearchCultive;

public class JFramePrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanelPrincipal panelPpal;
	private JDialogAddAndEditCultives addDialog,editDialog;
	private JDialogSearchCultive deleteDialogSearch, editDialogSearch;
	private JDialogMessages warningDialog,errorDialog,confirmationDialog;
	private JScrollPane scroll;
	private int confirmation;
	
	public JFramePrincipal(ActionListener actionListener) {
		setMinimumSize(new Dimension(700, 400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(new ImageIcon("resources/img/logo3.png").getImage());
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.TITLE_PROGRAM));
		initComponents(actionListener);
		setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		scroll = new JScrollPane();
		scroll.setOpaque(false);
		scroll.setBorder(null);
		scroll.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelPpal = new JPanelPrincipal(actionListener);
		scroll.setViewportView(panelPpal);
		addScrollBar();
		addDialog = new JDialogAddAndEditCultives(actionListener,true);
		editDialog = new JDialogAddAndEditCultives(actionListener,false);
		deleteDialogSearch = new JDialogSearchCultive(actionListener,false);
		editDialogSearch = new JDialogSearchCultive(actionListener,true);
		warningDialog = new JDialogMessages(actionListener, ConstantsGUI.WARNING);
		errorDialog = new JDialogMessages(actionListener, ConstantsGUI.ERROR);
		confirmationDialog = new JDialogMessages(actionListener, ConstantsGUI.CONFIRMATION);
	}
	
    public void addScrollBar(){
        JScrollPane scrollPane = new JScrollPane(this.panelPpal);
        scrollPane.getVerticalScrollBar().setUI(new JScrollFormat());
        scrollPane.getHorizontalScrollBar().setUI(new JScrollFormat());
        this.add(scrollPane);
    }
	
	public void changeLanguage() {
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.TITLE_PROGRAM));
		panelPpal.changeLanguage();
		addDialog.changeLanguage();
		editDialog.changeLanguage();
		editDialogSearch.changeLanguage();
		deleteDialogSearch.changeLanguage();
		changeLanguageDialogMessages();
		
	}
	
	public void changeLanguageDialogMessages() {
		warningDialog.changeLanguage();
		errorDialog.changeLanguage();
		confirmationDialog.changeLanguage();
	}
	
	public void showCardImage(String key){
		panelPpal.showCardImage(key);
	}
	
	public void showTableCultives(HashMap<String, ArrayList<Object[]>> info){
		panelPpal.showTableCultives(info);
	}
	
	public void repaintPanel() {
		panelPpal.validate();
		panelPpal.repaint();
	}
	
	public void addItemsComboBox(Object[] items, String title) {
		panelPpal.addItemsComboBox(items, title);
	}
	
	public Object getItemComboBox() {
		return panelPpal.getItemComboBox();
	}
	
	public void getInformationCultives(HashMap<String, ArrayList<Object[]>> info) {
		panelPpal.getInformationCultives(info);
	}
	
	public void showDialogAdd(Object[] townList,Object[] speciesList) {
		this.addDialog.setLocation(ConstantsGUI.UBICATION_X_BUTTON_ADD-382, ConstantsGUI.UBICATION_Y_BUTTON_ADD+150);
		addDialog.cleanComponents(townList,speciesList);
		this.addDialog.setVisible(true);
	}
	
	public void showDialogEdit(Object[] townList,Object[] speciesList,HashMap<String,Object[]> info) {
		this.editDialog.setLocation(ConstantsGUI.UBICATION_X_BUTTON_ADD-282, ConstantsGUI.UBICATION_Y_BUTTON_ADD+150);
		this.editDialog.cleanComponents(townList,speciesList);
		this.editDialog.getInformationCultiveEdit(info);
		this.editDialog.setVisible(true);
	}
	
	public void closeDialog() {
		this.addDialog.setVisible(false);
		this.editDialog.setVisible(false);
		this.editDialogSearch.setVisible(false);
		this.deleteDialogSearch.setVisible(false);
	}
	
	public Object[] createCultive() {
		return this.addDialog.createCultive();
	}
	
	public Object[] CultiveEdited() {
		return this.editDialog.createCultiveEdited();
	}
	
	public void isEmptyComponentsAddDialog() throws EmptyFieldsException {
		addDialog.isEmptyComponents();
	}
	
	public void isEmptyComponentsEditDialog() throws EmptyFieldsException {
		editDialog.isEmptyComponents();
	}

	public void showGraphicReport(ActionListener act, HashMap<String, Object> info,String title, char graphicType) {
		panelPpal.showGraphicReport(act, info, title, graphicType);
	}

	public void showNextCardGraphicReport() {
		panelPpal.showNextCardGraphicReport();
	}

	public void showBeforeCardGraphicReport() {
		panelPpal.showBeforeCardGraphicReport();
	}

	public void showBeforeGeneralCardGraphicReport() {
		panelPpal.showBeforeGeneralCardGraphicReport();
	}

	public void showNextGeneralCardGraphicReport() {
		panelPpal.showNextGeneralCardGraphicReport();
	}
	
	public void showDialogDeleteCultive() {
		this.deleteDialogSearch.setLocation(ConstantsGUI.UBICATION_X_BUTTON_ADD-262, ConstantsGUI.UBICATION_Y_BUTTON_ADD+250);
		this.deleteDialogSearch.clearComponents();
		this.deleteDialogSearch.setVisible(true);
	}
	
	public int getIdCultiveDelete() {
		return this.deleteDialogSearch.getId();
	}
	
	public void verifyComponentsDeleteDialog() throws EmptyFieldsException {
		this.deleteDialogSearch.verifyEmptyComponent();
	}
	
	public void showDialogSearchEdit() {
		this.editDialogSearch.setLocation(ConstantsGUI.UBICATION_X_BUTTON_ADD-212, ConstantsGUI.UBICATION_Y_BUTTON_ADD+250);
		this.editDialogSearch.clearComponents();
		this.editDialogSearch.setVisible(true);
	}
	
	public int getIdCultiveEditSearch() {
		return this.editDialogSearch.getId();
	}
	
	public void verifyComponentsEditDialogSearch() throws EmptyFieldsException {
		this.editDialogSearch.verifyEmptyComponent();
	}
	
	public void setMessageWarning(String message) {
		warningDialog.setMessage(message);
		warningDialog.setVisible(true);
	}
	
	public void setMessageError(String message) {
		errorDialog.setMessage(message);
		errorDialog.setVisible(true);
	}
	
	public void setMessageConfirmation(String message) {
		confirmationDialog.setMessage(message);
		confirmationDialog.setVisible(true);
	}
	
	public void closeDialogMessages() {
		warningDialog.setVisible(false);
		errorDialog.setVisible(false);
		confirmationDialog.setVisible(false);
	}
	
	public void yesOption() {
		closeDialogMessages();
		this.confirmation = ConstantsGUI.YES_OPTION;
	}
	
	public void noOption() {
		closeDialogMessages();
		this.confirmation = ConstantsGUI.NO_OPTION;
	}
	
	public void messageNumberFormat() {
		setMessageError(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.MESSAGE_NUMBER_FORMAT_EXCEPTION));
	}
	
	public void messageUnfoundObject() {
		setMessageError(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.MESSAGE_UNFOUND_EXCEPTION));
	}
	
	public void messageCorrectAddCultive() {
		setMessageConfirmation(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.MESSAGE_CONFIRMATION_ADD_CULTIVE));
	}
	
	public int messageQuestionEditCultive() {
		setMessageWarning(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.MESSAGE_QUESTION_EDIT_CULTIVE));
		return this.confirmation;
	}
	
	public void messageCorrectEditCultive() {
		setMessageConfirmation(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.MESSAGE_CONFIRMATION_EDIT_CULTIVE));
	}
	
	public int messageQuestionDeleteCultive() {
		setMessageWarning(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.MESSAGE_QUESTION_DELETE_CULTIVE));
		return this.confirmation;
	}
	
	public void messageCorrectDeleteCultive() {
		setMessageConfirmation(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.MESSAGE_CONFIRMATION_DELETE_CULTIVE));
	}
}