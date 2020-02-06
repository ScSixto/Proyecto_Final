package views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import general.HandlerLanguage;
import views.dialogs.JDialogLanguage;

public class JFramePrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanelPrincipal panelPpal;
	private JDialogLanguage dialogLanguage;

	private JScrollPane scroll;
	
	public JFramePrincipal(ActionListener actionListener) {
		setMinimumSize(new Dimension(700, 400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(new ImageIcon("resources/img/logo3.png").getImage());
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.TITLE_PROGRAM));
		initComponents(actionListener);
		setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		scroll = new JScrollPane();
		scroll.setOpaque(false);
		scroll.setBorder(null);
		scroll.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelPpal = new JPanelPrincipal(actionListener);
		dialogLanguage = new JDialogLanguage(this,actionListener);		
		scroll.setViewportView(panelPpal);
		addScrollBar();
	}
	
    public void addScrollBar(){
        JScrollPane scrollPane = new JScrollPane(this.panelPpal);
        scrollPane.getVerticalScrollBar().setUI(new JScrollFormat());
        scrollPane.getHorizontalScrollBar().setUI(new JScrollFormat());
        this.add(scrollPane);
    }
	
	public void changeLanguage() {
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.TITLE_PROGRAM));
		panelPpal.changeLanguage();
		dialogLanguage.changeLanguage();
	}
	
	public void openDialogLanguage() {
		dialogLanguage.setVisible(true);
	}
	
	public void showCardImage(String key){
		panelPpal.showCardImage(key);
	}
	
	public int showMessageConfirmationEndProgram() {
		return JOptionPaneMessages.showMessageConfirmationEndProgram();
	}
	
	public void showMessageEndProgram() {
		JOptionPaneMessages.showMessageEndProgram();
	}
	
	public int jOptionPaneYesOption() {
		return JOptionPaneMessages.jOptionPaneYesOption();
	}
	
	public void showTableCultives(HashMap<String, ArrayList<Object[]>> info){
		panelPpal.showTableCultives(info);
	}

	public void showBarGraphicReport(HashMap<String, Double> info, GraphicReportTitle graphicTitle) {
		panelPpal.showBarGraphicReport(info, graphicTitle);
	}
	
	public void repaintPanel() {
		panelPpal.validate();
		panelPpal.repaint();
	}
	
	public void addLabel(String title) {
		panelPpal.addLabel(title);
	}
	
	public void addItemsComboBox(Object[] items) {
		panelPpal.addItemsComboBox(items);
	}
	
	public Object getItemComboBox() {
		return panelPpal.getItemComboBox();
	}
	
	public void getInformationCultives(HashMap<String, ArrayList<Object[]>> info) {
		panelPpal.getInformationCultives(info);
	}
}