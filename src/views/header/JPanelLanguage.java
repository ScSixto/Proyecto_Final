package views.header;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controllers.Commands;
import general.HandlerLanguage;
import views.ConstantsGUI;
import views.buttons.JButtonsMenuAndDialogs;

public class JPanelLanguage extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public static final int WHIDTH = 30;
	public static final int HEIGHT = 20;
	
	private JButtonsMenuAndDialogs spanishButton, englishButton;
	
	public JPanelLanguage(ActionListener actionListener) {
		setMinimumSize(new Dimension(250,160));
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(10, 25, 0, 5));
		GridLayout layout = new GridLayout(2,1);
		layout.setVgap(13);
		setLayout(layout);
		initComponents(actionListener);
	}

	
	private void initComponents(ActionListener actionListener) {
		spanishButton = new JButtonsMenuAndDialogs("resources/img/BanderaEspa"+ConstantsGUI.LOWERCASE_ACCENTED_N+"a.png",WHIDTH,HEIGHT);
		spanishButton.setToolTipText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.LANGUAGE_SPANISH));
		spanishButton.addActionListener(actionListener);
		spanishButton.setActionCommand(Commands.CHANGE_SPANISH.toString());
		add(spanishButton);
		
		englishButton = new JButtonsMenuAndDialogs("resources/img/BanderadelReinoUnido.png",WHIDTH,HEIGHT);
		englishButton.setToolTipText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.LANGUAGE_ENGLISH));
		englishButton.addActionListener(actionListener);
		englishButton.setActionCommand(Commands.CHANGE_ENGLISH.toString());
		add(englishButton);
	}
	
	public void changeLanguage() {
		spanishButton.setToolTipText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.LANGUAGE_SPANISH));
		englishButton.setToolTipText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.LANGUAGE_ENGLISH));
	}

}
