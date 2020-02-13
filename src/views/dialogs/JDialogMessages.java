package views.dialogs;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.Commands;
import general.HandlerLanguage;
import views.ConstantsGUI;
import views.UtilView;
import views.buttons.JButtonOptionsReports;

public class JDialogMessages extends JDialog{

	private static final long serialVersionUID = 1L;
	private JLabel titleDialog,textMessage;
	private JButtonOptionsReports yes,no,accept;
	private char typeOfMessage;
	
	public JDialogMessages(ActionListener actionListener,char typeOfMessage) {
		this.typeOfMessage = typeOfMessage;
		setBackground(ConstantsGUI.COLOR_LINE);
		getContentPane().setBackground(ConstantsGUI.COLOR_BACKGRAUND);
		setLocation((int)(ConstantsGUI.WIDTH/3),0);
		setMinimumSize(new Dimension(450,200));
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setModal(true);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		initComponents(actionListener);
	}
	
	private void initComponents(ActionListener actionListener) {
		switch (typeOfMessage) {
		case ConstantsGUI.WARNING:
			addButtonsWarning(actionListener);
			break;
		case ConstantsGUI.ERROR:
		case ConstantsGUI.CONFIRMATION:
			addButtonsErrorOrConfirmation(actionListener);
			break;

		}
	}
	
	private void addTitlteAndText(ActionListener actionListener,String title) {
		titleDialog = UtilView.createLabelTitleMenu(title,ConstantsGUI.COLOR_PRESENTATION);
		titleDialog.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		addFlowPanel(titleDialog);
		textMessage = new JLabel();
		textMessage.setFont(new Font("Roboto", Font.PLAIN, 18));
		textMessage.setForeground(ConstantsGUI.COLOR_PRESENTATION);
		addFlowPanel(textMessage);
	}
	
	private void addButtonsWarning(ActionListener actionListener) {
		addTitlteAndText(actionListener,HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_WARNING));
		no = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_NO),ConstantsGUI.COLOR_LINE);
		no.addActionListener(actionListener);
		no.setActionCommand(Commands.NO_OPTION.toString());
		yes = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_YES),ConstantsGUI.COLOR_LINE);
		yes.addActionListener(actionListener);
		yes.setActionCommand(Commands.YES_OPTION.toString());
		addButtonsPanel(no,yes);
	}
	
	private void addButtonsErrorOrConfirmation(ActionListener actionListener) {
		addTitlteAndText(actionListener,(typeOfMessage == 'E')?HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_ERROR):HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_CONFIRMATION));
		accept = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_ACCEPT),ConstantsGUI.COLOR_LINE);
		accept.addActionListener(actionListener);
		accept.setActionCommand(Commands.YES_OPTION.toString());
		addButtonsPanel(null,accept);
	}
	
	public void setMessage(String message) {
		textMessage.setText(ConstantsGUI.HTML_TAG + message);
	}
	
	private void addButtonsPanel(Component componentOne,Component componentTwo) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 10));
		panel.setOpaque(false);
		if(componentOne != null)
			panel.add(componentOne);
		panel.add(componentTwo);
		this.add(panel);
	}
	
	private void addFlowPanel(Component component) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		panel.setOpaque(false);
		panel.add(component);
		add(panel);
	}
	
	public void changeLanguage() {
		switch (typeOfMessage) {
		case ConstantsGUI.WARNING:
			titleDialog.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_WARNING));
			no.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_NO));
			yes.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_YES));
			break;
		case ConstantsGUI.ERROR:
		case ConstantsGUI.CONFIRMATION:
			titleDialog.setText((typeOfMessage == ConstantsGUI.ERROR)?HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_ERROR):HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_CONFIRMATION));
			accept.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_ACCEPT));
			break;

		}
	}

}
