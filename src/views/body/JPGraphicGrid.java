package views.body;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

import views.ConstantsGUI;
import views.UtilView;

public class JPGraphicGrid extends JPanel {

    private static final long serialVersionUID = 1L;
    private ArrayList<Double> percentValueList;
    private HashMap<String, Color> columInformation;

    public JPGraphicGrid() {
        // System.out.println("Entra");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(ConstantsGUI.COL_SEPARATION);
		flowLayout.setVgap(0);
        this.setLayout(flowLayout);
		this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.setVisible(false);
        this.percentValueList = new ArrayList<>();
    }

    public JPGraphicGrid(HashMap<String, Double> valueList) {
		this();
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
		this.setGraphicBarPanel(valueList);
	}

    private void setGraphicBarPanel(HashMap<String, Double> valueList){
		this.setMaximumSize(new Dimension((ConstantsGUI.MAX_PIXEL_COL_WIDTH_VALUE * valueList.values().size())+ (valueList.values().size() * ConstantsGUI.COL_SEPARATION),ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE + ConstantsGUI.AXIS_LINE_WIDTH));
		HashMap<String, Color> columnInformation = new HashMap<>();
		Iterator<Entry<String,Double>> it = UtilView.getPercentValues(valueList).entrySet().iterator();
		Color color;
		while(it.hasNext()) {
			Entry<String,Double> column = it.next();
			color = UtilView.getRandomColor();
			columnInformation.put(column.getKey(), color);
			this.add(new JLPointLabel(UtilView.formatDouble(valueList.get(column.getKey())), column.getValue(), color));
			this.percentValueList.add(column.getValue());
        }
        this.columInformation = columnInformation;
	}

	public void paint(Graphics g){
		super.paint(g);
		// g.setColor(ConstantsGUI.COLOR_BLACK);
		// int x = ConstantsGUI.COL_SEPARATION + ConstantsGUI.POINT_GRAPHIC_CIRCLE_DIAMETER/2;
		// int point1 = (int)(this.percentValueList.get(0) * ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE / 100);
		// int point2 = (int)(this.percentValueList.get(0) * ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE / 100);;
		// for(int i = 1; i < this.percentValueList.size(); i++){
		// 	if((i+1) < this.percentValueList.size()){
		// 		point2 = (int)(this.percentValueList.get(++i) * ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE / 100);;
		// 	}
		// 	g.drawLine(x, point1, x + ConstantsGUI.COL_SEPARATION + ConstantsGUI.POINT_GRAPHIC_CIRCLE_DIAMETER/2, point2);
		// 	x += ConstantsGUI.COL_SEPARATION + ConstantsGUI.POINT_GRAPHIC_CIRCLE_DIAMETER/2;
		// 	point1 = point2;
		// }
		// g.setColor(ConstantsGUI.GRAPHIC_BORDER_COLOR);
		// // g.setClip(5, 5, 5, 5);
		// g.drawLine(0, 0, 0, (int)(this.getHeight()*0.999));
		// g.drawLine((int)(this.getWidth()*0.999), 0, (int)(this.getWidth()*0.999), (int)(this.getHeight()*0.999));
		// g.drawLine(0, (int)(this.getHeight()*0.999), (int)(this.getWidth()*0.999), (int)(this.getHeight()*0.999));
	}

	public HashMap<String, Color> getColumnInforation() {
		return this.columInformation;
	}
}