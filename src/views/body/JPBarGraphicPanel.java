package views.body;

import java.awt.FlowLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import views.ConstantsGUI;
import views.JScrollFormat;
import views.UtilView;

public class JPBarGraphicPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private GroupLayout layout;
	private JPYAxisBarGraphic yAxisPanel;
	private JPXAxisBarGraphic xAxisPanel;
	private JPanel graphicBarPanel;
	private JPGraphicInformation panelInformation;
	
	public JPBarGraphicPanel(ActionListener actionListener) {
		// System.out.println("Entra");
		this.layout = new GroupLayout(this);
		this.setLayout(layout);
		this.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		this.setVisible(false);
	}

	public JPBarGraphicPanel(ActionListener actionListener, HashMap<String, Double> valueList){
		this(actionListener);
		// System.out.println(valueList.size());
		// this.setMaximumSize(new Dimension((int) (ConstantsGUI.MAXIMUM_SCREEN_WIDTH * 4 / 5),
		// 		ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE + ConstantsGUI.AXIS_LINE_WIDTH));
		setGraphicInformation(valueList);
	}

	public void setGraphicInformation(HashMap<String, Double> valueList){
		initComponents(valueList);
		this.setVisible(true);
	}

	private void initComponents(HashMap<String, Double> valueList) {
		// this.setGraphicTitle(graphicTitle);
		this.setAxis(valueList);
		this.setGraphicBarPanel(valueList);
		this.addPanelList();
	}

	// private void setGraphicTitle(String graphicTitle) {
	// 	this.titlePanel = new JPanel();
	// 	this.titlePanel.setOpaque(false);
	// 	JLabel titleLabel = new JLabel(graphicTitle);
	// 	titleLabel.setFont(ConstantsGUI.TITLE_GRAPHIC_FONT);
	// 	titleLabel.setForeground(ConstantsGUI.TITLE_GRAPHIC_FOREGROUND);
	// 	titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
	// 	titleLabel.setVerticalTextPosition(SwingConstants.CENTER);
	// 	titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
	// 	this.titlePanel.add(titleLabel);
	// }

	private void addPanelList() {
		// this.add(this.yAxisPanel);this.add(this.xAxisPanel);this.add(this.graphicBarPanel);this.add(this.panelInformation);
		layout.setHorizontalGroup(layout.createParallelGroup()/* .addComponent(this.titlePanel) */
				.addGroup(layout.createSequentialGroup().addComponent(this.yAxisPanel).addGroup(layout
								.createParallelGroup().addComponent(this.graphicBarPanel).addComponent(this.xAxisPanel))
								.addComponent(this.panelInformation)));
		// layout.createParallelGroup().addComponent(this.titlePanel).addGroup(layout.createSequentialGroup().addComponent(yAxisPanel).addComponent(graphicBarPanel).addComponent(this.panelInformation)).addComponent(xAxisPanel)));
		layout.setVerticalGroup(/* .addComponent(this.titlePanel) */
				layout.createParallelGroup().addComponent(yAxisPanel)
						.addGroup(layout.createSequentialGroup().addComponent(graphicBarPanel).addComponent(xAxisPanel))
						.addComponent(this.panelInformation));
	}

	private void setAxis(HashMap<String, Double> valueList) {
		ArrayList<Double> values = UtilView.getHasMapValues(valueList);
		this.yAxisPanel = new JPYAxisBarGraphic(values);
		this.xAxisPanel = new JPXAxisBarGraphic(values.size(), yAxisPanel.getWidth());
    }

    private void setGraphicBarPanel(HashMap<String, Double> valueList){
		this.setGraphicBarPanelFormat();
		this.graphicBarPanel.setMaximumSize(new Dimension((ConstantsGUI.MAX_PIXEL_COL_WIDTH_VALUE * valueList.values().size())+ (valueList.values().size() * ConstantsGUI.COL_SEPARATION),ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE + ConstantsGUI.AXIS_LINE_WIDTH));
		HashMap<String, Color> columnInformation = new HashMap<>();
		Iterator<Entry<String,Double>> it = UtilView.getPercentValues(valueList).entrySet().iterator();
		Color color;
		while(it.hasNext()) {
			Entry<String,Double> column = it.next();
			color = UtilView.getRandomColor();
			columnInformation.put(column.getKey(), color);
            this.graphicBarPanel.add(new JLColumnLabel(UtilView.formatDouble(valueList.get(column.getKey())), column.getValue(), color));
        }
		this.setPanelInformation(columnInformation);
	}

	private void setPanelInformation(HashMap<String, Color> columnInformation) {
		this.panelInformation = new JPGraphicInformation(columnInformation);
		this.addPanelInformationScrollBar();
	}

	public void setGraphicBarPanelFormat(){
		this.graphicBarPanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(ConstantsGUI.COL_SEPARATION);
		flowLayout.setVgap(0);
        this.graphicBarPanel.setLayout(flowLayout);
		this.graphicBarPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		this.graphicBarPanel.setOpaque(false);
	}

	public void addPanelInformationScrollBar() {
        JScrollPane scrollPane = new JScrollPane(this.panelInformation);
        scrollPane.getVerticalScrollBar().setUI(new JScrollFormat());
        scrollPane.getHorizontalScrollBar().setUI(new JScrollFormat());
        scrollPane.setBorder(null);
		scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(scrollPane);
    }
}