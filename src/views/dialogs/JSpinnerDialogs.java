package views.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import views.ConstantsGUI;

public class JSpinnerDialogs extends JSpinner{

	private static final long serialVersionUID = 1L;
	
	public static final int ACTUAL_YEAR = LocalDate.now().getYear();
	public static final int MINIMUM_YEAR = 2016;
	
	public JSpinnerDialogs(String title) {
		super(new SpinnerNumberModel(MINIMUM_YEAR, MINIMUM_YEAR, ACTUAL_YEAR, 1));
		setPreferredSize(new Dimension(10,10));
		changeLanguage(title);
		setUI(CustomUISpinner.createUI(this));
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
	
	public void cleanSpinner() {
		setValue(MINIMUM_YEAR);
	}

}
