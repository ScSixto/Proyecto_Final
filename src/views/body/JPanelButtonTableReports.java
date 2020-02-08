package views.body;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import general.HandlerLanguage;
import views.ConstantsGUI;
import views.title.JPanelTitle;

public class JPanelButtonTableReports extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel title;
	private JPanelButtonsTablesReport panelTablesReport;
	
	public JPanelButtonTableReports(ActionListener actionListener) {
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		title = ConstantsGUI.createLabelTitles(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TITLE_REPORT_TABLES));
		add(new JPanelTitle(title));
		panelTablesReport = new JPanelButtonsTablesReport(actionListener);
		add(panelTablesReport);
	}
	
	public void changeLanguage() {
		title.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TITLE_REPORT_TABLES));
		panelTablesReport.changeLanguage();
	}

}
