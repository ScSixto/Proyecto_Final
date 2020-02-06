package views.body;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controllers.Commands;
import views.title.JPanelHeaderShowReports;

public class JPanelShowReports extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JPanelHeaderShowReports headerReports;
	
	public JPanelShowReports(ActionListener actionListener) {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		headerReports = new JPanelHeaderShowReports(actionListener,Commands.TABLE_REPORTS.toString());
		add(headerReports,BorderLayout.NORTH);
	}
	
	public void addLabel(String title) {
//		headerReports.emptyText();
		headerReports.addLabel(title);
	}
	
	public void changeLanguage() {
		headerReports.changeLanguage();
	}
	

}
