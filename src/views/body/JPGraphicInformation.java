package views.body;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import views.ConstantsGUI;
import views.JScrollFormat;

public class JPGraphicInformation extends JPanel{

    private static final long serialVersionUID = 1L;

    private JPanel contentPanel;

    public JPGraphicInformation(HashMap<String, Color> columnInformation){
        //this.setMaximumSize(new Dimension(ConstantsGUI.MAXIMUM_SCREEN_WIDTH * 1/5,ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE + ConstantsGUI.AXIS_LINE_WIDTH));
        //this.setMaximumSize(new Dimension(50, ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE + ConstantsGUI.AXIS_LINE_WIDTH));
        this.setOpaque(false);
        this.initComponents(columnInformation);
    }

    private void initComponents(HashMap<String, Color> columnInformation){
        this.setContentPanel();
        Iterator<Entry<String, Color>> it = columnInformation.entrySet().iterator();
        for (int i = 0; i < 10; i++) {
            while(it.hasNext()){
                Entry<String, Color> entry = it.next();
                this.contentPanel.add(new JLInformationLabel(entry.getKey(), entry.getValue()));
            }
        }
            this.addPanelInformationScrollBar();
        this.add(this.contentPanel);
    }

    public void setContentPanel(){
        this.contentPanel = new JPanel();
        //this.contentPanel.setMaximumSize(new Dimension(300,ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE + ConstantsGUI.AXIS_LINE_WIDTH));
        this.contentPanel.setOpaque(false);
        this.contentPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        BoxLayout boxLayout = new BoxLayout(this.contentPanel,BoxLayout.Y_AXIS);
        this.contentPanel.setLayout(boxLayout);
        this.contentPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }

    public void addPanelInformationScrollBar() {
        JScrollPane scrollPane = new JScrollPane(this.contentPanel);
        //scrollPane.getVerticalScrollBar().setUI(new JScrollFormat());
        // scrollPane.getHorizontalScrollBar().setUI(new JScrollFormat());
        scrollPane.setBorder(null);
		scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(scrollPane);
    }
}