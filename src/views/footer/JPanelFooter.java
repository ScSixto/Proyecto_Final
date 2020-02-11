package views.footer;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import general.HandlerLanguage;
import views.ConstantsGUI;
import views.UtilView;

public class JPanelFooter extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel title;
	
	public JPanelFooter() {
		setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 0));
		setBackground(ConstantsGUI.COLOR_BLUE_HEADER);
		setLayout(new GridLayout(1,3));
		initComponents();
		setVisible(true);
	}
	
	private void initComponents() {
		addCertificatesLogo();
		addLogoPage();
		addInformationCreators();
	}
	
	private void addCertificatesLogo() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel.setOpaque(false);
		JLabel logoOne = new JLabel(UtilView.convertToIcon("resources/img/certificadoLogo1.png", 400, 300));
		logoOne.setOpaque(false);
		panel.add(logoOne);
		add(panel);
	}
	
	private void addLogoPage() {
		JLabel logoPage = new JLabel(UtilView.convertToIcon("resources/img/logo3.png", 280, 280));
		logoPage.setOpaque(false);
		add(logoPage);
	}
	
	private void addInformationCreators() {
		JPanel panel =  new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(false);
		this.title = UtilView.createLabelTitleMenu(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_COPY_RIGHT),ConstantsGUI.COLOR_WHITE);
		panel.add(title);
		panel.add(createLabelInfo(ConstantsGUI.INFORMATION_CREATOR_ONE));
		panel.add(createLabelInfo(ConstantsGUI.INFORMATION_CREATOR_TWO));
		add(panel);
	}
	
	private JLabel createLabelInfo(String text) {
		JLabel info = new JLabel(ConstantsGUI.HTML_TAG+text);
		info.setFont(new Font("Roboto", Font.ITALIC, 18));
		info.setForeground(ConstantsGUI.COLOR_WHITE);
		return info;		
	}
	
	public void changeLanguage() {
		this.title.setText(ConstantsGUI.HTML_TAG_B+HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_COPY_RIGHT));
	}
	

}
