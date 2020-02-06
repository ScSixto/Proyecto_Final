package views.body;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import general.HandlerLanguage;
import views.ConstantsGUI;
import views.GraphicReportTitle;


public class JPanelBody extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private CardLayout layout;
	private JPanelInitiation panelInitial;
	private JPanelShowReports showReportsTable;
	private JPanelTableReports panelTableReports;
	private JPanelGraphicReports panelGraphicReports;
	private JPanelGraphicBarChart panelGraphicSpecificReport;
	
	public JPanelBody(ActionListener actionListener) {
		this.layout = new CardLayout();
		setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		setLayout(layout);
        this.setOpaque(false);
        initComponents(actionListener);
        this.setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		panelInitial = new JPanelInitiation();
		this.add(panelInitial,ConstantsGUI.PANEL_INITIAL);
		showReportsTable = new JPanelShowReports(actionListener);
		this.add(showReportsTable,ConstantsGUI.PANEL_SHOW_TABLE_REPORTS);
		panelTableReports = new JPanelTableReports(actionListener);
		this.add(panelTableReports,ConstantsGUI.PANEL_TABLE_REPORTS);
		panelGraphicReports = new JPanelGraphicReports(actionListener);
		this.add(panelGraphicReports,ConstantsGUI.PANEL_GRAPHIC_REPORTS);
		panelGraphicSpecificReport = new JPanelGraphicBarChart();
		this.add(panelGraphicSpecificReport,ConstantsGUI.PANEL_GRAPHIC_REPORT);
	}

	public void addLabel(String title) {
		showReportsTable.addLabel(title);
	}

	public void changeLanguage() {
		panelInitial.changeLanguage();
		panelGraphicReports.changeLanguage();
		panelTableReports.changeLanguage();
		showReportsTable.changeLanguage();
		panelGraphicSpecificReport.changeLanguage();
	}

	public void showBarGraphicReport(HashMap<String, Double> info, GraphicReportTitle title){
		String graphicTitle = "";
		for (GraphicReportTitle graphicReport : GraphicReportTitle.values()) {
			if(title.equals(graphicReport)){
				graphicTitle = ConstantsGUI.HTML_TAG_CENTER + HandlerLanguage.languageProperties.getProperty(graphicReport.getPropertyText());
				break;
			}
		}
		panelGraphicSpecificReport.addGraphic(info, graphicTitle);
	}
	
	public void showTableCultives(HashMap<String, ArrayList<Object[]>> info) {
		panelInitial.showTableCultives(info);
	}
	
	public void showCardImage(String key){
        switch(key){
            case ConstantsGUI.PANEL_INITIAL:
                this.layout.show(this, ConstantsGUI.PANEL_INITIAL);
                this.setPreferredSize(new Dimension((int)(ConstantsGUI.WIDTH*0.9),(int)(ConstantsGUI.HEIGHT*1.33)));
                break;
            case ConstantsGUI.PANEL_SHOW_TABLE_REPORTS:
                this.layout.show(this, ConstantsGUI.PANEL_SHOW_TABLE_REPORTS);
				break;
				case ConstantsGUI.PANEL_GRAPHIC_BAR_CHART:
                this.layout.show(this, ConstantsGUI.PANEL_GRAPHIC_BAR_CHART);
                break;
            case ConstantsGUI.PANEL_TABLE_REPORTS:
            	this.setPreferredSize(new Dimension((int)(ConstantsGUI.WIDTH*0.9),(int)(ConstantsGUI.WIDTH*0.1)));
                this.layout.show(this, ConstantsGUI.PANEL_TABLE_REPORTS);
                break;
			case ConstantsGUI.PANEL_GRAPHIC_REPORTS:
            	this.setPreferredSize(new Dimension((int)(ConstantsGUI.WIDTH*0.9),(int)(ConstantsGUI.HEIGHT*0.65)));
                this.layout.show(this, ConstantsGUI.PANEL_GRAPHIC_REPORTS);
				break;
			case ConstantsGUI.PANEL_GRAPHIC_REPORT:
            	this.setPreferredSize(new Dimension((int)(ConstantsGUI.WIDTH*0.9),(int)(ConstantsGUI.HEIGHT*0.1)));
                this.layout.show(this, ConstantsGUI.PANEL_GRAPHIC_REPORT);
                break;
        }
    }
}