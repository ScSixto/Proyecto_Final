package views.body;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import controllers.Commands;
import general.HandlerLanguage;
import views.ConstantsGUI;


public class JPanelTableWhitComboBox extends JPanel{

	private static final long serialVersionUID = 1L;
	
//	private CardLayout layout;
	
	private JComboBox<Object> comboBox;
	private JPanelTable table;
	private Object[] listItems;
	private Object itemSelected;
	
	public JPanelTableWhitComboBox(ActionListener actionListener) {
//		layout = new CardLayout();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		addComboBox(actionListener);
		table = new JPanelTable();
		add(table);
	}
	
	public void addComboBox(ActionListener actionListener) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setOpaque(false);
		comboBox = new JComboBox<Object>();
		comboBox.addActionListener(actionListener);
		comboBox.setActionCommand(Commands.GET_INFO_TABLES.toString());
		comboBox.setBackground(ConstantsGUI.COLOR_WHITE);
		comboBox.setForeground(ConstantsGUI.COLOR_PRESENTATION);
		comboBox.setFont(new Font("Roboto", Font.ITALIC, 16));
		comboBox.setFocusable(false);
		panel.add(comboBox);
		add(panel);
	}
	
	public void addItemsComboBox(Object[] items) {
//		if(comboBox.getSelectedItem() == null)
		this.listItems = items;
		comboBox.removeAllItems();
		comboBox.addItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_SELECT_OPTION));
		for (Object object : items) {
			if(String.valueOf(object).equalsIgnoreCase(ConstantsGUI.TOWN_BRICENIO_INCORRECT))
				comboBox.addItem(ConstantsGUI.TOWN_BRICENIO_CORRECT);
			else
				comboBox.addItem(object);
		}
	}
	
	public Object getItemComboBox() {
		itemSelected = comboBox.getSelectedItem();
		Object object = (String.valueOf(itemSelected).equalsIgnoreCase(ConstantsGUI.TOWN_BRICENIO_CORRECT))?ConstantsGUI.TOWN_BRICENIO_INCORRECT:itemSelected;
		if(String.valueOf(itemSelected).equalsIgnoreCase(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_SELECT_OPTION)))object = null;
		return object;
	}
	
	public void getInformationCultives(HashMap<String, ArrayList<Object[]>> info) {
		table.showCultivesReports(info);
	}
	
	public void changeLanguageComboBox(Object objeto) {
		comboBox.removeAllItems();
		comboBox.addItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_SELECT_OPTION));
		if(listItems != null) {
			for (Object object : listItems) {
				if(String.valueOf(object).equalsIgnoreCase(ConstantsGUI.TOWN_BRICENIO_INCORRECT))
					comboBox.addItem(ConstantsGUI.TOWN_BRICENIO_CORRECT);
				else
					comboBox.addItem(object);
			}
		}
		comboBox.setSelectedItem(objeto);
	}
	
	public void changeLanguage() {
		changeLanguageComboBox(this.itemSelected);
		table.changeLanguageTableCultives();
	}
	
}
