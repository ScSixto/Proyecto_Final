package views.header;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controllers.Commands;
import general.HandlerLanguage;
import views.ConstantsGUI;
import views.buttons.JButtonsMenuAndDialogs;



public class JPanelHeader extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private Image backGraundImage;
	private JPanelCenter panelCenter;
	private JButtonsMenuAndDialogs buttonExit;

	public JPanelHeader(ActionListener actionListener) {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(0, 20, 60, 20));
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		setBackGraund();
		addButtonExit(actionListener);
		panelCenter = new JPanelCenter(actionListener);
		add(panelCenter,BorderLayout.CENTER);
	}
	
	private void addButtonExit(ActionListener actionListener) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel.setPreferredSize(new Dimension(20,60));
		panel.setOpaque(false);
		buttonExit = new JButtonsMenuAndDialogs(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EXIT), "resources/img/exit.png", 25, 30);
		buttonExit.addActionListener(actionListener);
		buttonExit.setActionCommand(Commands.EXIT.toString());
		panel.add(buttonExit);
		add(panel,BorderLayout.NORTH);
	}
	
	public void changeLanguage() {
		panelCenter.changeLanguage();
		buttonExit.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EXIT));
	}
	
	private void setBackGraund() {
		backGraundImage = new ImageIcon("resources/img/fondo3.png").getImage();
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(backGraundImage, 0, 0, getWidth(),getHeight(),this);
	}
}
