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
	}
	
	private void addButtons(ActionListener actionListener) {
		add = new JButtonsMenuAndDialogs("resources/img/Add2.png",WIDTH_BUTTONS,HEIGTH_BUTTONS);
		add.setToolTipText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_ADD));
		add.addActionListener(actionListener);
		add.setActionCommand(Commands.OPEN_DIALOG_ADD.toString());
		add(add);
		delete = new JButtonsMenuAndDialogs("resources/img/Remove2.png",WIDTH_BUTTONS,HEIGTH_BUTTONS);
		delete.setToolTipText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_DELETE));
		delete.addActionListener(actionListener);
		delete.setActionCommand(Commands.OPEN_DIALOG_DELETE.toString());
		add(delete);
		edit = new JButtonsMenuAndDialogs("resources/img/Edit2.png",WIDTH_BUTTONS,HEIGTH_BUTTONS);
		edit.setToolTipText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EDIT));
		edit.addActionListener(actionListener);
		edit.setActionCommand(Commands.OPEN_DIALOG_EDIT.toString());
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
}
