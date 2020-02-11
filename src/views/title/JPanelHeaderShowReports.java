package views.title;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import general.HandlerLanguage;
import views.ConstantsGUI;
import views.buttons.JButtonsMenuAndDialogs;

public class JPanelHeaderShowReports extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButtonsMenuAndDialogs buttonBack;
	private JLabel labelTitleReport;
	private String text;

	public JPanelHeaderShowReports(ActionListener actionListener, String command) {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		setBackground(ConstantsGUI.COLOR_LINE);
		initComponents(actionListener, command);
		setVisible(true);
	}

	private void initComponents(ActionListener actionListener, String command) {
		addButton(actionListener, command);
		addLabel(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_EIGHT);
	}

	public void addButton(ActionListener actionListener, String command) {
		buttonBack = new JButtonsMenuAndDialogs("resources/img/flecha.png", 50,
				50);
		buttonBack.addActionListener(actionListener);
		buttonBack.setActionCommand(command);
		add(buttonBack, BorderLayout.WEST);
	}

	public void setBackButtonCommand(String command) {
		buttonBack.setActionCommand(command);
	}

	public void addLabel(String title) {
		text = title;
		if (this.getComponents().length > 1)
			this.remove(this.getComponent(1));
		labelTitleReport = ConstantsGUI.createLabelTitleMenu(
				HandlerLanguage.languageProperties.getProperty(text),
				ConstantsGUI.COLOR_WHITE);
		labelTitleReport.setBorder(BorderFactory.createEmptyBorder(
				0,
				(int) ((-6.5 * HandlerLanguage.languageProperties.getProperty(
						text).length()) + 570), 0, 0));
		// labelTitleReport.setHorizontalTextPosition(SwingConstants.RIGHT);
		// labelTitleReport.setBackground(Color.DARK_GRAY);
		// labelTitleReport.setMinimumSize(new Dimension(500,50));
		// labelTitleReport.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		add(labelTitleReport, BorderLayout.CENTER);
	}

	public void changeLanguage() {
		// if(labelTitleReport != null)
		labelTitleReport.setText(ConstantsGUI.HTML_TAG_B/* +"<center>" */
				+ HandlerLanguage.languageProperties.getProperty(text));
		labelTitleReport.setBorder(BorderFactory.createEmptyBorder(
				0,
				(int) ((-6.5 * HandlerLanguage.languageProperties.getProperty(
						text).length()) + 570), 0, 0));
	}
}