package views.body;

import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.GroupLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;

import views.ConstantsGUI;
import views.UtilView;

public class JPCircleGraphicPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private  GroupLayout layout;
	private JPanel circleGraphicPanel;
	private JPGraphicInformation panelInformation;

	public JPCircleGraphicPanel(ActionListener actionListener) {		
		this.layout = new GroupLayout(this);
		this.setLayout(layout);
		this.setBorder(BorderFactory.createEmptyBorder(10,30, 10, 30));
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		//this.setVisible(false);
		// this.setPreferredSize(new Dimension((int) (ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS * 2 +300/*  panelInformation.getSize().getWidth() */),ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS * 2));
	}
	
	public JPCircleGraphicPanel(ActionListener actionListener,HashMap<String, Double> valueList) {
		this(actionListener);
		this.initComponents(valueList);
		this.setVisible(true);
	}

	public void setGraphicInformation(HashMap<String, Double> valueList){
		initComponents(valueList);
		this.setVisible(true);
	}
	
	private void initComponents(HashMap<String, Double> valueList) {
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
	

	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		// g2.setPaint(new Paint(new GradientPaint(0, 0, Color.darkGray, 70, 70, Color.white)));
		g2.setPaint(new GradientPaint(0, 0, Color.darkGray, 70, 70, Color.white));
		super.paint(g2);
	}
}