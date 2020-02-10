package views.body;

import javax.swing.JButton;
import javax.swing.JPanel;

import controllers.Commands;
import views.JButtonFormat;
import views.UtilView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class JPCardGeneralGraphicReport extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final String BEFORE_BUTTON_ICON_PATH = "resources/img/arrowLeft.png";
    public static final String NEXT_BUTTON_ICON_PATH = "resources/img/arrowRight.png";
    public static final Dimension BUTTON_ACTION_DIMENSION = new Dimension(20,20);
    public static final Color BUTTON_ACTION_COLOR = Color.decode("#1e3a45");

    private JPanel contentPanel;
    private CardLayout layout;
    private JPanel buttonsPanel;
    private int currentKeyComponent;

    public JPCardGeneralGraphicReport(ActionListener actionListener, HashMap<String,Object> info, char graphicType){
        this.layout = new CardLayout();
        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        this.setOpaque(false);
        this.setGraphic(actionListener,info, graphicType);
        // this.setPreferredSize(new Dimension(500,400));
    }

    private void setGraphic(ActionListener actionListener, HashMap<String, Object> info, char graphicType) {
        this.setContentPanel();
        if(UtilView.getHashMapValuesClass(info).equals(HashMap.class.getSimpleName())){
            System.out.println("Hashmap<String,HashMap<...>>");
            this.addGraphicCardsPanel(actionListener, info, graphicType);        
        }else{
            System.out.println("Hashmap<String,Double>");
            this.contentPanel.add(new JPSpecificCardPanel(actionListener, info, graphicType));
            this.setButtonCardPanel();
            this.add(this.buttonsPanel, BorderLayout.NORTH);
            this.add(this.contentPanel, BorderLayout.CENTER);
        }
    }

    private void setButtonCardPanel(){
        this.buttonsPanel = new JPanel();
        // this.buttonsPanel.setOpaque(false);
        this.buttonsPanel.setBackground(BUTTON_ACTION_COLOR);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        flowLayout.setHgap(5);
        flowLayout.setVgap(0);
        this.buttonsPanel.setLayout(flowLayout);
        // this.buttonsPanel.setMinimumSize(new Dimension(20,20));
        this.buttonsPanel.setPreferredSize(new Dimension(20,20));
        // this.buttonsPanel.setPreferredSize(new Dimension());
    }

    private void addButtonCardPanel(ActionListener actionListener) {
        this.setButtonCardPanel();
        // this.buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, -flowLayout.getHgap()));
        JButton beforeButton = new JButtonFormat(BEFORE_BUTTON_ICON_PATH, BUTTON_ACTION_COLOR, BUTTON_ACTION_DIMENSION);
        beforeButton.setOpaque(false);
        beforeButton.addActionListener(actionListener); 
        beforeButton.setActionCommand(Commands.BEFORE_GENERAL_CARD_GRAPHIC_REPORT.toString());
        this.buttonsPanel.add(beforeButton);

        JButton nextButton = new JButtonFormat(NEXT_BUTTON_ICON_PATH, BUTTON_ACTION_COLOR, BUTTON_ACTION_DIMENSION);
        nextButton.setOpaque(false);
        nextButton.addActionListener(actionListener); 
        nextButton.setActionCommand(Commands.NEXT_GENERAL_CARD_GRAPHIC_REPORT.toString());
        this.buttonsPanel.add(nextButton);
        this.add(this.buttonsPanel, BorderLayout.NORTH);
    }

    private void addGraphicCardsPanel(ActionListener actionListener, HashMap<String, Object> info, char graphicType) {
        addButtonCardPanel(actionListener);
        Iterator<Entry<String, Object>> it = info.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String,Object> entry = it.next();
            HashMap<String, Object> value = (HashMap<String,  Object>) entry.getValue();
            JPSpecificCardPanel specificCardPanel = new JPSpecificCardPanel(actionListener, entry.getKey(), 
                    value, graphicType);
            this.contentPanel.add(specificCardPanel);
        }
        this.layout.first(this.contentPanel);
        this.currentKeyComponent = 0;
        this.add(this.contentPanel);
    }

    public void setContentPanel() {
        this.contentPanel = new JPanel();
        this.contentPanel.setLayout(this.layout);
        this.contentPanel.setOpaque(false);
        // this.contentPanel.setPreferredSize(new Dimension(500,400));
    }

    public void addTitlePanel(){
        
    }

    public void showNextGeneralCard(){
        this.layout.next(this.contentPanel);;
        if(this.currentKeyComponent == this.contentPanel.getComponentCount()-1){
            this.currentKeyComponent = 0;
        }else
            this.currentKeyComponent++;
    }
    
    public void showPreviousGeneralCard(){
        this.layout.previous(this.contentPanel);;
        if(this.currentKeyComponent == 0){
            this.currentKeyComponent = this.contentPanel.getComponentCount()-1;
        }else
            this.currentKeyComponent--;
        
    }

    public void showNextCard(){
        ((JPSpecificCardPanel)(this.contentPanel.getComponent(this.currentKeyComponent))).showNextCard();
    }

    public void showPreviousCard(){
        ((JPSpecificCardPanel)(this.contentPanel.getComponent(this.currentKeyComponent))).showPreviousCard();
    }
}