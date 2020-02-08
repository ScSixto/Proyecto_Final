package views.dialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.Commands;
import general.HandlerLanguage;
import views.ConstantsGUI;
import views.buttons.JButtonOptionsReports;
import views.buttons.JButtonsMenuAndDialogs;


public class JDialogAddAndEditCultives extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private JLabel titleDialog;
	private JTextFieldDialogs quantityCultivated, quantityHarvested,quantityKilograms;
	private JSpinnerDialogs year;
	private JComboBoxDialogs towns, species;
	private JButtonsMenuAndDialogs close;
	private JButtonOptionsReports cancel,create,delete;
	private Object[] townList,speciesList;
	
	public JDialogAddAndEditCultives(ActionListener actionListener) {
		setBackground(ConstantsGUI.COLOR_BLUE_HEADER);
		getContentPane().setBackground(ConstantsGUI.COLOR_BLUE_HEADER);
		setMinimumSize(new Dimension(470,300));
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		setLocationRelativeTo(null);
		setModal(true);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		initComponents(actionListener);
		setVisible(false);
	}
	
	private void initComponents(ActionListener actionListener) {
		addTitleAndButton(actionListener);
		addLineTwo();
		addLineThree();
		addLineFour();
		cancel = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_CANCEL));
		cancel.addActionListener(actionListener);
		cancel.setActionCommand(Commands.CLOSE_DIALOGS.toString());
		addButtonsCreate(actionListener);
	}
	
	private void addTitleAndButton(ActionListener actionListener) {
		titleDialog = ConstantsGUI.createLabelTitleMenu(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_ADD));
		titleDialog.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		close = new JButtonsMenuAndDialogs("resources/img/cerrar.png", 17, 17);
		close.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		close.addActionListener(actionListener);
		close.setActionCommand(Commands.CLOSE_DIALOGS.toString());
		addComponents(titleDialog,close);
	}
	
	private void addLineTwo() {
		towns = new JComboBoxDialogs(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TOWN));
		quantityCultivated = new JTextFieldDialogs(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_CULTIVATED_QUANTITY));
		addComponents(towns,quantityCultivated);
	}
	
	private void addLineThree() {
		species = new JComboBoxDialogs(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_SPECIE));
		quantityHarvested = new JTextFieldDialogs(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_HARVESTED_QUANTITY));
		addComponents(species,quantityHarvested);
	}
	
	private void addLineFour() {
		year = new JSpinnerDialogs(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_YEAR));
		quantityKilograms = new JTextFieldDialogs(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TOTAL_CULTIVE_WEIGHT_KG));
		addComponents(year,quantityKilograms);
	}
	
	public void changeLanguage() {
		titleDialog.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_ADD));
		towns.changeLanguage(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TOWN));
		quantityCultivated.changeLanguage(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_CULTIVATED_QUANTITY));
		species.changeLanguage(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_SPECIE));
		quantityHarvested.changeLanguage(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_HARVESTED_QUANTITY));
		quantityKilograms.changeLanguage(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TOTAL_CULTIVE_WEIGHT_KG));
		year.changeLanguage(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_YEAR));
		cancel.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_CANCEL));
		create.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_ACCEPT));
	}
	
	public void addItemsComboBox(Object[] townList,Object[] speciesList) {
		if(this.townList == null && this.speciesList == null) {
			this.townList = townList;
			this.speciesList = speciesList;
		}
		species.removeAllItems();
		towns.removeAllItems();
		species.addItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_SELECT_OPTION));
		towns.addItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_SELECT_OPTION));
		for (Object object : townList) {
			if(String.valueOf(object).equalsIgnoreCase(ConstantsGUI.TOWN_BRICENIO_INCORRECT))
				towns.addItem(ConstantsGUI.TOWN_BRICENIO_CORRECT);
			else
				towns.addItem((String)object);
		}
		
		for (Object object : speciesList) {
				species.addItem((String)object);
		}
	}
	
	private void addButtonsCreate(ActionListener actionListener) {
		create = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_ACCEPT));
		cancel.addActionListener(actionListener);
		cancel.setActionCommand(Commands.CREATE_CULTIVE.toString());
		addButtonsPanel(this.cancel,this.create);
	}
	
	private void addComponents(Component componentOne,Component componentTwo) {
		JPanel panel = new JPanel(new BorderLayout(10,5));
		panel.setOpaque(false);
		panel.add(componentOne,BorderLayout.CENTER);
		panel.add(componentTwo,BorderLayout.EAST);
		this.add(panel);
	}
	
	private void addButtonsPanel(Component componentOne,Component componentTwo) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		panel.setOpaque(false);
		panel.add(componentOne);
		panel.add(componentTwo);
		this.add(panel);
	}
	
	public void cleanComponents(Object[] townList,Object[] speciesList) {
		this.quantityCultivated.setText(ConstantsGUI.EMPTY);
		this.quantityHarvested.setText(ConstantsGUI.EMPTY);
		this.quantityKilograms.setText(ConstantsGUI.EMPTY);
		this.year.cleanSpinner();
		addItemsComboBox(townList,speciesList);
	}
	
	public boolean isEmptyComponents() {
		boolean isEmpty = false;
		if(verifyComboBox() == true || this.quantityCultivated.getText().isEmpty() || this.quantityHarvested.getText().isEmpty() || this.quantityKilograms.getText().isEmpty())
			isEmpty = true;
		return isEmpty;
	}
	
	private boolean verifyComboBox() {
		boolean isEmpty = false;
		if(String.valueOf(towns.getSelectedItem()).equalsIgnoreCase(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_SELECT_OPTION)) ||
				String.valueOf(species.getSelectedItem()).equalsIgnoreCase(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_SELECT_OPTION)))
			isEmpty = true;
		return isEmpty;
	}
	
	public Object[] createCultive() {
		return new Object[] {brisenioCase(this.towns.getSelectedItem()),this.year.getValue(),this.species.getSelectedItem(),
				this.quantityCultivated.getText(),this.quantityHarvested.getText(),this.quantityKilograms.getText()};
	}
	
	private String brisenioCase(Object text) {
		return (String.valueOf(text).equalsIgnoreCase(ConstantsGUI.TOWN_BRICENIO_CORRECT))? ConstantsGUI.TOWN_BRICENIO_INCORRECT:(String)text;
	}
	
}
