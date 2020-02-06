package views;


import javax.swing.Icon;
import javax.swing.JOptionPane;

import general.HandlerLanguage;

public class JOptionPaneMessages {
	
	public static final Object[] BUTTONS = {HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_YES),HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_NO)};
	
	public static void showMessage(String message, String title, int icon, Icon iconImage){
		JOptionPane.showMessageDialog(null, message,title,icon,iconImage);
	}

	public static int showMessage(String message,String title, int icon) {
		Object[] buttons = new Object[] {HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_ACCEPT)};
		return JOptionPane.showOptionDialog(null,message,title,JOptionPane.YES_OPTION,icon,null,buttons,buttons[0]);
	}
	
	public static void showMessage(String message){
		JOptionPane.showMessageDialog(null, message);
	}
	
    public static void showErrorMessage(String message){
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
//    public static void showErrorNumberFormatException() {
//    	showErrorMessage(Constants.MESSAGE_NUMBER_FORMAT);
//	}
//	
//	public static void showErrorDateTimeParseException() {
//		showErrorMessage(Constants.MESSAGE_DATE_TIME_EXCEPTION);
//	}
//	
//	public static void showMessageRunnerCreated() {
//		showMessage(Constants.MESSAGE_CREATE_RUNNER);
//	}
    
    public static int showMessageConfirmation(String message) {
    	Object[] buttons = new Object[] {HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_YES),HandlerLanguage.languageProperties.getProperty(ConstantsGUI.BUTTON_NO)};
    	return JOptionPane.showOptionDialog(null,message,HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_CONFIRMATION),JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,buttons,buttons[0]);
    }
    
	public static void showMessageEndProgram() {
		showMessage(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_MESSAGE_END_PROGRAM),HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EXIT),JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static int showMessageConfirmationEndProgram() {
		return showMessageConfirmation(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_MESSAGE_CONFIRMATION_END_PROGRAM));
	}
	
//	public static int showMessageConfirmationDelete() {
//		return JOptionPane.showConfirmDialog(null,Constants.MESSAGE_CONFIRMATION_DELETE,"Confirmación",JOptionPane.YES_NO_OPTION);
//	}
//	
//	public static int showMessageConfirmationEdit() {
//		return JOptionPane.showConfirmDialog(null,Constants.MESSAGE_CONFIRMATION_EDIT,"Confirmación",JOptionPane.YES_NO_OPTION);
//	}
	
	public static int jOptionPaneYesOption() {
		return JOptionPane.YES_OPTION;
	}
	
	public static void showMessageExport() {
		showMessage("Archivo exportado", "Exportar", JOptionPane.PLAIN_MESSAGE, ConstantsGUI.convertToIcon("resources/img/export.png",40,40));
	}
	
//	public static void showMessageCorrectDelete() {
//		showMessage(Constants.MESSAGE_CORRECT_DELETE);
//	}
//	
//	public static void showMessageCorrectEdit() {
//		showMessage(Constants.MESSAGE_RUNNER_EDITED);
//	}
    
}
