package views.body;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controllers.Commands;
import views.title.JPanelHeaderShowReports;

public class JPanelShowingTableReports extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanelHeaderShowReports headerReports;
	private JPanelTableWithComboBox tableBox;

	public JPanelShowingTableReports(ActionListener actionListener) {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
	}

	private void initComponents(ActionListener actionListener) {
		this.headerReports = new JPanelHeaderShowReports(actionListener, Commands.TABLE_REPORTS.toString());
		this.add(headerReports, BorderLayout.NORTH);
		this.tableBox = new JPanelTableWithComboBox(actionListener);
		this.add(tableBox, BorderLayout.CENTER);
		// this.circleGraphicPanel = new JPCircleGraphicPanel(actionListener);
		// this.add(this.circleGraphicPanel);
		// this.barGraphicPanel = new JPBarGraphicPanel(actionListener);
		// this.add(this.barGraphicPanel);
	}

	public void addLabel(String title) {
		// headerReports.emptyText();
		this.headerReports.addLabel(title);
	}

	public void changeLanguage() {
		this.headerReports.changeLanguage();
		this.tableBox.changeLanguage();
	}

	public void addItemsComboBox(Object[] items) {
		this.tableBox.addItemsComboBox(items);
	}

	public Object getItemComboBox() {
		return this.tableBox.getItemComboBox();
	}

	public void getInformationCultives(HashMap<String, ArrayList<Object[]>> info) {
		this.tableBox.getInformationCultives(info);
	}
}
