package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Toolkit;
import java.awt.Font;

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
	public static final String T_ERROR = "Error";
	public static final String T_WARNING = "Warning";
	public static final String T_TOWN = "Town";
	public static final String T_YEAR = "Year";
	public static final String T_SPECIE = "Specie";
	public static final String T_CULTIVATED_QUANTITY = "Cultivated_Quantity";
	public static final String T_HARVESTED_QUANTITY = "Harvested_Quantity";
	public static final String T_TOTAL_CULTIVE_WEIGHT_KG = "Total_Cultive_Weight";
	public static final String T_AVERAGE_CULTIVE_WEIGHT_G = "Average_Cultive_Weight";
	public static final String T_GET_ID_CULTIVE = "Get_Id_Cultive";
	public static final String T_TOTAL_CULTIVE_PRICE = "Total_Cultive_Price";
	public static final String T_REPORTS = "Reports";
	public static final String T_TABLES = "Tables";
	public static final String T_TEXT_OF_PISCICULTURE = "Text_Of_Pisciculture";
	public static final String T_TITLE_TABLE_CULTIVES = "Title_Table_Cultives";
	public static final String T_GRAPHICS = "Graphics";
	public static final String T_SIZE_HOMEPAGE = "Size_HomePage";
	public static final String T_SIZE_EXPORT = "Size_Export";
	public static final String T_SELECT_OPTION = "Select_Option";
	public static final String T_COPY_RIGHT = "Copyright";
//	Mensajes Excepciones y otros
	public static final String MESSAGE_NUMBER_FORMAT_EXCEPTION = "Message_NumberFormatException";
	public static final String MESSAGE_EMPTY_FIELDS_EXCEPTION = "Message_Empty_Fields_Exception";
	public static final String MESSAGE_UNFOUND_EXCEPTION = "Message_Unfound_Object_Exception";
	public static final String MESSAGE_NUMBER_NEGATIVE_EXCEPTION = "Message_Number_Negative_Exception";
	public static final String MESSAGE_CONFIRMATION_ADD_CULTIVE = "Message_Confirmation_Cultive";
	public static final String MESSAGE_QUESTION_EDIT_CULTIVE = "Message_Question_Edit_Cultive";
	public static final String MESSAGE_CONFIRMATION_EDIT_CULTIVE = "Message_Confirmation_Edit_Cultive";
	public static final String MESSAGE_QUESTION_DELETE_CULTIVE = "Message_Question_Delete_Cultive";
	public static final String MESSAGE_CONFIRMATION_DELETE_CULTIVE = "Message_Confirmation_Delete_Cultive";
	public static final String T_MESSAGE_END_PROGRAM = "Message_End_Program";
	public static final String T_MESSAGE_CONFIRMATION_END_PROGRAM = "Message_Confirmation_End_Program";
	
	
	// Titulos de GrÃ¡ficos
	public static final String GRAPHIC_TITLE_CULTIVATED_AND_HARVESTED_FISHES_PER_YEAR = "Graphic_Title_Cultivated_Fishes_Per_Year";
	public static final String GRAPHIC_TITLE_HARVESTED_FISHES_PER_TOWN_PER_YEAR = "Graphic_Title_Harvested_Fishes_Per_Town_Per_Year";
	public static final String GRAPHIC_TITLE_CULTIVATED_FISHES_SPECIES_KG_PER_YEAR = "Graphic_Title_Harvested_Fishes_species_Kg_Per_Year";
	public static final String GRAPHIC_TITLE_TOWN_EARNINGS_PER_YEAR = "Graphic_Title_Town_Earnings_Per_Year";
	public static final String GRAPHIC_TITLE_SPECIES_WEIGHT = "Graphic_Title_Species_Weight";
	public static final String GRAPHIC_TITLE_FISH_FOOD_USING = "Graphic_Title_Fish_Food_Using";
	public static final String GRAPHIC_TITLE_WATER_TYPE_USING = "Graphic_Title_Water_Type_Using";
	
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
	public static final String BUTTON_CANCEL = "Cancel_Option";
	public static final String BUTTON_SEARCH = "Button_Search";
	public static final int YES_OPTION = 1;
	public static final int NO_OPTION = 0;
	
	// public static final Color COLOR_BACKGRAUND = Color.decode("#cdd3f9");
	// public static final Color COLOR_PRESENTATION = Color.BLUE;//Color.decode("#333333");
	public static final Color COLOR_BUTTONS_REPORT = Color.decode("#A2E0D7");
	public static final Color COLOR_BACKGRAUND = Color.decode("#f2f2f2");
	public static final Color COLOR_PRESENTATION = Color.decode("#333333");
	public static final Color COLOR_LINE = Color.decode("#17a788");
	public static final Color COLOR_WHITE = Color.WHITE;
	public static final Color COLOR_BACKGRAUND_SIXTO = Color.decode("#ffffff");
	public static final Color COLOR_BLACK = Color.BLACK;
	public static final Color COLOR_BLUE_HEADER = Color.decode("#1e3a45");
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
	public static final String HTML_TAG= "<html>";
	public static final String HTML_TAG_CENTER= "<html><center>";
	public static final String HTML_TAG_B= "<html><b>";
	public static final String TOWN_BRICENIO_CORRECT= "Briceño";
	public static final String TOWN_BRICENIO_INCORRECT= "BRICEÃ‘O";
	public static final String EMPTY= "";
	public static final String PISCICULTURE_TEXT= "Pisciculture";
	public static final double GRAMS_BY_KILOGRAM = 1000;
	public static final String INFORMATION_CREATOR_ONE = "<b>Sebastian Felipe Sanchez Hurtado</b><br>&nbsp;&nbsp;- Facebook: Sebastian Hurtado<br>&nbsp;&nbsp;- Instagram: sebasanchez1392<br>&nbsp;&nbsp;- Telfono: +57 3112412731<br>&nbsp;&nbsp;- Correo: sebastian.sanchez02@uptc.edu.co";
	public static final String INFORMATION_CREATOR_TWO = "<br><b>Sixto Alberto Santamaria Carreño</b><br>&nbsp;&nbsp;- Facebook: S.c. Sixto<br>&nbsp;&nbsp;- Instagram: S.c. Sixto<br>&nbsp;&nbsp;- Telefono: +57 3157350111<br>&nbsp;&nbsp;- Correo: sixto.santamaria@uptc.edu.co";
	
