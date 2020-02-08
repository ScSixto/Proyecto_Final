package views.body;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import general.HandlerLanguage;
import views.ConstantsGUI;

public class JPanelInitiation extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel labelTitle;
	private JLabel labelText;
	private JPanel panelYAxis;
	
	public JPanelInitiation(ActionListener actionListener) {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
	}
	
	public void initComponents(ActionListener actionListener) {
		panelYAxis = new JPanel();
		panelYAxis.setLayout(new BoxLayout(panelYAxis, BoxLayout.Y_AXIS));
		panelYAxis.setOpaque(false);
		add(panelYAxis);
		addInformation();
	}
	
	public void addInformation() {
		labelTitle = ConstantsGUI.createLabelTitles(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_PISCICULTURE));
//		labelTitle.setBackground(new Color(49,201,150,150));
		labelTitle.setOpaque(false);
		labelTitle.setForeground(ConstantsGUI.COLOR_PRESENTATION);
		//		panelYAxis.add(new JPanelTitle(labelTitle,true));
		addPanel(labelTitle);
		createLine();
		labelText = new JLabel("<html>"+ HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_OF_PISCICULTURE) + "</html>");
		labelText.setFont(new Font("Roboto", Font.PLAIN, 20));
		labelText.setForeground(ConstantsGUI.COLOR_BLACK);
//		labelText.setBackground(Color.WHITE);
//		labelText.setOpaque(true);
		addPanel(labelText);
	}
	
	public void changeLanguage() {
		labelTitle.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_PISCICULTURE));
		labelText.setText("<html>" + HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_OF_PISCICULTURE) + "</html>");
	}
	
	public void addPanel(JLabel label) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setOpaque(false);
		panel.add(label);
		panelYAxis.add(panel);
	}

	public void createLine() {
		JLabel line = new JLabel(ConstantsGUI.LINE);
		line.setFont(new Font("Roboto", Font.BOLD, 40));
		line.setForeground(ConstantsGUI.COLOR_LINE);
		line.setOpaque(true);
		addPanel(line);
	}
}