package views.body;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import general.HandlerLanguage;
import views.ConstantsGUI;
import views.UtilView;
import views.title.JPanelTitle;


public class JPanelButtonGraphicReports extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanelButtonsTop buttonsTop;
	private JPanelButtonsBottom buttonsBottom;
	private JLabel title;

	public JPanelButtonGraphicReports(ActionListener actionListener) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		title = UtilView.createLabelTitles(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TITLE_REPORT_GRAPHICS));
		add(new JPanelTitle(title));
		buttonsTop = new JPanelButtonsTop(actionListener);
		add(buttonsTop);
		buttonsBottom = new JPanelButtonsBottom(actionListener);
		add(buttonsBottom);
	}
	
	public void changeLanguage() {
		buttonsTop.changeLanguage();
		buttonsBottom.changeLanguage();
		title.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TITLE_REPORT_GRAPHICS));
	}

}