package views.body;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import views.ConstantsGUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class JLInformationLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	private Color color;

	public JLInformationLabel(String text, Color color) {
		super(text);
		// this.setMinimumSize(new
		// Dimension(ConstantsGUI.INFORMATION_CIRCLE_DIAMETER,ConstantsGUI.INFORMATION_CIRCLE_DIAMETER));
		// this.setPreferredSize(new
		// Dimension(ConstantsGUI.INFORMATION_CIRCLE_DIAMETER,ConstantsGUI.INFORMATION_CIRCLE_DIAMETER));
		this.setFont(ConstantsGUI.DATA_LABEL_FONT);
		this.setHorizontalTextPosition(SwingConstants.LEFT);
		this.setVerticalTextPosition(SwingConstants.CENTER);
		this.setOpaque(false);
		this.color = color;
		this.setBorder(BorderFactory.createEmptyBorder(
				(ConstantsGUI.INFORMATION_CIRCLE_DIAMETER / 6),
				ConstantsGUI.INFORMATION_CIRCLE_DIAMETER
						+ ConstantsGUI.INFORMATION_CIRCLE_LABEL_SEPARATION,
				ConstantsGUI.INFORMATION_CIRCLE_SEPARATION, 0));
	}

	public void paint(final Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(this.color);
		g2.fillRoundRect(0, 0, ConstantsGUI.INFORMATION_CIRCLE_DIAMETER,
				ConstantsGUI.INFORMATION_CIRCLE_DIAMETER,
				ConstantsGUI.INFORMATION_CIRCLE_ANGLE,
				ConstantsGUI.INFORMATION_CIRCLE_ANGLE);
		g2.setColor(ConstantsGUI.COLOR_BLACK);
		g2.drawRoundRect(0, 0, ConstantsGUI.INFORMATION_CIRCLE_DIAMETER,
				ConstantsGUI.INFORMATION_CIRCLE_DIAMETER,
				ConstantsGUI.INFORMATION_CIRCLE_ANGLE,
				ConstantsGUI.INFORMATION_CIRCLE_ANGLE);
		super.paint(g2);
	}
}