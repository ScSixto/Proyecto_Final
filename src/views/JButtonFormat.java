package views;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class JButtonFormat extends JButton{

    private static final long serialVersionUID = 1L;

    public JButtonFormat(String iconPath, Color background, Dimension iconDimension){
        this.setBackground(background);
        this.setIcon(UtilView.convertToIcon(iconPath,(int)iconDimension.getWidth(),(int)iconDimension.getHeight()));
        this.setBorder(BorderFactory.createEmptyBorder(0,(int)(iconDimension.getWidth()/2),0,(int)(iconDimension.getWidth()/2)));
    }
}