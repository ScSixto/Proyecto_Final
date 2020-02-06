package views.body;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

import views.ConstantsGUI;

public class JLColumnLabel extends JLabel {

    private static final long serialVersionUID = 1L;

    public static final double MAX_VALUE = 100;

    private double percentValue;
    private Color barColor;

    public JLColumnLabel(String colValue, double percentValue, Color barColor){
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
        int colHeight = (int)(this.percentValue * ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE / MAX_VALUE);
        g.setColor(this.barColor);
        g.fillRect(0,(int) (ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE - colHeight), ConstantsGUI.MAX_PIXEL_COL_WIDTH_VALUE, colHeight - ConstantsGUI.AXIS_LINE_WIDTH);
        g.setColor(Color.black);
        super.paint(g);
    }
}