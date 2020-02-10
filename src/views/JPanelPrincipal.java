package views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import views.body.JPanelBody;
import views.footer.JPanelFooter;
import views.header.JPanelHeader;

public class JPanelPrincipal extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JPanelHeader panelHeader;
	private JPanelBody panelBody;
	private JPanelFooter panelFooter;
	
	
	public JPanelPrincipal(ActionListener actionListenner) {
		setBackground(ConstantsGUI.COLOR_BACKGRAUND);
		setLayout(new BorderLayout());
		initComponents(actionListenner);
		setVisible(true);
	}
	
	private void initComponents(ActionListener actionListenner) {
		panelHeader = new JPanelHeader(actionListenner);
		add(panelHeader,BorderLayout.NORTH);
		panelBody = new JPanelBody(actionListenner);
		add(panelBody,BorderLayout.CENTER);
		panelFooter = new JPanelFooter();
		add(panelFooter,BorderLayout.SOUTH);
	}
	
	public void changeLanguage() {
		panelHeader.changeLanguage();
		panelBody.changeLanguage();
	}
	
	public void showCardImage(String key){
		panelBody.showCardImage(key);
	}
	
	public void showTableCultives(HashMap<String, ArrayList<Object[]>> info) {
		panelBody.showTableCultives(info);
	}

	public void addItemsComboBox(Object[] items, String title) {
		panelBody.addItemsComboBox(items, title);
	}
	
	public Object getItemComboBox() {
		return panelBody.getItemComboBox();
	}
	
	public void getInformationCultives(HashMap<String, ArrayList<Object[]>> info) {
		panelBody.getInformationCultives(info);
	}

	public void showGraphicReport(ActionListener act,HashMap<String, Object> info, String title, char graphicType) {
		panelBody.showGraphicReport(act,info, title, graphicType);
	}

	public void showNextCardGraphicReport() {
		panelBody.showNextCardGraphicReport();
	}

	public void showBeforeCardGraphicReport() {
		panelBody.showBeforeCardGraphicReport();
	}

	public void showBeforeGeneralCardGraphicReport() {
		panelBody.showBeforeGeneralCardGraphicReport();
	}

	public void showNextGeneralCardGraphicReport() {
		panelBody.showNextGeneralCardGraphicReport();
	}
	
//	public void repaint() {
//		panelHeader.repaint();
//	}
}