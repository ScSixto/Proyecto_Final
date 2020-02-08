package views.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import views.ConstantsGUI;

public class JComboBoxDialogs extends JComboBox<String>{

	private static final long serialVersionUID = 1L;
	
	public JComboBoxDialogs(String title) {
		setPreferredSize(new Dimension(10,10));
		changeLanguage(title);
		setUI(CustomUI.createUI(this));
		setForeground(ConstantsGUI.COLOR_BLUE_HEADER);
		setFont(createFont(Font.PLAIN,15));
		setOpaque(false);
	}
	
	private Font createFont(int typeDecoration,int size) {
		return new Font("Roboto", typeDecoration,size);
	}
	
	public void changeLanguage(String title) {
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.WHITE, Color.WHITE)
				, title,TitledBorder.LEFT,TitledBorder.TOP,createFont(Font.BOLD,15),Color.WHITE));
	}
	
	
}
