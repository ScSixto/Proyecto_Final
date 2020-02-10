package views.body;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JPanel;

import views.ConstantsGUI;
import views.UtilView;

public class JLArcLabel extends JPanel{

    private static final long serialVersionUID = 1L;

    private int circleMaxValue;
    private HashMap<String,Double> valueList;
	private HashMap<String, Color> informationPanelData;

    public JLArcLabel(HashMap<String,Double> valueList, HashMap<String,Color> informationPanelData){
        this.setPreferredSize(new Dimension((int) (ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS * 2)+ ConstantsGUI.CIRCLE_GRAPHIC_OVAL_SPACE, (int) (ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS * 2) + ConstantsGUI.CIRCLE_GRAPHIC_OVAL_SPACE));
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
        g.setColor(new Color(124,124,124));
        g.fillOval(0, 0, (int)(ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS*2), (int)(ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS*2));;
        // g.setColor(new Color(21,19,19,25));
        // g.fillOval(0, ConstantsGUI.CIRCLE_GRAPHIC_OVAL_SPACE/2, (int)(ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS*2), (int)(ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS*2));;
        // g.setColor(new Color(21,19,19,25));
        // g.fillOval(0, ConstantsGUI.CIRCLE_GRAPHIC_OVAL_SPACE/3, (int)(ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS*2), (int)(ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS*2));;
		Iterator<Entry<String,Double>> it = valueList.entrySet().iterator();
		double startAngle = 0;
		while(it.hasNext()) {
            Entry<String,Double> column = it.next();
			Color arcColor = this.informationPanelData.get(column.getKey());
			int arcAngle = (int) UtilView.getCircleGraphicAngle(this.circleMaxValue, column.getValue());
            g.setColor(arcColor);
			g.fillArc(0, 0, (int)(ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS*2), (int)(ConstantsGUI.CIRCLE_GRAPHIC_RADIOUS*2), (int) startAngle, arcAngle + 2);
            startAngle += UtilView.getCircleGraphicAngle(this.circleMaxValue, column.getValue());
            
            
        }
		// Graphics2D g2 = (Graphics2D) g;
		// g2.setPaint(new Paint(new GradientPaint(0, 0, Color.darkGray, 70, 70, Color.white)));
		// g2.setPaint(new GradientPaint(0, 0, Color.darkGray, 70, 70, Color.white));
		// g.setColor(ConstantsGUI.GRAPHIC_BORDER_COLOR);
		// g.setClip(5, 5, 5, 5);
		// g.drawLine(0, 0, 0, (int)(this.getHeight()*0.99));
		// g.drawLine((int)(this.getWidth()*0.99), 0, (int)(this.getWidth()*0.99), (int)(this.getHeight()*0.99));
		// g.drawLine(0, (int)(this.getHeight()*0.99), (int)(this.getWidth()*0.99), (int)(this.getHeight()*0.99));
        // g.setColor(Color.black);
		super.paint(g);
	}
}