package views.buttons;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import views.ConstantsGUI;
import views.UtilView;

public class JButtonOptionsReports extends JButton {

	private static final long serialVersionUID = 1L;
	public static final int WIDHT_AND_HEIGHT_LOGO = 70;

	public JButtonOptionsReports(String text, char logo) {
		// setPreferredSize(new Dimension(50,50));
		setText(ConstantsGUI.HTML_TAG_CENTER + text);
		setIconButton(logo);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 5, 20));
		setBackground(ConstantsGUI.COLOR_BUTTONS_REPORT);
		setFont(new Font("Roboto", Font.BOLD, 14));
		setForeground(ConstantsGUI.COLOR_BLACK);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setBorderPainted(false);
		setOpaque(false);
		setFocusable(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public JButtonOptionsReports(String text) {
		// setPreferredSize(new Dimension(50,50));
		setText(ConstantsGUI.HTML_TAG_CENTER + text);
		setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		setBackground(Color.WHITE);
		setFont(new Font("Roboto", Font.BOLD, 14));
		setForeground(ConstantsGUI.COLOR_BLUE_HEADER);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.CENTER);
		setBorderPainted(false);
		setOpaque(false);
		setFocusable(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public JButtonOptionsReports(String text, Color color) {
		// setPreferredSize(new Dimension(50,50));
		setText(ConstantsGUI.HTML_TAG_CENTER + text);
		setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		setBackground(color);
		setFont(new Font("Roboto", Font.BOLD, 14));
		setForeground(ConstantsGUI.COLOR_WHITE);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.CENTER);
		setBorderPainted(false);
		setOpaque(false);
		setFocusable(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void setIconButton(char logo) {
		switch (logo) {
		case ConstantsGUI.CIRCLE_GRAPHIC:
			setIcon(UtilView.convertToIcon("resources/img/diagramaTorta.png",
					WIDHT_AND_HEIGHT_LOGO, WIDHT_AND_HEIGHT_LOGO));
			break;
		case ConstantsGUI.BAR_GRAPHIC:
			setIcon(UtilView.convertToIcon("resources/img/diagramaBarras.png",
					WIDHT_AND_HEIGHT_LOGO, WIDHT_AND_HEIGHT_LOGO));
			break;
		case ConstantsGUI.TABLE_REPORT:
			setIcon(UtilView.convertToIcon("resources/img/tablaBoton.png",
					WIDHT_AND_HEIGHT_LOGO, WIDHT_AND_HEIGHT_LOGO));
			break;
		default:
			setIcon(UtilView.convertToIcon("resources/img/diagramaPuntos.png",
					WIDHT_AND_HEIGHT_LOGO, WIDHT_AND_HEIGHT_LOGO));
			break;

		}
	}

	public void setNewText(String text) {
		this.setText(ConstantsGUI.HTML_TAG_CENTER + text);
	}

	protected void paintComponent(Graphics g) {
		Dimension arcs = new Dimension(20, 20);
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.setColor(getBackground());
		graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width,
				arcs.height);
		graphics.setColor(this.getBackground());
		graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width,
				arcs.height);
		super.paintComponent(g);
	}
}
