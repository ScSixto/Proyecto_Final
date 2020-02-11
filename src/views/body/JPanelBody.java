package views.body;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import views.ConstantsGUI;
import views.buttons.JButtonsMenuAndDialogs;


public class JPanelBody extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private CardLayout layout;
	private JPanelInitiation panelInitial;
	private JPanelShowingTableReports panelShowingTableReports;
	private JPanelButtonTableReports panelButtonTableReports;
	private JPanelButtonGraphicReports panelButtonGraphicReports;
	private JPanelShowingGraphicReports panelShowingGraphicReports;
	private JPanelTableCultives panelTableCultives;

	public JPanelBody(ActionListener actionListener) {
		this.layout = new CardLayout();
		setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
		setLayout(layout);
        this.setOpaque(false);
        initComponents(actionListener);
        this.setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		panelInitial = new JPanelInitiation(actionListener);
		this.add(panelInitial,ConstantsGUI.PANEL_INITIAL);
		panelShowingTableReports = new JPanelShowingTableReports(actionListener);
		this.add(panelShowingTableReports,ConstantsGUI.PANEL_SHOW_TABLE_REPORTS);
		panelButtonTableReports = new JPanelButtonTableReports(actionListener);
		this.add(panelButtonTableReports,ConstantsGUI.PANEL_TABLE_REPORTS);
		panelButtonGraphicReports = new JPanelButtonGraphicReports(actionListener);
		this.add(panelButtonGraphicReports,ConstantsGUI.PANEL_GRAPHIC_REPORTS);
		panelShowingGraphicReports = new JPanelShowingGraphicReports(actionListener);
		this.add(panelShowingGraphicReports,ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS);
		panelTableCultives = new JPanelTableCultives(actionListener);
		this.add(panelTableCultives,ConstantsGUI.PANEL_TABLE_CULTIVES);
		
	}
	
	public void changeLanguage() {
		panelInitial.changeLanguage();
		panelButtonGraphicReports.changeLanguage();
		panelButtonTableReports.changeLanguage();
		panelShowingTableReports.changeLanguage();
		panelTableCultives.changeLanguage();
		panelShowingGraphicReports.changeLenguage();
	}
	
	public JButtonsMenuAndDialogs getComponent() {
		return this.panelTableCultives.getComponent();
	}

	// public void showBarGraphicReport(HashMap<String, Double> info, GraphicReportTitle title){
	// 	String graphicTitle = "";
	// 	for (GraphicReportTitle graphicReport : GraphicReportTitle.values()) {
	// 		if(title.equals(graphicReport)){
	// 			graphicTitle = HandlerLanguage.languageProperties.getProperty(graphicReport.getPropertyText());
	// 			break;
	// 		}
	// 	}
	// 	panelShowingGraphicReports.addGraphic(info, graphicTitle);
	// }
	
	public void showTableCultives(HashMap<String, ArrayList<Object[]>> info) {
		panelTableCultives.showTableCultives(info);
	}
	
	public void addItemsComboBox(Object[] items, String title) {
		panelShowingTableReports.addItemsComboBox(items, title);

	}
	
	public Object getItemComboBox() {
		return panelShowingTableReports.getItemComboBox();
	}
	
	public void getInformationCultives(HashMap<String, ArrayList<Object[]>> info) {
		panelShowingTableReports.getInformationCultives(info);
	}
	
	public void showCardImage(String key){
        switch(key){
            case ConstantsGUI.PANEL_INITIAL:
                this.layout.show(this, ConstantsGUI.PANEL_INITIAL);
                this.setPreferredSize(new Dimension((int)(ConstantsGUI.WIDTH*0.9),(int)(ConstantsGUI.HEIGHT*1.2)));
                break;
            case ConstantsGUI.PANEL_TABLE_CULTIVES:
                this.layout.show(this, ConstantsGUI.PANEL_TABLE_CULTIVES);
                this.setPreferredSize(new Dimension((int)(ConstantsGUI.WIDTH*0.9),(int)(ConstantsGUI.HEIGHT*0.87)));
                break;
            case ConstantsGUI.PANEL_SHOW_TABLE_REPORTS:
            	this.setPreferredSize(new Dimension((int)(ConstantsGUI.WIDTH*0.9),(int)(ConstantsGUI.HEIGHT*0.6)));
                this.layout.show(this, ConstantsGUI.PANEL_SHOW_TABLE_REPORTS);
				break;
            case ConstantsGUI.PANEL_TABLE_REPORTS:
            	this.setPreferredSize(new Dimension((int)(ConstantsGUI.WIDTH*0.9),(int)(ConstantsGUI.HEIGHT*0.6)));
                this.layout.show(this, ConstantsGUI.PANEL_TABLE_REPORTS);
                break;
			case ConstantsGUI.PANEL_GRAPHIC_REPORTS:
            	this.setPreferredSize(new Dimension((int)(ConstantsGUI.WIDTH*0.9),(int)(ConstantsGUI.HEIGHT*0.65)));
                this.layout.show(this, ConstantsGUI.PANEL_GRAPHIC_REPORTS);
				break;
			case ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS:
            	this.setPreferredSize(new Dimension((int)(ConstantsGUI.WIDTH*0.9),(int)(ConstantsGUI.HEIGHT*0.9)));
                this.layout.show(this, ConstantsGUI.PANEL_SHOW_GRAPHIC_REPORTS);
                break;
        }
    }

	public void showGraphicReport(ActionListener act,HashMap<String, Object> info, String title, char graphicType){
		panelShowingGraphicReports.setGraphic(act, info, title, graphicType);
	}

	public void showNextCardGraphicReport() {
		panelShowingGraphicReports.showNextCardGraphicReport();
	}

	public void showBeforeCardGraphicReport() {
		panelShowingGraphicReports.showBeforeCardGraphicReport();
	}
}