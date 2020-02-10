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
import javax.swing.SwingConstants;

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
        this.setOpaque(false);
        // this.setPreferredSize(new Dimension(500,400));
        // System.out.println("Si entra a constructorr");
    }

    public JPCardReport(ActionListener actionListener, HashMap<String, Object> info, char graphicType){
        this(actionListener);
        this.addCardPanel(actionListener, info, graphicType);
        // this.setPreferredSize(new Dimension(500,400));
        // System.out.println("Hola si entra");
    }

    public void setTitleLabel(String title){
        this.titleLabel = new JLabel(title);
        this.titleLabel.setOpaque(false);
        this.titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        this.add(this.titleLabel, BorderLayout.NORTH);
    }
	
    public void setCardPanel(){
        this.cardPanel = new JPanel();
        this.cardPanel.setLayout(this.layout);
        this.cardPanel.setOpaque(false);
        // this.cardPanel.setPreferredSize(new Dimension(500,400));
    }

    public void addCardPanel(ActionListener actionListener,HashMap<String, Object> info, char graphicType){
        this.setCardPanel();
        ArrayList<HashMap<String, Object>> infoList = new ArrayList<>();
        if(UtilView.getHashMapValuesClass(info).equals(Double.class.getSimpleName())){
            if(info.values().size() > ConstantsGUI.GRAPHIC_MAX_DATA_QUANTITY){
                HashMap<String, Object> infoTemp = new HashMap<>();
                Iterator<Entry<String, Object>> it = info.entrySet().iterator();
                while (it.hasNext()){
                    infoTemp = new HashMap<>();
                    for (int j = 0; j < UtilView.getShowingValueQuantity(info.values().size()) && it.hasNext(); j++) {
                        Entry<String, Object> entry = it.next();
                        infoTemp.put(entry.getKey(), entry.getValue());
                    }
                    infoList.add(infoTemp);
                }
                this.addButtonsPanel(actionListener);
            }else{
                infoList.add(info);
            }
            this.addCardPanelComponents(actionListener, infoList, graphicType);
        }
        this.add(this.cardPanel, BorderLayout.CENTER);
    }
    
    private void addCardPanelComponents(ActionListener actionListener, ArrayList<HashMap<String, Object>> infoList,char graphicType) {
        for(int i = 0; i < infoList.size(); i++) {
            switch (graphicType) {
                case ConstantsGUI.BAR_GRAPHIC:
                    this.cardPanel.add(new JPBarGraphicPanel(actionListener, UtilView.convertGraphicData(infoList.get(i))),infoList.get(i).toString());
                    break;
                case ConstantsGUI.CIRCLE_GRAPHIC:
                    this.cardPanel.add(new JPCircleGraphicPanel(actionListener, UtilView.convertGraphicData(infoList.get(i))),infoList.get(i).toString());
                    break;
                case ConstantsGUI.POINT_GRAPHIC:
                    this.cardPanel.add(new JPPointGraphicPanel(actionListener, UtilView.convertGraphicData(infoList.get(i))),infoList.get(i).toString());
                    break;
                default:
                    this.cardPanel.add(new JPBarGraphicPanel(actionListener, UtilView.convertGraphicData(infoList.get(i))),infoList.get(i).toString());
                    break;
            }
        }
    }
    
    public void addButtonsPanel(ActionListener act) {
        this.buttonsPanel = new JPanel();
        this.buttonsPanel.setOpaque(false);
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

    public void showNextCard(){
        this.layout.next(this.cardPanel);
    }

    public void showPreviousCard(){
        this.layout.previous(this.cardPanel);
    }
}