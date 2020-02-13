package views.body;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import general.HandlerLanguage;
import views.ConstantsGUI;
import views.UtilView;

public class JPanelInitiation extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel labelTitle,labelText,imageHomePage;
	private JPanel panelYAxis;
	private boolean textVerify;
	
	public JPanelInitiation(ActionListener actionListener) {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
	}

	public void initComponents(ActionListener actionListener) {
		panelYAxis = new JPanel();
		panelYAxis.setLayout(new BoxLayout(panelYAxis, BoxLayout.Y_AXIS));
		panelYAxis.setOpaque(false);
		add(panelYAxis);
		textVerify = (HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_PISCICULTURE).equalsIgnoreCase(ConstantsGUI.T_PISCICULTURE))?true:false;
		addImageHomePage();
		addInformation();
	}
	
	public void addImageHomePage() {
		JPanel panelImage = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelImage.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		panelImage.setOpaque(false);
		imageHomePage = new JLabel(UtilView.convertToIcon("resources/img/"+((textVerify)?"imagenHomePageEnglish":"imagenHomePage")+".png", 800, 420));
		panelImage.add(imageHomePage);
		panelYAxis.add(panelImage);
	}
	
	public void addInformation() {
		labelTitle = UtilView
				.createLabelTitles(HandlerLanguage.languageProperties
						.getProperty(ConstantsGUI.T_PISCICULTURE));
		// labelTitle.setBackground(new Color(49,201,150,150));
		labelTitle.setOpaque(false);
		labelTitle.setForeground(ConstantsGUI.COLOR_PRESENTATION);
		addPanel(labelTitle);
		createLine();
		labelText = new JLabel(ConstantsGUI.HTML_TAG + HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_OF_PISCICULTURE));
		labelText.setFont(new Font("Roboto", Font.PLAIN, 20));
		labelText.setForeground(ConstantsGUI.COLOR_PRESENTATION);
		addPanel(labelText);
	}

	public void changeLanguage() {
		labelTitle.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_PISCICULTURE));
		textVerify = (labelTitle.getText().equalsIgnoreCase(ConstantsGUI.T_PISCICULTURE))?true:false;
		labelText.setText(ConstantsGUI.HTML_TAG + HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_OF_PISCICULTURE));
		imageHomePage.setIcon(UtilView.convertToIcon("resources/img/"+((textVerify)?"imagenHomePageEnglish":"imagenHomePage")+".png", 800, 420));
		labelTitle.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_PISCICULTURE));
	}

	public void addPanel(JLabel label) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setOpaque(false);
		panel.add(label);
		panelYAxis.add(panel);
	}

	public void createLine() {
		JLabel line = new JLabel(ConstantsGUI.LINE);
		line.setFont(new Font("Roboto", Font.BOLD, 40));
		line.setForeground(ConstantsGUI.COLOR_LINE);
		line.setOpaque(false);
		addPanel(line);
	}
}