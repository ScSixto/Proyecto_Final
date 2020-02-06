package views.body;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controllers.Commands;
import general.HandlerLanguage;
import views.ConstantsGUI;
import views.buttons.JButtonOptionsReports;

public class JPanelButtonsTop extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButtonOptionsReports fishesCultivatedAndHarvested,fishesHarvestedPerYear,speciesCultivatedPerYear,mostUsedWaterType;
	
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
		fishesHarvestedPerYear = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_TWO),'R');
		this.add(fishesHarvestedPerYear);
		fishesCultivatedAndHarvested = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_ONE),'B');
		fishesCultivatedAndHarvested.addActionListener(actionListener);
		fishesCultivatedAndHarvested.setActionCommand(Commands.GRAPHIC_REPORT_ONE.toString());
		this.add(fishesCultivatedAndHarvested);
		speciesCultivatedPerYear = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_THREE),'R');
		this.add(speciesCultivatedPerYear);
		mostUsedWaterType = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_FOUR),'B');
		this.add(mostUsedWaterType);
	}
	
	public void changeLanguage() {
		fishesCultivatedAndHarvested.setNewText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_ONE));
		fishesHarvestedPerYear.setNewText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_TWO));
		speciesCultivatedPerYear.setNewText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_THREE));
		mostUsedWaterType.setNewText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_FOUR));
	}

}
