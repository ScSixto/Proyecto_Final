package views.header;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controllers.Commands;
import general.HandlerLanguage;
import views.ConstantsGUI;

public class JPanelMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final String SEPARATOR = " |";

	private JMenuBar menu;
	private JMenu reports;
	private JMenuItem tables,graphics,homePage,export,cultive;
//	private JButton homePage;
	

	// private JButton homePage;

	public JPanelMenu(ActionListener actionListenner) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		setOpaque(false);
		menu = new JMenuBar();
		menu.setOpaque(false);
		menu.setBorderPainted(false);
		initComponents(actionListenner);
		add(menu);
		getComponents();
	}

	private void initComponents(ActionListener actionListenner) {
		addHomePageOptions(actionListenner);
		addCultiveOptions(actionListenner);
		addExportOptions(actionListenner);
		addTableOptions(actionListenner);

	}

	private void addCultiveOptions(ActionListener actionListenner) {
		cultive = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_CULTIVE) + SEPARATOR);
		cultive.addActionListener(actionListenner);
		cultive.setActionCommand(Commands.PANEL_TABLE_CULTIVES.toString());
		cultive.setForeground(Color.WHITE);
		cultive.setPreferredSize(new Dimension(120, cultive.getHeight()));
		menu.add(cultive);
	}

	private void addExportOptions(ActionListener actionListenner) {
		export = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EXPORT) + SEPARATOR);
		export.addActionListener(actionListenner);
		export.setActionCommand(Commands.OPEN_DIALOG_EXPORT.toString());
		export.setForeground(Color.WHITE);
		export.setPreferredSize(new Dimension(Integer.parseInt(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_SIZE_EXPORT)),export.getHeight()));
		menu.add(export);
	}

	private void addHomePageOptions(ActionListener actionListenner) {
		homePage = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_HOMEPAGE) + SEPARATOR);
		homePage.addActionListener(actionListenner);
		homePage.setActionCommand(Commands.PANEL_INITIAL.toString());
		homePage.setForeground(Color.WHITE);
		homePage.setPreferredSize(new Dimension(Integer.parseInt(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_SIZE_HOMEPAGE)), homePage.getHeight()));
		menu.add(homePage);
	}

	private void addTableOptions(ActionListener actionListenner) {
		reports = createJMenu(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_REPORTS));
		tables = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TABLES));
		tables.addActionListener(actionListenner);
		tables.setActionCommand(Commands.TABLE_REPORTS.toString());
		reports.add(tables);
		graphics = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_GRAPHICS));
		graphics.addActionListener(actionListenner);
		graphics.setActionCommand(Commands.GRAPHIC_REPORTS.toString());
		reports.add(graphics);
		menu.add(reports);
	}

	public void changeLanguage() {
		cultive.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_CULTIVE) + SEPARATOR);
		export.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EXPORT) + SEPARATOR);
		export.setPreferredSize(new Dimension(Integer.parseInt(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_SIZE_EXPORT)),export.getHeight()));
		homePage.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_HOMEPAGE) + SEPARATOR);
		homePage.setPreferredSize(new Dimension(Integer.parseInt(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_SIZE_HOMEPAGE)),homePage.getHeight()));
		reports.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_REPORTS)+ SEPARATOR);
		tables.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TABLES));
		graphics.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_GRAPHICS));
	}

	private JMenu createJMenu(String text) {
		JMenu menuOptions = new JMenu(text + " |");
		menuOptions.setForeground(Color.WHITE);
		menuOptions.setOpaque(false);
		createFont(menuOptions);
		menuOptions.setCursor(new Cursor(Cursor.HAND_CURSOR));
		return menuOptions;
	}

	private JMenuItem createJMenuItem(String text) {
		JMenuItem item = new JMenuItem(text);
		item.setOpaque(false);
		createFont(item);
		item.setCursor(new Cursor(Cursor.HAND_CURSOR));
		return item;
	}
	
	private void createFont(Component component) {
		component.setFont((new Font("Roboto", Font.BOLD, 20)));
	}
}