//Tipos de Graficas
	public static final char BAR_GRAPHIC = 'B';
	public static final char CIRCLE_GRAPHIC = 'C';
	public static final char POINT_GRAPHIC = 'P';
	public static final char TABLE_REPORT = 'T';
//Tipo de ventana
	public static final char WARNING = 'W';
	public static final char CONFIRMATION = 'C';
	public static final char ERROR = 'E';
//Coordenadas botones
	public static final int UBICATION_X_BUTTON_ADD = 1016;
	public static final int UBICATION_Y_BUTTON_ADD = 5;

//Valores grÃ¡fica de barras
	public static final Color DEFAULT_AXIS_COLOR = ConstantsGUI.COLOR_BLACK;
	public static final int MAX_PIXEL_COL_HEIGHT_VALUE = 350;
	public static final int MAX_PIXEL_COL_WIDTH_VALUE = 27;
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
	public static final int GRAPHIC_MAX_DATA_QUANTITY = 20;

	public static JLabel createLabelTitles(String text) {
		JLabel label = new JLabel(text);
		label.setFont(new Font("Roboto", Font.ITALIC, 50));
		label.setForeground(ConstantsGUI.COLOR_PRESENTATION);
		return label;
	}
	
	public static JLabel createLabelTitleMenu(String text,Color color) {
		JLabel label = new JLabel(HTML_TAG_B+text);
		label.setFont(new Font("Roboto", Font.ITALIC, 30));
		label.setForeground(color);
		return label;
	}
	
}