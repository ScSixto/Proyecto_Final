package views.title;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import views.ConstantsGUI;

public class JPanelTitle extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel panelY;

	public JPanelTitle(JLabel text) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBorder(BorderFactory.createEmptyBorder(0, 90, 0, 0));
		setOpaque(false);
		initComponents(text);
		setVisible(true);
	}

	private void initComponents(JLabel text) {
		panelY = new JPanel();
		panelY.setLayout(new BoxLayout(panelY, BoxLayout.Y_AXIS));
		panelY.setOpaque(false);
		panelY.add(text);
		panelY.add(createLine());
		add(panelY);
	}

	public JLabel createLine() {
		JLabel line = new JLabel(ConstantsGUI.LINE);
		line.setFont(new Font("Roboto", Font.BOLD, 40));
		line.setForeground(ConstantsGUI.COLOR_LINE);
		line.setOpaque(false);
		return line;
	}

}
