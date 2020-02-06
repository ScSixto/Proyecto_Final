package views.body;

import java.awt.FlowLayout;
import java.util.HashMap;

import javax.swing.JPanel;


public class JPanelGraphicBarChart extends JPanel {

	private static final long serialVersionUID = 1L;

	// private JPBarGraphicPanel barGraphicPanel;
	private JPCircleGraphicPanel barGraphicPanel;

	JPanelGraphicBarChart(){
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setOpaque(false);
	}

	JPanelGraphicBarChart(HashMap<String, Double> info, String name){
		this();
		this.add(new JPBarGraphicPanel(info, name));
	}

	public void addGraphic(HashMap<String, Double> info, String name){
		if(this.getComponents().length > 0)this.remove(this.getComponent(0));
		// this.barGraphicPanel = new JPBarGraphicPanel(info, name);
		this.barGraphicPanel = new JPCircleGraphicPanel(info, name);
		this.add(this.barGraphicPanel);
	}

	public void changeLanguage(){
		// this.barGraphicPanel.changeLanguage();
	}
}