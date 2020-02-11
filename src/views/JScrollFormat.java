package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class JScrollFormat extends BasicScrollBarUI {

	@Override
	protected JButton createDecreaseButton(int orientation) {
		JButton emptyButton = new JButton();
		emptyButton.setPreferredSize(new Dimension(0, 0));
		return emptyButton;
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		JButton emptyButton = new JButton();
		emptyButton.setPreferredSize(new Dimension(0, 0));
		return emptyButton;
	}

	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
	}

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		// JScrollBar sb = (JScrollBar) c;
		g2.setPaint(ConstantsGUI.COLOR_SCROLL_GRAY);
		g2.fillRoundRect(r.x, r.y, r.width, r.height, 5, 5);
		/*
		 * g2.setPaint(Color.YELLOW); g2.drawRoundRect(r.x, r.y, r.width,
		 * r.height, 10, 10);
		 */
		g2.dispose();
	}

	@Override
	protected void setThumbBounds(int x, int y, int width, int height) {
		super.setThumbBounds(x, y, width, height);
		scrollbar.repaint();
	}
}
