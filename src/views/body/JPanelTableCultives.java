package views.body;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import general.HandlerLanguage;
import views.ConstantsGUI;
import views.buttons.JButtonsMenuAndDialogs;

public class JPanelTableCultives extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel labelTitleTable;
	private JPanelMenuIcons buttons;
	private JPanelTable table;
	
	public JPanelTableCultives(ActionListener actionListener) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(0,90,0,90));
		setOpaque(false);
		initComponents(actionListener);
	}
	
	private void initComponents(ActionListener actionListener) {
		addTable(actionListener);
	}
	
	public void addTable(ActionListener actionListener) {
		labelTitleTable = ConstantsGUI.createLabelTitles( HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TITLE_TABLE_CULTIVES) );
		addPanel(labelTitleTable);
		createLine();
		
		buttons = new JPanelMenuIcons(actionListener);
		add(buttons);
		
		table = new JPanelTable();
		add(table);
	}
	
	public void showTableCultives(HashMap<String, ArrayList<Object[]>> info) {
		table.showTableCultives(info);
	}
	
	public void changeLanguage() {
		labelTitleTable.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TITLE_TABLE_CULTIVES));
		table.changeLanguageTableCultives();
	}

	public void addPanel(JLabel label) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setOpaque(false);
		panel.add(label);
		add(panel);
	}
	
	public void createLine() {
		JLabel line = new JLabel(ConstantsGUI.LINE);
		line.setFont(new Font("Roboto", Font.BOLD, 40));
		line.setForeground(ConstantsGUI.COLOR_LINE);
		line.setOpaque(false);
		addPanel(line);
	}
	
	public JButtonsMenuAndDialogs getComponent() {
		return this.buttons.getButtonAdd();
	}
	
}
