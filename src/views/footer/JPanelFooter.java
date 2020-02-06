package views.footer;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import views.ConstantsGUI;

public class JPanelFooter extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public JPanelFooter() {
		setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		setBackground(Color.decode("#49642e"));
		setPreferredSize(new Dimension((int)(ConstantsGUI.WIDTH*0.95),100));
	}

}
