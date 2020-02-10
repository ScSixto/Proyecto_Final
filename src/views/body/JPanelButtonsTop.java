package views.body;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controllers.Commands;
import general.HandlerLanguage;
import views.ConstantsGUI;
import views.buttons.JButtonOptionsReports;

public class JPanelButtonsTop extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButtonOptionsReports fishesCultivatedAndHarvested,
			fishesHarvestedPerYear, speciesCultivatedPerYear,
			townEarningsPerYear;

	public JPanelButtonsTop(ActionListener actionListener) {
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		layout.setHgap(20);
		setLayout(layout);
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
	}

	private void initComponents(ActionListener actionListener) {
		addButtons(actionListener);
	}

	public void addButtons(ActionListener actionListener) {
		fishesCultivatedAndHarvested = new JButtonOptionsReports(
				HandlerLanguage.languageProperties
						.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_ONE),
				ConstantsGUI.CIRCLE_GRAPHIC);
		fishesCultivatedAndHarvested.addActionListener(actionListener);
		fishesCultivatedAndHarvested
				.setActionCommand(Commands.GRAPHIC_REPORT_ONE.toString());
		this.add(fishesCultivatedAndHarvested);
		fishesHarvestedPerYear = new JButtonOptionsReports(
				HandlerLanguage.languageProperties
						.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_TWO),
				ConstantsGUI.POINT_GRAPHIC);
		fishesHarvestedPerYear.addActionListener(actionListener);
		fishesHarvestedPerYear.setActionCommand(Commands.GRAPHIC_REPORT_TWO
				.toString());
		this.add(fishesHarvestedPerYear);
		speciesCultivatedPerYear = new JButtonOptionsReports(
				HandlerLanguage.languageProperties
						.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_THREE),
				ConstantsGUI.BAR_GRAPHIC);
		speciesCultivatedPerYear.addActionListener(actionListener);
		speciesCultivatedPerYear.setActionCommand(Commands.GRAPHIC_REPORT_THREE
				.toString());
		this.add(speciesCultivatedPerYear);
		townEarningsPerYear = new JButtonOptionsReports(
				HandlerLanguage.languageProperties
						.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_FOUR),
				ConstantsGUI.POINT_GRAPHIC);
		townEarningsPerYear.addActionListener(actionListener);
		townEarningsPerYear.setActionCommand(Commands.GRAPHIC_REPORT_FOUR
				.toString());
		this.add(townEarningsPerYear);
	}

	public void changeLanguage() {
		fishesCultivatedAndHarvested
				.setNewText(HandlerLanguage.languageProperties
						.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_ONE));
		fishesHarvestedPerYear.setNewText(HandlerLanguage.languageProperties
				.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_TWO));
		speciesCultivatedPerYear.setNewText(HandlerLanguage.languageProperties
				.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_THREE));
		townEarningsPerYear.setNewText(HandlerLanguage.languageProperties
				.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_FOUR));
	}

}
