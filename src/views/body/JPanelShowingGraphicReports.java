package views.body;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controllers.Commands;
import views.title.JPanelHeaderShowReports;

public class JPanelShowingGraphicReports extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanelHeaderShowReports headerReports;
	private JPanel panelContainer;

	JPanelShowingGraphicReports(ActionListener actionListener){
		BorderLayout layout = new BorderLayout();
		layout.setHgap(20);
		layout.setVgap(20);
		this.setLayout(layout);
		this.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		this.setOpaque(false);
		this.initComponents(actionListener);
		
	}
	
	private void initComponents(ActionListener actionListener){
		this.addHeaderTitle(actionListener);
		this.setPanelContainer();
	}
	
	private void addHeaderTitle(ActionListener actionListener) {
		this.headerReports = new JPanelHeaderShowReports(actionListener, Commands.GRAPHIC_REPORTS.toString());
		this.add(headerReports,BorderLayout.NORTH);
	}

	private void setPanelContainer(){
		this.panelContainer = new JPanel();
		this.panelContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.panelContainer.setOpaque(false);
		// this.panelContainer.setPreferredSize(new Dimension(500,400));

	}
	
	public void setGraphic(ActionListener actionListener, HashMap<String, Object> info, String title, char graphicType){
		// System.out.println(title);
		headerReports.addLabel(title);
		// headerReports.addLabel(HandlerLanguage.languageProperties.getProperty(title));
		if(this.panelContainer.getComponents().length > 1){
			this.panelContainer.remove(this.panelContainer.getComponent(1));
		}if(this.panelContainer.getComponents().length > 0){
		this.panelContainer.remove(this.panelContainer.getComponent(0));
		}addGraphic(actionListener, info, graphicType);
	}
	
	private void addGraphic(ActionListener actionListener, HashMap<String, Object> info, char graphicType){
		JPCardGeneralGraphicReport panelCardReport = new JPCardGeneralGraphicReport(actionListener, info, graphicType);
		// this.setButtonFilterPanel();
		this.panelContainer.add(panelCardReport);
		// this.panelContainer.add(this.buttonFilterGraphicPanel);
		this.add(this.panelContainer,BorderLayout.CENTER);
	}

	// private void setButtonFilterPanel(){
	// 	this.buttonFilterGraphicPanel = new JPanel();
	// 	this.buttonFilterGraphicPanel.setOpaque(false);
	// 	this.buttonFilterGraphicPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	// }

	public void showNextCardGraphicReport() {
		if(this.panelContainer.getComponents().length > 1)
		((JPCardGeneralGraphicReport)(this.panelContainer.getComponent(1))).showNextCard();
		else
		((JPCardGeneralGraphicReport)(this.panelContainer.getComponent(0))).showNextCard();
	}
	
	public void showPreviousCardGraphicReport() {
		if(this.panelContainer.getComponents().length > 1)
		((JPCardGeneralGraphicReport)(this.panelContainer.getComponent(1))).showPreviousCard();
		else{
		((JPCardGeneralGraphicReport)(this.panelContainer.getComponent(0))).showPreviousCard();
			// System.out.println("sisisi");
		}
	}

	public void showPreviousGeneralCardGraphicReport() {
		if(this.panelContainer.getComponents().length > 1)
		((JPCardGeneralGraphicReport)(this.panelContainer.getComponent(1))).showNextGeneralCard();
		else
		((JPCardGeneralGraphicReport)(this.panelContainer.getComponent(0))).showNextGeneralCard();
	}

	public void showNextGeneralCardGraphicReport() {
		if(this.panelContainer.getComponents().length > 1)
		((JPCardGeneralGraphicReport)(this.panelContainer.getComponent(1))).showPreviousGeneralCard();
		else
		((JPCardGeneralGraphicReport)(this.panelContainer.getComponent(0))).showPreviousGeneralCard();
	}

	public void changeLenguage(){
		this.headerReports.changeLanguage();
	}
}
