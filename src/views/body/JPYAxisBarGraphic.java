package views.body;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import views.ConstantsGUI;

public class JPYAxisBarGraphic extends JPanel {

    private static final long serialVersionUID = 1L;

    private  Color axisColor;
    private int axisHeight;
    private double maxValue;

    private JPanel valuesPanel;

    public JPYAxisBarGraphic(ArrayList<Double> values){
        this.setOpaque(false);
        this.axisHeight = ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE;
        this.axisColor = ConstantsGUI.DEFAULT_AXIS_COLOR;
        this.maxValue = UtilView.getMaxValue(values);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(0);
        flowLayout.setVgap(0);
        this.setLayout(flowLayout);
        this.initComponents(values);
        this.setMaximumSize(new Dimension(this.valuesPanel.getWidth() + ConstantsGUI.AXIS_LINE_WIDTH, axisHeight));
    }
    
    public JPYAxisBarGraphic(ArrayList<Double> values, Color axisColor) {
        this(values);
        this.axisColor = axisColor;
        this.setVisible(true);
    }

    private void initComponents(ArrayList<Double> values) {
        this.setValuesPanel();
        for (int i = 0; i < ConstantsGUI.Y_AXIS_VALUE_QUANTITY; i++) {
            JLabel valueLabel = new JLabel(UtilView.getRoundedValue(this.maxValue - this.maxValue * i/ConstantsGUI.Y_AXIS_VALUE_QUANTITY));
            valueLabel.setFont(ConstantsGUI.DATA_LABEL_FONT);
            valueLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
            // if(i != ConstantsGUI.Y_AXIS_VALUE_QUANTITY - 1)
                valueLabel.setBorder(BorderFactory.createEmptyBorder(0,0,ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE / (ConstantsGUI.Y_AXIS_VALUE_QUANTITY+1) - ConstantsGUI.DATA_LABEL_FONT.getSize(),3));
            this.valuesPanel.add(valueLabel);
        }
        this.add(valuesPanel);
    }

    public void setValuesPanel(){
        this.valuesPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(this.valuesPanel, BoxLayout.PAGE_AXIS);
        this.valuesPanel.setLayout(boxLayout);
        this.valuesPanel.setOpaque(false);
        this.valuesPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.valuesPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        //this.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    public void paint(final Graphics g) {
        super.paint(g);
        g.setColor(this.axisColor);
        g.fillRect(this.valuesPanel.getWidth() - ConstantsGUI.AXIS_LINE_WIDTH ,0, ConstantsGUI.AXIS_LINE_WIDTH, this.axisHeight);
        g.getFont().deriveFont(ConstantsGUI.DATA_LABEL_FONT.getStyle(), ConstantsGUI.DATA_LABEL_FONT.getSize());
        // int y = ConstantsGUI.DATA_LABEL_FONT.getSize()+1;
        // for (int i = 0; i < ConstantsGUI.Y_AXIS_VALUE_QUANTITY; i++) {
        //     g.drawString(UtilView.getRoundedValue(this.maxValue - this.maxValue * i/ConstantsGUI.Y_AXIS_VALUE_QUANTITY), 0, y);
        //     y += ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE / ConstantsGUI.Y_AXIS_VALUE_QUANTITY;
        // }
//        g.drawString(colName,0, (int) ((ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE * MAX_VALUE) - colHeight - this.layout.getVgap()));
    }
}