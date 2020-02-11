package views.body;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

import views.ConstantsGUI;

public class JLPointLabel extends JLabel {

    private static final long serialVersionUID = 1L;

    public static final double MAX_VALUE = 100;

    private double percentValue;
    private Color barColor;

    public JLPointLabel(String colValue, double percentValue, Color barColor) {
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(ConstantsGUI.MAX_PIXEL_COL_WIDTH_VALUE,ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE - ConstantsGUI.AXIS_LINE_WIDTH));
        this.setToolTipText(colValue);
        this.initComponents(percentValue, barColor);
        this.setVisible(true);
    }

	private void initComponents(double percentValue, Color barColor){
        this.percentValue = percentValue;
        this.barColor = barColor;
    }

    public void paint(final Graphics g){
        int pointValue = (int)(this.percentValue * ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE / MAX_VALUE);
        g.setColor(this.barColor);
        g.fillOval(0,(int) (ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE - pointValue), ConstantsGUI.POINT_GRAPHIC_CIRCLE_DIAMETER, ConstantsGUI.POINT_GRAPHIC_CIRCLE_DIAMETER);
        g.setColor(Color.black);
        g.drawOval(0,(int) (ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE - pointValue), ConstantsGUI.POINT_GRAPHIC_CIRCLE_DIAMETER, ConstantsGUI.POINT_GRAPHIC_CIRCLE_DIAMETER);
        // g.getFont().deriveFont(ConstantsGUI.DATA_LABEL_FONT.getStyle(), ConstantsGUI.DATA_LABEL_FONT.getSize()-6);
        // g.drawString(this.colName,ConstantsGUI.COL_SEPARATION, (int) (ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE - colHeight) + ConstantsGUI.DATA_LABEL_FONT.getSize() + 1);
        super.paint(g);
    }
}