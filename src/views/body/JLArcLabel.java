package views.body;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JPanel;

import views.ConstantsGUI;

public class JLArcLabel extends JPanel{

    private static final long serialVersionUID = 1L;

    private int circleMaxValue;
    private HashMap<String,Double> valueList;
	private HashMap<String, Color> informationPanelData;

    public JLArcLabel(HashMap<String,Double> valueList, HashMap<String,Color> informationPanelData){
        this.setPreferredSize(new Dimension((int) (ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS * 2), (int) (ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS * 2)));
        this.setOpaque(false);
        this.initComponents(valueList, informationPanelData);
        this.setVisible(true);
    }

    private void initComponents(HashMap<String, Double> valueList, HashMap<String, Color> informationPanelData) {
        this.valueList = valueList;
        this.informationPanelData = informationPanelData;
        this.setCircleMaxValue();
    }

    public void setCircleMaxValue(){
        this.circleMaxValue = 0;
        for (Double value: UtilView.getHasMapValues(this.valueList)) {
            this.circleMaxValue += (int)Double.parseDouble(""+value);
        }
    }
	
	public void paint(Graphics g){
        // System.out.println("Hi");
		Iterator<Entry<String,Double>> it = valueList.entrySet().iterator();
		int startAngle = 0;
		while(it.hasNext()) {
			Entry<String,Double> column = it.next();
			Color arcColor = this.informationPanelData.get(column.getKey());
			int arcAngle = UtilView.getCircleGraphicAngle(this.circleMaxValue, column.getValue());
            g.setColor(arcColor);
			g.fillArc(0, 0, ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS*2, ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS*2, startAngle, arcAngle+2);
			startAngle += UtilView.getCircleGraphicAngle(this.circleMaxValue, column.getValue());
        }
        // g.setColor(Color.black);
        // g.drawOval(0, 0, ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS * 2, ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS * 2);;
		super.paint(g);
	}
}