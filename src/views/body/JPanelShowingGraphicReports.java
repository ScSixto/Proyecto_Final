package views.body;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controllers.Commands;
import views.title.JPanelHeaderShowReports;
import views.ConstantsGUI;

public class JPanelShowingGraphicReports extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanelHeaderShowReports headerReports;
	private JPanel panelContainer;

	JPanelShowingGraphicReports(ActionListener actionListener){
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		this.headerReports = new JPanelHeaderShowReports(actionListener, Commands.GRAPHIC_REPORTS.toString());
		this.add(headerReports,BorderLayout.NORTH);
		this.panelContainer = new JPanel();
		this.panelContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setOpaque(false);
	}

	JPanelShowingGraphicReports(ActionListener actionListener, HashMap<String, Double> info, String title){
		this(actionListener);
	}

	public void setBarGraphic(ActionListener actionListener, HashMap<String, Double> info, String title){
		headerReports.addLabel(title);
		if(this.panelContainer.getComponents().length > 0)this.panelContainer.remove(this.panelContainer.getComponent(0));
		this.panelContainer.add(new JPBarGraphicPanel(actionListener,info),BorderLayout.SOUTH);
		this.add(this.panelContainer,BorderLayout.CENTER);
	}

	public void setCircleGraphic(ActionListener actionListener, HashMap<String, Double> info, String title){
		headerReports.addLabel(title);
		if(this.panelContainer.getComponents().length > 0)this.panelContainer.remove(this.panelContainer.getComponent(0));
		this.panelContainer.add(new JPCircleGraphicPanel(actionListener,info),BorderLayout.SOUTH);
		this.add(this.panelContainer,BorderLayout.CENTER);
	}

	public void setPointGraphic(ActionListener actionListener, HashMap<String, Double> info, String title){
		headerReports.addLabel(title);
		if(this.panelContainer.getComponents().length > 0)this.panelContainer.remove(this.panelContainer.getComponent(0));
		this.panelContainer.add(new JPBarGraphicPanel(actionListener,info),BorderLayout.SOUTH);
		this.add(this.panelContainer,BorderLayout.CENTER);
	}

	public void setGraphic(ActionListener act, HashMap<String, Double> info, String title, char graphicType) {
		switch (graphicType) {
			case ConstantsGUI.BAR_GRAPHIC:
				this.setBarGraphic(act, info, title);
				break;
			case ConstantsGUI.CIRCLE_GRAPHIC:
				this.setCircleGraphic(act, info, title);
				break;
			case ConstantsGUI.POINT_GRAPHIC:
				this.setPointGraphic(act, info, title);
				break;
			default:
				this.setCircleGraphic(act, info, title);
				break;
		}
	}
}
