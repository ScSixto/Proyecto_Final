package views.body;

import java.awt.CardLayout;

import javax.swing.JPanel;

import views.ConstantsGUI;

public class JPanelReportsCardLayout extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private CardLayout layout;
	
	public JPanelReportsCardLayout() {
		layout = new CardLayout();
		setLayout(layout);
		setOpaque(false);
		setVisible(true);
	}
	
	public void showCardImage(String key){
        switch(key){
            case ConstantsGUI.PANEL_INITIAL:
                this.layout.show(this, ConstantsGUI.PANEL_INITIAL);
                break;
				case ConstantsGUI.PANEL_GRAPHIC_BAR_CHART:
                break;
            case ConstantsGUI.PANEL_TABLE_REPORTS:
                break;
            case ConstantsGUI.PANEL_GRAPHIC_REPORTS:
                break;
        }
    }

}
