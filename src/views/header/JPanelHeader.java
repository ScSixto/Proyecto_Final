package views.header;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelHeader extends JPanel {

	private static final long serialVersionUID = 1L;

	private Image backGraundImage;
	private JPanelCenter panelCenter;

	public JPanelHeader(ActionListener actionListener) {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(60, 20, 60, 20));
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
	}

	private void initComponents(ActionListener actionListener) {
		setBackGraund();
		panelCenter = new JPanelCenter(actionListener);
		add(panelCenter, BorderLayout.CENTER);
	}

	public void changeLanguage() {
		panelCenter.changeLanguage();
		// System.out.println(getWidth() + "anchoH");
		// System.out.println(getHeight() + "largoH");
	}

	private void setBackGraund() {
		backGraundImage = new ImageIcon("resources/img/fondo3.png").getImage();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(backGraundImage, 0, 0, getWidth(), getHeight(), this);
	}
}
