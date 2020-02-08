package views.body;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controllers.Commands;
import general.HandlerLanguage;
import views.ConstantsGUI;
import views.buttons.JButtonsMenuAndDialogs;

public class JPanelMenuIcons extends JPanel{
	
	public static final int WIDTH_BUTTONS = 30;
	public static final int HEIGTH_BUTTONS = 30;

	private static final long serialVersionUID = 1L;
	
	private JButtonsMenuAndDialogs add;
	private JButtonsMenuAndDialogs delete;
	private JButtonsMenuAndDialogs edit;
	
	public JPanelMenuIcons(ActionListener actionListener) {
		FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
		layout.setHgap(20);
		setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		setLayout(layout);
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		addButtons(actionListener);
		ubication();
	}
	
	private void addButtons(ActionListener actionListener) {
		add = new JButtonsMenuAndDialogs("resources/img/add.png",WIDTH_BUTTONS,HEIGTH_BUTTONS);
		add.setToolTipText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_ADD));
		add.addActionListener(actionListener);
		add.setActionCommand(Commands.OPEN_DIALOG_ADD.toString());
		add(add);
		delete = new JButtonsMenuAndDialogs("resources/img/delete.png",WIDTH_BUTTONS,HEIGTH_BUTTONS);
		delete.setToolTipText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_DELETE));
		delete.addActionListener(actionListener);
		delete.setActionCommand(Commands.CHANGE_ENGLISH.toString());
		add(delete);
		edit = new JButtonsMenuAndDialogs("resources/img/edit.png",WIDTH_BUTTONS,HEIGTH_BUTTONS);
		edit.setToolTipText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EDIT));
		add(edit);
	}
	
	public void changeLanguage() {
		add.setToolTipText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_ADD));
		delete.setToolTipText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_DELETE));
		edit.setToolTipText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EDIT));
	}
	
	public JButtonsMenuAndDialogs getButtonAdd() {
		return this.add;
	}
	
	public  void ubication() {
		System.out.println(add.getX());
		System.out.println(add.getY());
	}
	
}
