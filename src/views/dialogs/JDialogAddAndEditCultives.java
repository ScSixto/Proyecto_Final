package views.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import views.JFramePrincipal;


public class JDialogAddAndEditCultives extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private JTextField id, firstName, secondName, lastName;
	private JComboBox<String> genders, teams;
	
	public JDialogAddAndEditCultives(JFramePrincipal frame,ActionListener actionListenner,String title, String routeImage,boolean editButtons) {
		setMinimumSize(new Dimension(400,500));
		getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		setIconImage(new ImageIcon(routeImage).getImage());
		setLocationRelativeTo(frame);
		setTitle(title);
		setModal(true);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
	}
	
	public JDialogAddAndEditCultives(JFramePrincipal frame) {
		setMinimumSize(new Dimension(600,300));
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
//		setIconImage(new ImageIcon(routeImage).getImage());
		setLocationRelativeTo(frame);
//		setTitle(title);
		setModal(false);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
	}
	
	
	

}
