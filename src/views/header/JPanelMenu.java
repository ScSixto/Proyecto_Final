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


public class JPanelMenu extends JPanel{

	private static final long serialVersionUID = 1L;
	public static final String SEPARATOR = " |";
	
	private JMenuBar menu;
	private JMenu export,reports;
	private JMenuItem invalidRunners,tables,graphics,homePage,cultive;
//	private JButton homePage;
	
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
	
//	private void addLogo() {
//		JPanel panelsito = new JPanel();
//		panelsito.setOpaque(false);
//		JLabel labelLogo = new JLabel();
//		labelLogo.setIcon(ConstantsGUI.convertToIcon("resources/img/logo.png",170,170));
//		labelLogo.setOpaque(false);
//		panelsito.add(labelLogo);
//		panelsito.setVisible(true);
//	}
	
	private void addCultiveOptions(ActionListener actionListenner) {
		cultive = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_CULTIVE)+SEPARATOR);
		cultive.addActionListener(actionListenner);
		cultive.setActionCommand(Commands.PANEL_TABLE_CULTIVES.toString());
		cultive.setForeground(Color.WHITE);
		cultive.setPreferredSize(new Dimension(110,cultive.getHeight()));
		menu.add(cultive);
	}
	
	
	private void addExportOptions(ActionListener actionListenner) {
		export = createJMenu(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EXPORT));
		invalidRunners = createJMenuItem("Corredores no validos");
//		invalidRunners.addActionListener(actionListenner);
//		invalidRunners.setActionCommand(Actions.EXPORT.toString());
		export.add(invalidRunners);
		menu.add(export);
	}
	
	private void addHomePageOptions(ActionListener actionListenner) {
		homePage = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_HOMEPAGE) + SEPARATOR);
		homePage.addActionListener(actionListenner);
		homePage.setActionCommand(Commands.PANEL_INITIAL.toString());
		homePage.setForeground(Color.WHITE);
		homePage.setPreferredSize(new Dimension(Integer.parseInt(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_SIZE_HOMEPAGE)),homePage.getHeight()));
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
	
//	private JButton createJButton(String text) {
//		JButton button = new JButton(text);
//		button.setOpaque(false);
//		button.setBorderPainted(false);
//		button.setContentAreaFilled(false);
//		button.addMouseMotionListener(null);
//		button.addMouseWheelListener(null);
//		button.repaint();
//		createFont(button);
//		return button;
//	}
	
	private void createFont(Component component) {
		component.setFont((new Font("Roboto", Font.BOLD,20)));
	}
}