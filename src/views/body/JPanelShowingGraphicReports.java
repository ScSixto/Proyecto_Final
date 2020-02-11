package views.body;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controllers.Commands;
import views.title.JPanelHeaderShowReports;
import views.ConstantsGUI;
import views.UtilView;

public class JPanelShowingGraphicReports extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanelHeaderShowReports headerReports;
	private JPanel panelContainer;

	private JPanel buttonFilterGraphicPanel;

	JPanelShowingGraphicReports(ActionListener actionListener){
		BorderLayout layout = new BorderLayout();
		layout.setHgap(20);
		layout.setVgap(50);
		this.setLayout(layout);
		this.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		this.setOpaque(false);
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
	}
	
	public void setBarGraphic(ActionListener actionListener, HashMap<String, Object> info, String title){
		// System.out.println(title);
		headerReports.addLabel(title);
		// headerReports.addLabel(HandlerLanguage.languageProperties.getProperty(title));
		if(this.panelContainer.getComponents().length > 1){
			this.panelContainer.remove(this.panelContainer.getComponent(1));
		}if(this.panelContainer.getComponents().length > 0){
		this.panelContainer.remove(this.panelContainer.getComponent(0));
		}addBarGraphic(actionListener, info);
	}
	
	private void addBarGraphic(ActionListener actionListener, HashMap<String, Object> info){
		if(UtilView.getHashMapValuesClass(info).equals(HashMap.class.getSimpleName())){
			this.panelContainer.add(new JPBarGraphicPanel(actionListener,UtilView.convertGraphicData(info)),BorderLayout.SOUTH);
			this.add(this.panelContainer,BorderLayout.CENTER);
		}else{
			JPCardReport panelCardReport = new JPCardReport(actionListener, info);
			panelCardReport.setOpaque(true);
			setButtonFilterPanel();
			this.panelContainer.add(panelCardReport);
			// this.panelContainer.add(this.buttonFilterGraphicPanel);
			this.add(this.panelContainer,BorderLayout.CENTER);
		}
	}

	private void setButtonFilterPanel(){
		this.buttonFilterGraphicPanel = new JPanel();
		this.buttonFilterGraphicPanel.setOpaque(true);
		this.buttonFilterGraphicPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	}

	public void setCircleGraphic(ActionListener actionListener, HashMap<String, Object> info, String title){
		// System.out.println(HandlerLanguage.languageProperties.getProperty(title));
		// headerReports.addLabel(HandlerLanguage.languageProperties.getProperty(title));
		headerReports.addLabel(title);
		if(this.panelContainer.getComponents().length > 0)this.panelContainer.remove(this.panelContainer.getComponent(0));
		this.panelContainer.add(new JPCircleGraphicPanel(actionListener,UtilView.convertGraphicData(info)),BorderLayout.SOUTH);
		this.add(this.panelContainer,BorderLayout.CENTER);
	}

	public void setPointGraphic(ActionListener actionListener, HashMap<String, Object> info, String title){
		headerReports.addLabel(title);
		if(this.panelContainer.getComponents().length > 0)this.panelContainer.remove(this.panelContainer.getComponent(0));
		this.panelContainer.add(new JPBarGraphicPanel(actionListener,UtilView.convertGraphicData(info)),BorderLayout.SOUTH);
		this.add(this.panelContainer,BorderLayout.CENTER);
	}

	public void setGraphic(ActionListener act, HashMap<String, Object> info, String title, char graphicType) {
		switch (graphicType) {
			case ConstantsGUI.BAR_GRAPHIC:
			case ConstantsGUI.POINT_GRAPHIC:
				this.setBarGraphic(act, info, title);
				break;
			case ConstantsGUI.CIRCLE_GRAPHIC:
				this.setCircleGraphic(act, info, title);
				break;
			default:
				this.setCircleGraphic(act, info, title);
				break;
		}
	}
	
	public void showNextCardGraphicReport() {
		if(this.panelContainer.getComponents().length > 1)
		((JPCardReport)(this.panelContainer.getComponent(1))).showNextComponent();
		else
		((JPCardReport)(this.panelContainer.getComponent(0))).showNextComponent();
	}
	
	public void showBeforeCardGraphicReport() {
		if(this.panelContainer.getComponents().length > 1)
		((JPCardReport)(this.panelContainer.getComponent(1))).showPreviousComponent();
		else{
			((JPCardReport)(this.panelContainer.getComponent(0))).showPreviousComponent();
			// System.out.println("sisisi");
		}
	}

	public void changeLenguage(){
		this.headerReports.changeLanguage();
	}
}
