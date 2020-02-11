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
import exceptions.EmptyFieldsException;
import general.HandlerLanguage;
import views.ConstantsGUI;
import views.buttons.JButtonOptionsReports;
import views.buttons.JButtonsMenuAndDialogs;


public class JDialogSearchCultive extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private JTextFieldDialogs id;
	private JButtonsMenuAndDialogs close;
	private JButtonOptionsReports cancel,search,delete;
	private JLabel titleDialog;
	private boolean anotherButton;

	public JDialogSearchCultive(ActionListener actionListener, boolean anotherButton) {
		this.anotherButton = anotherButton;
		setBackground(ConstantsGUI.COLOR_BLUE_HEADER);
		getContentPane().setBackground(ConstantsGUI.COLOR_BLUE_HEADER);
		setMinimumSize(new Dimension(400,200));
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		setModal(true);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		initComponents(actionListener);
	}
	
	private void initComponents(ActionListener actionListener) {
		addTitleAndButton(actionListener);
		addTextField();
		cancel = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_CANCEL));
		cancel.addActionListener(actionListener);
		cancel.setActionCommand(Commands.CLOSE_DIALOGS.toString());
		search = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_SEARCH));
		delete = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_ACCEPT));
		if(this.anotherButton)
			addButtonsSearch(actionListener);
		else
			addButtonsDelete(actionListener);
	}
	
	private void addTitleAndButton(ActionListener actionListener) {
		titleDialog = ConstantsGUI.createLabelTitleMenu((this.anotherButton)?HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EDIT):HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_DELETE),ConstantsGUI.COLOR_WHITE);
		titleDialog.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		close = new JButtonsMenuAndDialogs("resources/img/cerrar.png", 17, 17);
		close.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		close.addActionListener(actionListener);
		close.setActionCommand(Commands.CLOSE_DIALOGS.toString());
		addComponents(titleDialog,close);
	}
	
	private void addTextField() {
		id = new JTextFieldDialogs(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_GET_ID_CULTIVE));
		add(id);
	}
	
	private void addButtonsSearch(ActionListener actionListener) {
		search.addActionListener(actionListener);
		search.setActionCommand(Commands.SEARCH_CULTIVE.toString());
		addButtonsPanel(this.cancel,this.search);
	}
	
	private void addButtonsDelete(ActionListener actionListener) {
		delete.addActionListener(actionListener);
		delete.setActionCommand(Commands.DELETE_CULTIVE.toString());
		addButtonsPanel(this.cancel,this.delete);
	}
	
	
	public void clearComponents() {
		id.setText(ConstantsGUI.EMPTY);
	}
	
	public int getId() {
		return Integer.parseInt(id.getText());
	}
	
	public void verifyEmptyComponent() throws EmptyFieldsException {
		if(id.getText().isEmpty())
			throw new EmptyFieldsException((HandlerLanguage.languageProperties.getProperty(ConstantsGUI.MESSAGE_EMPTY_FIELDS_EXCEPTION)));
	}
	
	public void changeLanguage() {
		titleDialog.setText((this.anotherButton)?HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EDIT):HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_DELETE));
		id.changeLanguage(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_GET_ID_CULTIVE));
		cancel.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_CANCEL));
		delete.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_ACCEPT));
		search.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_SEARCH));
	}
	
	private void addButtonsPanel(Component componentOne,Component componentTwo) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		panel.setOpaque(false);
		panel.add(componentOne);
		panel.add(componentTwo);
		this.add(panel);
	}
	
	private void addComponents(Component componentOne,Component componentTwo) {
		JPanel panel = new JPanel(new BorderLayout(10,5));
		panel.setOpaque(false);
		panel.add(componentOne,BorderLayout.CENTER);
		panel.add(componentTwo,BorderLayout.EAST);
		this.add(panel);
	}
	
//	public static void main(String[] args) {
//		new JDialogSearchRunner().setVisible(true);
//	}

}
