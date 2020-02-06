package views.body;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import general.HandlerLanguage;
import views.ConstantsGUI;
import views.buttons.JButtonOptionsReports;

public class JPanelButtonsBottom extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButtonOptionsReports earningsTownPerYear,specieMoreHeavy,mostUsedFishFood;
	
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
		earningsTownPerYear = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_FIVE),'R');
		this.add(earningsTownPerYear);
		mostUsedFishFood = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_SIX),'P');
		this.add(mostUsedFishFood);
		specieMoreHeavy = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_SEVEN),'R');
		this.add(specieMoreHeavy);
	}
	
	public void changeLanguage() {
		earningsTownPerYear.setNewText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_FIVE));
		mostUsedFishFood.setNewText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_SIX));
		specieMoreHeavy.setNewText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_SEVEN));
	}

}
