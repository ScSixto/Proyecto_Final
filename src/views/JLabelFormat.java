package views;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class JLabelFormat extends JLabel{

    private static final long serialVersionUID = 1L;

    public JLabelFormat(String text, Font font, Color foreground, Color background) {
        super(text);
        this.setFont(font);
        this.setForeground(foreground);
        this.setBackground(background);
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.setOpaque(false);
    }
}