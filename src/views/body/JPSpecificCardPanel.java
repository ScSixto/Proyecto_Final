package views.body;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import views.ConstantsGUI;
import views.JLabelFormat;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

public class JPSpecificCardPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    
	private static final Color BORDER_COLOR = Color.decode("#1e3a45");
    private static final Font TITLE_CARD_FONT = new Font("Roboto", Font.BOLD, 30);
    private static final Color TITLE_CARD_FOREGROUND = Color.decode("#1e3a45");
    private static final Color TITLE_CARD_BACKGROUND = ConstantsGUI.COLOR_WHITE;

    public JPSpecificCardPanel(ActionListener actionListener, String title, HashMap<String, Object> info, char graphicType) {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.initComponents(actionListener, title, info, graphicType);
    }

    public JPSpecificCardPanel(ActionListener actionListener, HashMap<String, Object> info, char graphicType) {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.add(new JPCardReport(actionListener, info, graphicType), BorderLayout.CENTER);
    }

    private void initComponents(ActionListener actionListener, String titleText, HashMap<String, Object> info, char graphicType) {
        this.setTitlePanel(titleText);
        // System.out.println("Hola si que si entra");
        this.add(new JPCardReport(actionListener, info, graphicType), BorderLayout.CENTER);
    }

    private void setTitlePanel(String titleText){
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(TITLE_CARD_BACKGROUND);
        JLabelFormat title = new JLabelFormat(titleText, TITLE_CARD_FONT, TITLE_CARD_FOREGROUND, TITLE_CARD_BACKGROUND);
        title.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        titlePanel.add(title);
        this.add(titlePanel, BorderLayout.NORTH);
    }

    public void showNextCard(){
        if(this.getComponentCount() > 1)
        ((JPCardReport)(this.getComponent(1))).showNextCard();
        else
        ((JPCardReport)(this.getComponent(0))).showNextCard();
    }
    
    public void showPreviousCard(){
        if(this.getComponentCount() > 1)
        ((JPCardReport)(this.getComponent(1))).showPreviousCard();
        else
        ((JPCardReport)(this.getComponent(0))).showPreviousCard();
    }
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(BORDER_COLOR);
		g.getFont().deriveFont(Font.BOLD, 50);
		// g.setClip(5, 5, 5, 5);
		g.drawLine(0, 0, 0, (int)(this.getHeight()*0.999)-20);
		g.drawLine((int)(this.getWidth()*0.999), 0, (int)(this.getWidth()*0.999), (int)(this.getHeight()*0.999)-20);
	}

}