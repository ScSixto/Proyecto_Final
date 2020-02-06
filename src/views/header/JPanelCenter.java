package views.header;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import views.ConstantsGUI;

public class JPanelCenter extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JPanelMenu panelMenu;
	private JPanelLanguage panelLanguage;
	
	public JPanelCenter(ActionListener actionListener) {
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		layout.setHgap(20);
		setLayout(layout);
		setBackground(new Color(198,227,128,180));
		initComponents(actionListener);
		setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		addLogo();
		panelMenu = new JPanelMenu(actionListener); 
		add(panelMenu);
		panelLanguage = new JPanelLanguage(actionListener);
		add(panelLanguage);
	}
	
	private void addLogo() {
		JLabel labelLogo = new JLabel();
		labelLogo.setIcon(ConstantsGUI.convertToIcon("resources/img/logo.png",150,150));
		labelLogo.setOpaque(false);
		add(labelLogo);
	}
	
	public void changeLanguage() {
		panelMenu.changeLanguage();
		panelLanguage.changeLanguage();
	}
	
}
