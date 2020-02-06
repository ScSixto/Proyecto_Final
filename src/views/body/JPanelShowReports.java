package views.body;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controllers.Commands;
import views.title.JPanelHeaderShowReports;

public class JPanelShowReports extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JPanelHeaderShowReports headerReports;
	private JPanelTableWhitComboBox tableBox;
	
	public JPanelShowReports(ActionListener actionListener) {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		headerReports = new JPanelHeaderShowReports(actionListener,Commands.TABLE_REPORTS.toString());
		add(headerReports,BorderLayout.NORTH);
		tableBox = new JPanelTableWhitComboBox(actionListener);
		add(tableBox,BorderLayout.CENTER);
	}
	
	public void addLabel(String title) {
//		headerReports.emptyText();
		headerReports.addLabel(title);
	}
	
	public void changeLanguage() {
		headerReports.changeLanguage();
		tableBox.changeLanguage();
	}
	
	public void addItemsComboBox(Object[] items) {
		tableBox.addItemsComboBox(items);
	}
	
	public Object getItemComboBox() {
		return tableBox.getItemComboBox();
	}
	
	public void getInformationCultives(HashMap<String, ArrayList<Object[]>> info) {
		tableBox.getInformationCultives(info);
	}
	
}
