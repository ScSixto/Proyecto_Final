package views.body;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controllers.Commands;
import general.HandlerLanguage;
import views.ConstantsGUI;
import views.buttons.JButtonOptionsReports;

public class JPanelButtonsBottom extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButtonOptionsReports mostUsedWaterType, specieMoreHeavy,
			mostUsedFishFood;

	public JPanelButtonsBottom(ActionListener actionListener) {
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		layout.setHgap(25);
		setLayout(layout);
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
	}

	private void initComponents(ActionListener actionListener) {
		addButtons(actionListener);
	}

	public void addButtons(ActionListener actionListener) {
		specieMoreHeavy = new JButtonOptionsReports(
				HandlerLanguage.languageProperties
						.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_FIVE),
				ConstantsGUI.BAR_GRAPHIC);
		specieMoreHeavy.addActionListener(actionListener);
		specieMoreHeavy.setActionCommand(Commands.GRAPHIC_REPORT_FIVE
				.toString());
		this.add(specieMoreHeavy);
		mostUsedFishFood = new JButtonOptionsReports(
				HandlerLanguage.languageProperties
						.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_SIX),
				ConstantsGUI.CIRCLE_GRAPHIC);
		mostUsedFishFood.addActionListener(actionListener);
		mostUsedFishFood.setActionCommand(Commands.GRAPHIC_REPORT_SIX
				.toString());
		this.add(mostUsedFishFood);
		mostUsedWaterType = new JButtonOptionsReports(
				HandlerLanguage.languageProperties
						.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_SEVEN),
				ConstantsGUI.CIRCLE_GRAPHIC);
		mostUsedWaterType.addActionListener(actionListener);
		mostUsedWaterType.setActionCommand(Commands.GRAPHIC_REPORT_SEVEN
				.toString());
		this.add(mostUsedWaterType);
	}

	public void changeLanguage() {
		specieMoreHeavy.setNewText(HandlerLanguage.languageProperties
				.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_FIVE));
		mostUsedFishFood.setNewText(HandlerLanguage.languageProperties
				.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_SIX));
		mostUsedWaterType.setNewText(HandlerLanguage.languageProperties
				.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_SEVEN));
	}

}
