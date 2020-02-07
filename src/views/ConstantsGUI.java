package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Toolkit;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class ConstantsGUI {
	// Vaores de la pantalla
	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int MAXIMUM_SCREEN_WIDTH = (int) SCREEN_SIZE.getWidth();
	public static final int MAXIMUM_SCREEN_HEIGHT = (int) SCREEN_SIZE.getHeight();

	public static final String TITLE_PROGRAM = "Title_Window";
	public static final String T_CULTIVE = "Cultive";
	public static final String T_ADD = "Add";
	public static final String T_DELETE = "Delete";
	public static final String T_EDIT = "Edit";
	public static final String T_LANGUAGE = "Language";
	public static final String LANGUAGE_SPANISH = "Spanish";
	public static final String LANGUAGE_ENGLISH = "English";
	public static final String T_PISCICULTURE = "Pisciculture";
	public static final String T_OPTIONS = "Options";
	public static final String T_EXPORT = "Export";
	public static final String T_EXIT = "Exit";
	public static final String T_HOMEPAGE = "HomePage";
	public static final String T_CONFIRMATION = "Confirmation";
	public static final String T_MESSAGE_END_PROGRAM = "Message_End_Program";
	public static final String T_MESSAGE_CONFIRMATION_END_PROGRAM = "Message_Confirmation_End_Program";
	public static final String T_TOWN = "Town";
	public static final String T_YEAR = "Year";
	public static final String T_SPECIE = "Specie";
	public static final String T_CULTIVATED_QUANTITY = "Cultivated_Quantity";
	public static final String T_HARVESTED_QUANTITY = "Harvested_Quantity";
	public static final String T_TOTAL_CULTIVE_WEIGHT_KG = "Total_Cultive_Weight";
	public static final String T_TOTAL_CULTIVE_PRICE = "Total_Cultive_Price";
	public static final String T_REPORTS = "Reports";
	public static final String T_TABLES = "Tables";
	public static final String T_TEXT_OF_PISCICULTURE = "Text_Of_Pisciculture";
	public static final String T_TITLE_TABLE_CULTIVES = "Title_Table_Cultives";
	public static final String T_GRAPHICS = "Graphics";
	public static final String T_SIZE_HOMEPAGE = "Size_HomePage";
	public static final String T_SELECT_OPTION = "Select_Option";
	// Titulos de Gráficos
	public static final String GRAPHIC_TITLE_CULTIVATED_FISHES_PER_YEAR = "Cultivated_Fishes_Per_Year";
	public static final String T_TITLE_REPORT_GRAPHICS = "Title_Report_Graphics";
	public static final String T_TITLE_REPORT_TABLES = "Title_Report_Tables";
	public static final String T_TEXT_REPORT_GRAPHICS_ONE = "Text_Report_Graphics_One";
	public static final String T_TEXT_REPORT_GRAPHICS_TWO = "Text_Report_Graphics_Two";
	public static final String T_TEXT_REPORT_GRAPHICS_THREE = "Text_Report_Graphics_Three";
	public static final String T_TEXT_REPORT_GRAPHICS_FOUR = "Text_Report_Graphics_Four";
	public static final String T_TEXT_REPORT_GRAPHICS_FIVE = "Text_Report_Graphics_Five";
	public static final String T_TEXT_REPORT_GRAPHICS_SIX = "Text_Report_Graphics_Six";
	public static final String T_TEXT_REPORT_GRAPHICS_SEVEN = "Text_Report_Graphics_Seven";
	public static final String T_TEXT_REPORT_GRAPHICS_EIGHT = "Text_Report_Graphics_Eight";
	public static final String T_TEXT_REPORT_GRAPHICS_NINE = "Text_Report_Graphics_Nine";
	public static final String T_TEXT_REPORT_GRAPHICS_TEN = "Text_Report_Graphics_Ten";
//	public static final String T_HOMEPAGE_LENGHT = "Home_Page_Length";

    public static final char LOWERCASE_ACCENTED_N = (char) 241;
    public static final char LOWERCASE_ACCENTED_A = (char) 225;
    public static final char LOWERCASE_ACCENTED_E = (char) 233;
    public static final char LOWERCASE_ACCENTED_I = (char) 237;
    public static final char LOWERCASE_ACCENTED_O = (char) 243;
    public static final char LOWERCASE_ACCENTED_U = (char) 250;
    public static final char EM_DASH = (char) 8212;
	
	public static final String ID = "Id";
	public static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final double HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
//Botones dialogos de confirmacion
	public static final String BUTTON_YES = "Yes_Button";
	public static final String BUTTON_NO = "No_Button";
	public static final String BUTTON_ACCEPT = "Accept_Button";
	
	// public static final Color COLOR_BACKGRAUND = Color.decode("#cdd3f9");
	// public static final Color COLOR_PRESENTATION = Color.BLUE;//Color.decode("#333333");
	public static final Color COLOR_BACKGRAUND = Color.decode("#f2f2f2");
	public static final Color COLOR_PRESENTATION = Color.decode("#333333");
	public static final Color COLOR_LINE = Color.decode("#17a788");
	public static final Color COLOR_WHITE = Color.WHITE;
	//public static final Color COLOR_PRESENTATION = Color.decode("#E77714");
	public static final Color COLOR_BACKGRAUND_SIXTO = Color.decode("#ffffff");
	//public static final String COLOR_PRESENTATION_SIXTO = "#E77714";
	public static final Color COLOR_BLACK = Color.BLACK;
	public static final Paint COLOR_SCROLL_GRAY = Color.decode("#444444");

	
//nombre paneles cardlayout
	public static final String PANEL_INITIAL = "Panel Presentation";
	public static final String PANEL_TABLE_CULTIVES = "Panel Cultives";
	public static final String PANEL_SHOW_TABLE_REPORTS = "Panel Show Table Reports";
	public static final String PANEL_TABLE_REPORTS = "Panel Table Reports";
	public static final String PANEL_SHOW_GRAPHIC_REPORTS = "Panel Show Graphic Report";
	public static final String PANEL_GRAPHIC_REPORTS = "Panel Graphics Reports";
	public static final String PANEL_GRAPHIC_BAR_CHART = "Panel Bar Chart";
	
//adiciones
	public static final String LINE = EM_DASH + "" + EM_DASH + "" + EM_DASH + "" + EM_DASH + "" + EM_DASH + "" + EM_DASH + "" + EM_DASH + "" + EM_DASH + "" + EM_DASH + "" + EM_DASH;
	public static final String HTML_TAG_CENTER= "<html><center>";
	public static final String HTML_TAG_B= "<html><b>";
	public static final String TOWN_BRICENIO_CORRECT= "BRICE�O";
	public static final String TOWN_BRICENIO_INCORRECT= "BRICEÑO";

//Tipos de Graficas
	public static final char BAR_GRAPHIC = 'B';
	public static final char CIRCLE_GRAPHIC = 'C';
	public static final char POINT_GRAPHIC = 'P';
	public static final char TABLE_REPORT = 'T';


//Valores gráfica de barras
	public static final Color DEFAULT_AXIS_COLOR = ConstantsGUI.COLOR_BLACK;
	public static final int MAX_PIXEL_COL_HEIGHT_VALUE = 300;
	public static final int MAX_PIXEL_COL_WIDTH_VALUE = 25;
	public static final int AXIS_LINE_WIDTH = 1;
	public static final int COL_SEPARATION = 5;
	public static final int Y_AXIS_VALUE_QUANTITY = 5;
	public static final Font DATA_LABEL_FONT = new Font("Arial",Font.PLAIN,9);
	public static final int Y_AXIS_LABEL_WIDTH = 30;
	public static final int INFORMATION_CIRCLE_DIAMETER = 15;
	public static final int INFORMATION_CIRCLE_ANGLE = 45;
	public static final int INFORMATION_CIRCLE_SEPARATION = 15;
	public static final int INFORMATION_CIRCLE_LABEL_SEPARATION = 5;
	public static final Font TITLE_GRAPHIC_FONT = new Font("Arial", Font.BOLD, 15);
	public static final Color TITLE_GRAPHIC_FOREGROUND = ConstantsGUI.COLOR_BLACK;
	public static final int CIRCLE_GRAPHIC_RADIOUS = 150;
	public static final double CIRCLE_GRAPHIC_MAX_ANGLE = 360;
	public static final int CIRCLE_GRAPHIC_OVAL_SPACE = 6;
	
	public static Icon convertToIcon(String route, int width, int heigth) {
		ImageIcon icon = new ImageIcon(route);
		Icon scaleIcon = new ImageIcon(icon.getImage().getScaledInstance(width,heigth, Image.SCALE_SMOOTH));
		return scaleIcon;
	}
	
	public static JLabel createLabelTitles(String text) {
		JLabel label = new JLabel(text);
		label.setFont(new Font("Roboto", Font.ITALIC, 50));
		label.setForeground(ConstantsGUI.COLOR_PRESENTATION);
		return label;
	}
	
	public static JLabel createLabelTitleMenu(String text) {
		JLabel label = new JLabel(HTML_TAG_B+text);
		label.setFont(new Font("Roboto", Font.ITALIC, 30));
		label.setForeground(COLOR_WHITE);
		return label;
	}
	
}