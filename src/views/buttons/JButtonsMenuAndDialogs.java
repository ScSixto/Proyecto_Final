package views.buttons;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import views.UtilView;

public class JButtonsMenuAndDialogs extends JButton {

	private static final long serialVersionUID = 1L;

	public static final int DIMENSION_WHIDTH = 26;
	public static final int DIMENSION_HEIGHT = 26;

	public JButtonsMenuAndDialogs(String routeImage) {
		setPreferredSize(new Dimension(DIMENSION_WHIDTH, DIMENSION_HEIGHT));
		setIcon(UtilView.convertToIcon(routeImage, DIMENSION_WHIDTH,
				DIMENSION_HEIGHT));
		setOpaque(false);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public JButtonsMenuAndDialogs(String routeImage, int width, int heigth) {
		setPreferredSize(new Dimension(width, heigth));
		setIcon(UtilView.convertToIcon(routeImage, width, heigth));
		setOpaque(false);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public JButtonsMenuAndDialogs(String text, String routeImage, int width,
			int heigth, Color colorText) {
		setPreferredSize(new Dimension(width, heigth));
		setText(text);
		setFont(new Font("Calibri", Font.BOLD, 13));
		setForeground(colorText);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setIcon(UtilView.convertToIcon(routeImage, width - 20, heigth - 20));
		setOpaque(false);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public JButtonsMenuAndDialogs(String text, Color colorButton,
			Color colorText) {
		setText(text);
		setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		setBackground(colorButton);
		setFont(new Font("Calibri", Font.BOLD, 14));
		setForeground(colorText);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.CENTER);
		setFocusable(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}