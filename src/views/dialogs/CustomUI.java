package views.dialogs;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

import views.ConstantsGUI;
public class CustomUI extends BasicComboBoxUI{
    
    
    public static ComboBoxUI createUI(JComponent c) {
        return new CustomUI();
    }

    @Override 
    protected JButton createArrowButton() {        
        BasicArrowButton basicArrowButton = new BasicArrowButton(BasicArrowButton.SOUTH, //Direccion de la flecha
                ConstantsGUI.COLOR_BLUE_HEADER, //Color de fondo
                ConstantsGUI.COLOR_WHITE,//sombra
                ConstantsGUI.COLOR_WHITE,//darkShadow
                ConstantsGUI.COLOR_BLUE_HEADER //highlight
                );         
        basicArrowButton.setBorder(BorderFactory.createLineBorder(ConstantsGUI.COLOR_BLUE_HEADER,2));
        basicArrowButton.setContentAreaFilled(false);        
        return basicArrowButton;
    }        
    
    @Override
    public void paintCurrentValueBackground(Graphics g,
                               Rectangle bounds,
                               boolean hasFocus)
    {
        g.setColor( ConstantsGUI.COLOR_BLUE_HEADER );            
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }
      
    @SuppressWarnings({ "serial", "rawtypes" })
	@Override
    protected ListCellRenderer createRenderer()
    {
        return new DefaultListCellRenderer() {      
		


		@Override
        public Component getListCellRendererComponent(JList list,Object value,int index,
          boolean isSelected,boolean cellHasFocus) {
      
        super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
        list.setSelectionBackground(ConstantsGUI.COLOR_WHITE);
        if (isSelected)
        {
            setBackground( ConstantsGUI.COLOR_BLUE_HEADER );
            setForeground(Color.WHITE);
        }
        else
        {
            setBackground( Color.WHITE );            
            setForeground( ConstantsGUI.COLOR_BLUE_HEADER);
        }
        return this;
      }
     };
    }
}