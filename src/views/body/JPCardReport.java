package views.body;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.Commands;
import views.ConstantsGUI;
import views.JButtonFormat;
import views.UtilView;

public class JPCardReport extends JPanel{

    public static final long serialVersionUID = 1L;
    public static final String BEFORE_BUTTON_ICON_PATH = "resources/img/arrowLeft.png";
    public static final String NEXT_BUTTON_ICON_PATH = "resources/img/arrowRight.png";
    public static final Dimension BUTTON_ACTION_DIMENSION = new Dimension(20,20);
    public static final Color BUTTON_ACTION_COLOR = ConstantsGUI.COLOR_LINE;

    private CardLayout layout;
    private JPanel cardPanel;
    private JLabel titleLabel;
    private JPanel buttonsPanel;

    public JPCardReport(ActionListener actionListener) {
        this.layout = new CardLayout();
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
		this.setBackground(Color.MAGENTA);
        this.setOpaque(false);
        // this.setPreferredSize(new Dimension(500,400));
        // System.out.println("Si entra a constructorr");
    }

    public JPCardReport(ActionListener actionListener, HashMap<String, Object> info){
        this(actionListener);
        this.addCardPanel(actionListener, info);
    }

    public void setTitleLabel(String title){
        this.titleLabel = new JLabel(title);
        this.titleLabel.setOpaque(false);
        this.add(this.titleLabel, BorderLayout.NORTH);
        this.titleLabel.setVisible(true);
    }
	
    public void setCardPanel(){
        this.cardPanel = new JPanel();
        this.cardPanel.setLayout(this.layout);
        // this.cardPanel.setPreferredSize(new Dimension(300, 300));
    }

    public void addCardPanel(ActionListener actionListener,HashMap<String, Object> info){
        this.setCardPanel();
        if(UtilView.getHashMapValuesClass(info).equals(Double.class.getSimpleName())){
            ArrayList<HashMap<String, Object>> infoList = new ArrayList<>();
            if(info.values().size() > ConstantsGUI.GRAPHIC_MAX_DATA_QUANTITY){
                HashMap<String, Object> infoTemp = new HashMap<>();
                Iterator<Entry<String, Object>> it = info.entrySet().iterator();
                int i = 0;
                while (it.hasNext()){
                    infoTemp.clear();
                    for (int j = 0; j < UtilView.getShowingValueQuantity(info.values().size()) && it.hasNext(); j++) {
                        Entry<String, Object> entry = it.next();
                        infoTemp.put(entry.getKey(), entry.getValue());
                    }
                    infoList.add(infoTemp);
                    System.out.println(". infoListSize: " + infoList.get(i));
                    System.out.println(". infoList: " + infoList.get(i++).size());
                }
                this.addButtonsPanel(actionListener);
            }else{
                infoList.add(info);
            }
            this.addCardPanelComponents(actionListener, infoList);
        }
        this.add(this.cardPanel, BorderLayout.CENTER);
        
    }
    
    private void addCardPanelComponents(ActionListener actionListener, ArrayList<HashMap<String, Object>> infoList) {
        for(int i = 0; i < infoList.size(); i++) {
            this.cardPanel.add(new JPBarGraphicPanel(actionListener, UtilView.convertGraphicData(infoList.get(i))),infoList.get(i).toString());
            // this.layout.show(this.cardPanel, info.toString());
            // System.out.println("Si entra al add");
            // System.out.println("Madre santa:" + info.size());
            System.out.println("Esto es... esa vaina:"+infoList.get(i));
        }
        // this.layout.first(this.cardPanel);
    }
    
    public void addButtonsPanel(ActionListener act) {
        this.buttonsPanel = new JPanel();
        this.buttonsPanel.setOpaque(true);
        // this.buttonsPanel.setPreferredSize(new Dimension(200,50));
        FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);
        flowLayout.setHgap(5);
        flowLayout.setVgap(0);
        this.buttonsPanel.setLayout(flowLayout);
        this.buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, -flowLayout.getHgap()));

        JButton beforeButton = new JButtonFormat(BEFORE_BUTTON_ICON_PATH, BUTTON_ACTION_COLOR, BUTTON_ACTION_DIMENSION);
        beforeButton.addActionListener(act); 
        beforeButton.setActionCommand(Commands.BEFORE_CARD_GRAPHIC_REPORT.toString());
        this.buttonsPanel.add(beforeButton);

        JButton nextButton = new JButtonFormat(NEXT_BUTTON_ICON_PATH, BUTTON_ACTION_COLOR, BUTTON_ACTION_DIMENSION);
        nextButton.addActionListener(act); 
        nextButton.setActionCommand(Commands.NEXT_CARD_GRAPHIC_REPORT.toString());
        this.buttonsPanel.add(nextButton);

        this.add(this.buttonsPanel, BorderLayout.SOUTH);
    }

    public void showNextComponent(){
        this.layout.next(this.cardPanel);
    }

    public void showPreviousComponent(){
        this.layout.previous(this.cardPanel);
    }
}