package views.body;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import general.HandlerLanguage;
import views.ConstantsGUI;

public class JPanelInitiation extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel labelTitle;
	private JLabel labelText;
	private JLabel labelTitleTable;
	private JPanel panelYAxis;
	private JPanelTable table;
	
	public JPanelInitiation() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
//		setBorder(BorderFactory.createEmptyBorder(20,30,0,10));
		setOpaque(false);
		initComponents();
		setVisible(true);
	}
	
	public void initComponents() {
		panelYAxis = new JPanel();
		panelYAxis.setLayout(new BoxLayout(panelYAxis, BoxLayout.Y_AXIS));
		panelYAxis.setOpaque(false);
		add(panelYAxis);
		addInformation();
		addTable();
	}

	public void addInformation() {
		labelTitle = ConstantsGUI.createLabelTitles(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_PISCICULTURE));
//		labelTitle.setBackground(Color.BLACK);
//		labelTitle.setOpaque(true);
		panelYAxis.add(labelTitle);
		createLine();
		labelText = new JLabel("<html>"+ HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_OF_PISCICULTURE) + "</html>");
		labelText.setFont(new Font("Roboto", Font.PLAIN, 20));
		labelText.setForeground(ConstantsGUI.COLOR_PRESENTATION);
//		labelText.setBackground(Color.BLACK);
//		labelText.setOpaque(true);
		panelYAxis.add(labelText);
	}

	public void addTable() {
		labelTitleTable = ConstantsGUI.createLabelTitles( HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TITLE_TABLE_CULTIVES) );
		labelTitleTable.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));
		labelTitleTable.setFont(new Font("Roboto", Font.ITALIC, 50));
		labelTitleTable.setForeground(ConstantsGUI.COLOR_PRESENTATION);
//		labelTitleTable.setBackground(Color.BLACK);
//		labelTitleTable.setOpaque(true);
		panelYAxis.add(labelTitleTable);
		createLine();
		
		table = new JPanelTable();
		panelYAxis.add(table);
	}
	
	public void showTableCultives(HashMap<String, ArrayList<Object[]>> info) {
		table.showTableCultives(info);
	}
	
	public void changeLanguage() {
		labelTitle.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_PISCICULTURE));
		labelText.setText("<html>" + HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_OF_PISCICULTURE) + "</p></html>");
		labelTitleTable.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TITLE_TABLE_CULTIVES));
		table.changeLanguageTableCultives();
	}
	
	public void createLine() {
		JLabel line = new JLabel(ConstantsGUI.LINE);
		line.setFont(new Font("Roboto", Font.BOLD, 40));
		line.setForeground(ConstantsGUI.COLOR_LINE);
		panelYAxis.add(line);
	}
	

}
