package views.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class JTextFieldDialogs extends JTextField{

	private static final long serialVersionUID = 1L;
	
	public JTextFieldDialogs(String title) {
		super(15);
		setPreferredSize(new Dimension(70,10));
		changeLanguage(title);
		setOpaque(false);
		setForeground(Color.WHITE);
		setFont(createFont(Font.PLAIN,15));
	}
	
	private Font createFont(int typeDecoration,int size) {
		return new Font("Roboto", typeDecoration,size);
	}
	
	public void changeLanguage(String title) {
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.WHITE, Color.WHITE)
		, title,TitledBorder.LEFT,TitledBorder.TOP,createFont(Font.BOLD,15),Color.WHITE));
	}
	
}
