package views.body;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controllers.Commands;
import general.HandlerLanguage;
import views.ConstantsGUI;
import views.buttons.JButtonOptionsReports;

public class JPanelButtonsTablesReport extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButtonOptionsReports cultivesPerTown,cultivesPerYear,cultivesPerSpecie;
	
	public JPanelButtonsTablesReport(ActionListener actionListener) {
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		layout.setHgap(30);
		setLayout(layout);
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		addButtons(actionListener);
	}
	
	public void addButtons(ActionListener actionListener) {
		cultivesPerTown = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_EIGHT),ConstantsGUI.TABLE_REPORT);
		cultivesPerTown.addActionListener(actionListener);
		cultivesPerTown.setActionCommand(Commands.REPORT_EIGHT.toString());
		this.add(cultivesPerTown);
		cultivesPerYear = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_NINE),ConstantsGUI.TABLE_REPORT);
		cultivesPerYear.addActionListener(actionListener);
		cultivesPerYear.setActionCommand(Commands.REPORT_NINE.toString());
		this.add(cultivesPerYear);
		cultivesPerSpecie = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_TEN),ConstantsGUI.TABLE_REPORT);
		cultivesPerSpecie.addActionListener(actionListener);
		cultivesPerSpecie.setActionCommand(Commands.REPORT_TEN.toString());
		this.add(cultivesPerSpecie);
	}
	
	public void changeLanguage() {
		cultivesPerTown.setNewText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_EIGHT));
		cultivesPerYear.setNewText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_NINE));
		cultivesPerSpecie.setNewText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_TEN));
	}

}
