package views.dialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import views.buttons.JButtonsMenuAndDialogs;

public class JDialogExports extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private JLabel titleDialog;
	private JButtonsMenuAndDialogs xml,json,txt,bin,close;
	
	public JDialogExports(ActionListener actionListener) {
		setBackground(ConstantsGUI.COLOR_BLUE_HEADER);
		getContentPane().setBackground(ConstantsGUI.COLOR_BLUE_HEADER);
		setMinimumSize(new Dimension(400,250));
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		setModal(true);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		initComponents(actionListener);
	}
	
	private void initComponents(ActionListener actionListener) {
		addTitleAndButton(actionListener);
		addButtonsExport(actionListener);
	}
	
	private void addTitleAndButton(ActionListener actionListener) {
		titleDialog = UtilView.createLabelTitleMenu(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EXPORT),ConstantsGUI.COLOR_WHITE);
		titleDialog.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		close = new JButtonsMenuAndDialogs("resources/img/cerrar2.png", 17, 17);
		close.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		close.addActionListener(actionListener);
		close.setActionCommand(Commands.CLOSE_DIALOGS.toString());
		addComponents(titleDialog,close);
	}
	
	private void addButtonsExport(ActionListener actionListener) {
		xml = new JButtonsMenuAndDialogs(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_XML),"resources/img/xmlFile.png",20,25,20);
		xml.addActionListener(actionListener);
		xml.setActionCommand(Commands.EXPORT_XML.toString());
		addButtons(xml);
		json = new JButtonsMenuAndDialogs(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_JSON),"resources/img/jsonFile.png",25,25,20);
		json.addActionListener(actionListener);
		json.setActionCommand(Commands.EXPORT_JSON.toString());
		addButtons(json);
		txt = new JButtonsMenuAndDialogs(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_TXT),"resources/img/textFile.png",25,25,20);
		txt.addActionListener(actionListener);
		txt.setActionCommand(Commands.EXPORT_TXT.toString());
		addButtons(txt);
		bin = new JButtonsMenuAndDialogs(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_BIN),"resources/img/binFile.png",20,25,20);
		bin.addActionListener(actionListener);
		bin.setActionCommand(Commands.EXPORT_BIN.toString());
		addButtons(bin);
	}
	
	public void changeLanguage() {
		titleDialog.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EXPORT));
		xml.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_XML));
		json.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_JSON));
		txt.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_TXT));
		bin.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_BIN));
	}
	
	private void addComponents(Component componentOne,Component componentTwo) {
		JPanel panel = new JPanel(new BorderLayout(10,5));
		panel.setOpaque(false);
		panel.add(componentOne,BorderLayout.CENTER);
		panel.add(componentTwo,BorderLayout.EAST);
		this.add(panel);
	}
	
	private void addButtons(Component component) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setOpaque(false);
		panel.add(component);
		this.add(panel);
	}
	
	
	
}
