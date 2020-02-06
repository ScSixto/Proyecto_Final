package views.body;

import java.awt.FlowLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import views.ConstantsGUI;
import views.JScrollFormat;

public class JPCircleGraphicPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private GroupLayout layout;
	private JPanel circleGraphicPanel;
	private JPGraphicInformation panelInformation;
	private JPanel titlePanel;

	public JPCircleGraphicPanel() {		
		this.layout = new GroupLayout(this);
		this.setLayout(layout);
		this.setBorder(BorderFactory.createEmptyBorder(10,30, 10, 30));
		this.setOpaque(true);
		this.setBackground(ConstantsGUI.COLOR_WHITE);
		// this.setPreferredSize(new Dimension((int) (ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS * 2 +300/*  panelInformation.getSize().getWidth() */),ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS * 2));
	}
	
	public JPCircleGraphicPanel(HashMap<String, Double> valueList, String graphicTitle) {
		this();
		this.initComponents(valueList, graphicTitle);
		this.setVisible(true);
	}
	
	private void initComponents(HashMap<String, Double> valueList, String graphicTitle) {
		//this.addGraphicTitle(graphicTitle);
		HashMap<String, Color> informationPanelData = this.getInformationPanelData(valueList);
		this.addCircleGraphicPanel(valueList, informationPanelData);
		this.addPanelInformation(informationPanelData, valueList);
		this.addGroupComponents();
	}
	
	private void addGroupComponents() {
		this.layout.setVerticalGroup(this.layout.createParallelGroup().addComponent(this.circleGraphicPanel).addComponent(this.panelInformation));
		this.layout.setHorizontalGroup(this.layout.createSequentialGroup().addComponent(this.circleGraphicPanel).addComponent(this.panelInformation));
	}

	private void addCircleGraphicPanel(HashMap<String, Double> valueList, HashMap<String, Color> informationPanelData) {
		this.setCircleGraphicPanelFormat();
		this.circleGraphicPanel.add(new JLArcLabel(valueList, informationPanelData));
		this.add(circleGraphicPanel);
	}

	private void addGraphicTitle(String graphicTitle) {
		if(this.getComponents().length > 0)this.remove(this.getComponent(0));
		this.titlePanel = new JPanel();
		this.titlePanel.setOpaque(false);
		JLabel titleLabel = new JLabel(graphicTitle);
		titleLabel.setFont(ConstantsGUI.TITLE_GRAPHIC_FONT);
		titleLabel.setForeground(ConstantsGUI.TITLE_GRAPHIC_FOREGROUND);
		titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		titleLabel.setVerticalTextPosition(SwingConstants.CENTER);
		titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		this.titlePanel.add(titleLabel);
		this.add(titlePanel, BorderLayout.NORTH);
	}
	
	public void addPanelInformation(HashMap<String, Color> informationPanelData,HashMap<String, Double> valueList) {
		this.panelInformation = new JPGraphicInformation(informationPanelData);
		this.panelInformation.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
		this.add(panelInformation, BorderLayout.EAST);
		// this.addPanelInformationScrollBar();
	}

	public HashMap<String, Color> getInformationPanelData(HashMap<String, Double> valueList) {
		HashMap<String, Color> informationPanelData = new HashMap<>();
		Iterator<Entry<String, Double>> it = valueList.entrySet().iterator();
		while (it.hasNext()) {
			informationPanelData.put(it.next().getKey(), UtilView.getRandomColor());
		}
		// System.out.println(informationPanelData.values().size());
		return informationPanelData;
	}
	
	public void setCircleGraphicPanelFormat(){
		this.circleGraphicPanel = new JPanel();
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
        layout.setHgap(0);
		layout.setVgap(0);
        this.circleGraphicPanel.setLayout(layout);
		this.circleGraphicPanel.setMinimumSize(new Dimension(ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS*2,ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS*2));
		this.circleGraphicPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		this.circleGraphicPanel.setBackground(Color.magenta);
		this.circleGraphicPanel.setOpaque(false);
	}
	
	// public void addPanelInformationScrollBar() {
		//     JScrollPane scrollPane = new JScrollPane(this.panelInformation);
		//     scrollPane.getVerticalScrollBar().setUI(new JScrollFormat());
		//     scrollPane.getHorizontalScrollBar().setUI(new JScrollFormat());
		//     scrollPane.setBorder(null);
		// 	scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		//     this.panelInformation.add(scrollPane); 
		// }
		
		public void changeLanguage(){
		}
	
}