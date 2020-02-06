package views.body;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import general.HandlerLanguage;
import views.ConstantsGUI;

public class JPanelTable extends JPanel{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtmElements;
	private JTable jtElements;
	private JScrollPane jsTable;

	public JPanelTable(){
		setOpaque(false);
		initComponents();
		setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		setVisible(true);
	}

	private void initComponents() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Color.decode("#30373D"));
		dtmElements = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			@Override
		    public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
		};

		Font fontHeader = new Font("Franklin Gothic Demi", Font.ITALIC,15);
		
		jtElements = new JTable();
		jtElements.setModel(dtmElements);
		jtElements.setFont(new Font("Arial", Font.PLAIN,15));
		jtElements.getTableHeader().setReorderingAllowed(false);
		jtElements.getTableHeader().setForeground(Color.white);
		jtElements.getTableHeader().setFont(fontHeader);
		jtElements.setBackground(Color.white);
		jtElements.setFillsViewportHeight(true);
		jtElements.setBorder(null);
		jtElements.setRowHeight(25);
		
		jsTable = new JScrollPane(jtElements);
		jsTable.setForeground(Color.white);
		// jsTable.getVerticalScrollBar().setUI(new JScrollFormat());
		// jsTable.getHorizontalScrollBar().setUI(new JScrollFormat());		
		jsTable.setBorder(null);
		jsTable.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(jsTable);
		this.setBorder(null);
		
	}
	
	public void addRunnerList(ArrayList<Object[]> info) {
		for (Object[] objects : info) {
			dtmElements.addRow(objects);
		}
	}
	
	public void showTableCultives(HashMap<String, ArrayList<Object[]>> info) {
		setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		cleanRowsTable();
		jtElements.getTableHeader().setBackground(ConstantsGUI.COLOR_LINE);
		changeLanguageTableCultives();
		stringFormat(info);
		this.setPreferredSize(new Dimension((int)(ConstantsGUI.WIDTH * 0.12),(int)(ConstantsGUI.HEIGHT*0.6)));
	}
	
	public void changeLanguageTableCultives() {
		String[] header = new String[] {ConstantsGUI.ID,HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TOWN),
				HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_YEAR),
				HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_SPECIE),
				HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_CULTIVATED_QUANTITY),
				HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_HARVESTED_QUANTITY),
				HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TOTAL_CULTIVE_WEIGHT_KG),
				HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TOTAL_CULTIVE_PRICE)};
		dtmElements.setColumnIdentifiers(header);
		setColumnWidth();
//		this.setPreferredSize(new Dimension((int)(ConstantsGUI.WIDTH * 0.12),(int)(ConstantsGUI.HEIGHT*0.5)));
	}
		
    private void setColumnWidth(){
		int[] columWidthArray = new int[]{15,150,20,150,80,80,110,100};
        for(int i = 0; i < columWidthArray.length; i++){
            jtElements.getColumnModel().getColumn(i).setPreferredWidth(columWidthArray[i]);
        }
    }

	
//	public void updateTable() {
//		dtmElements.fireTableDataChanged();
//	}
	
	@SuppressWarnings("unchecked")
	public void stringFormat(ArrayList<Object[]> info, int quantityColumns) {
		ArrayList<Object[]> arrayFormat = new ArrayList<Object[]>();
		int j = 0;
		for (Object[] objects : info) {
			int i = 1;
			Object[] vector = new Object[quantityColumns];
			for (Object[] objectsCultive : ((ArrayList<Object[]>) objects[2])) {
				vector[0] = j++ +"-" + objects[1];
				vector[i] = objectsCultive[i];
				arrayFormat.add(vector);
				if(i == objectsCultive.length-1)
					break;
				i++;
			}
		}
		addRunnerList(arrayFormat);
	}
	
	private void cleanRowsTable() {
		dtmElements.setNumRows(0);
	}
	
	private void stringFormat(HashMap<String, ArrayList<Object[]>> info) {
		ArrayList<Object[]> arrayFormat = new ArrayList<Object[]>();
		Iterator<Entry<String, ArrayList<Object[]>>> it = info.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<String, ArrayList<Object[]>> pair = it.next();
	        for (Object[] object : pair.getValue()) {
	        	int i = 0;
	        	arrayFormat.add(new Object[] {object[i],pair.getKey(),object[++i],object[++i],object[++i],object[++i],object[++i],object[++i]});
			}
	        it.remove(); 
	    }
		addRunnerList(arrayFormat);
	}
	
}