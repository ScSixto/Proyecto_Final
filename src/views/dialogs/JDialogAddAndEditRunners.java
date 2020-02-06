//package views.dialogs;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.event.ActionListener;
//
//import javax.swing.BorderFactory;
//import javax.swing.BoxLayout;
//import javax.swing.ImageIcon;
//import javax.swing.JComboBox;
//import javax.swing.JDialog;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//import controllers.Actions;
//import models.Runner;
//import models.RunnerManager;
//import models.Team;
//import models.Utilities;
//
//public class JDialogAddAndEditRunners extends JDialog{
//
//	private static final long serialVersionUID = 1L;
//	
//	private JTextFieldRunner id, firstName, secondName, lastName;
//	private JComboBox<String> genders, teams;
//	private JPanelSpinners panelSpinners;
//	private JButtonsMenuAndDialogs buttonAcept, buttonCancel;
//	
//	public JDialogAddAndEditRunners(JFramePpal frame,ActionListener actionListenner,String title, String routeImage,boolean editButtons) {
//		setMinimumSize(new Dimension(400,500));
//		getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
//		setIconImage(new ImageIcon(routeImage).getImage());
//		setLocationRelativeTo(frame);
//		setTitle(title);
//		setModal(true);
//		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
//		initComponents(actionListenner,editButtons);
//	}
//	
//	private void initComponents(ActionListener actionListenner,boolean editButtons) {
//		addJDialogs();
//		addCalendar();
//		addJComboBoxGender();
//		addJComboBoxTeams();
//		addPanelSpinners();
//		if(editButtons == false)
//			addButtons(actionListenner);
//		else
//			addButtonsEdit(actionListenner);
//	}
//	
//	private void addJDialogs() {
//		add(createLabel("ID"));
//		id = new JTextFieldRunner();
//		add(id);
//		add(createLabel("Primer Nombre"));
//		firstName = new JTextFieldRunner();
//		add(firstName);
//		add(createLabel("Segundo Nombre"));
//		secondName = new JTextFieldRunner();
//		add(secondName);
//		add(createLabel("Apellido"));
//		lastName = new JTextFieldRunner();
//		add(lastName);
//	}
//	
//	private void addCalendar() {
//		add(createLabel("Fecha de Nacimiento"));
//		calendar = new JCalendarBirthDate(this.getWidth());
//		add(calendar);
//	}
//	
//	private void addJComboBoxGender() {
//		add(createLabel("Genero"));
//		genders = new JComboBox<String>();
//		genders.setBackground(Color.WHITE);
//		genders.setForeground(Color.BLACK);
//		genders.setFont(new Font("Calibri", Font.ITALIC, 16));
//		genders.addItem("Masculino");
//		genders.addItem("Femenino");
//		genders.setFocusable(false);
//		add(genders);
//	}
//	
//	private void addJComboBoxTeams() {
//		add(createLabel("Equipo"));
//		teams = new JComboBox<String>();
//		teams.setBackground(Color.WHITE);
//		teams.setForeground(Color.BLACK);
//		teams.setFont(new Font("Calibri", Font.ITALIC, 16));
//		for (Team team : Team.values()) {
//			teams.addItem(team.getNameTeam());
//		}
//		teams.setFocusable(false);
//		add(teams);
//	}
//	
//	private void addPanelSpinners() {
//		add(createLabel("Tiempo Recorrido"));
//		addPanelLabelsTime();
//		panelSpinners = new JPanelSpinners();
//		add(panelSpinners);
//	}
//	
//	private void addPanelLabelsTime() {
//		JPanel panel = new JPanel();
//		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
//		layout.setHgap(65);
//		panel.setLayout(layout);
//		panel.setOpaque(false);
//		panel.add(createLabel("Horas"));
//		panel.add(createLabel("Minutos"));
//		panel.add(createLabel("Segundos"));
//		add(panel);
//	}
//	
//	private void addButtons(ActionListener actionListenner) {
//		JPanel panelButtons = createPanel(10);
//		panelButtons.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
//		buttonAcept = new JButtonsMenuAndDialogs("resources/img/botonAceptar.png",120,35);
//		buttonAcept.addActionListener(actionListenner);
//		buttonAcept.setActionCommand(Actions.CLOSE_ADD_DIALOG.toString());
//		panelButtons.add(buttonAcept);
//		buttonCancel = new JButtonsMenuAndDialogs("resources/img/botonCancelar.png",120,35);
//		buttonCancel.addActionListener(actionListenner);
//		buttonCancel.setActionCommand(Actions.CLOSE_DIALOG_ADD_CANCEL.toString());
//		panelButtons.add(buttonCancel);
//		add(panelButtons);
//	}
//	
//	private void addButtonsEdit(ActionListener actionListenner) {
//		JPanel panelButtons = createPanel(10);
//		panelButtons.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
//		buttonAcept = new JButtonsMenuAndDialogs("resources/img/botonAceptar.png",120,35);
//		buttonAcept.addActionListener(actionListenner);
//		buttonAcept.setActionCommand(Actions.CLOSE_EDIT_RUNNER_DIALOG.toString());
//		panelButtons.add(buttonAcept);
//		buttonCancel = new JButtonsMenuAndDialogs("resources/img/botonCancelar.png",120,35);
//		buttonCancel.addActionListener(actionListenner);
//		buttonCancel.setActionCommand(Actions.CLOSE_DIALOG_EDIT_RUNNER_CANCEL.toString());
//		panelButtons.add(buttonCancel);
//		add(panelButtons);
//	}
//	
//	private JPanel createPanel(int separation) {
//		JPanel panel = new JPanel();
//		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
//		layout.setHgap(separation);
//		panel.setLayout(layout);
//		panel.setOpaque(false);
//		return panel;
//	}
//	
//	private JLabel createLabel(String text) {
//		JLabel label = new JLabel("<html><b>" +text +"</b></html>");
//		label.setForeground(Color.BLACK);
//		label.setAlignmentX(RIGHT_ALIGNMENT);
//		label.setFont(new Font("Calibri", Font.ITALIC, 14));
//		label.setOpaque(false);
//		return label;
//	}
//	
//	public int getRunnerID() {
//		return Integer.parseInt(id.getText());
//	}
//	
//	public String getRunnerFirstName() {
//		return firstName.getText();
//	}
//	
//	public String getRunnerSecondName() {
//		return secondName.getText();
//	}
//	
//	public String getRunnerLastName() {
//		return lastName.getText();
//	}
//	
//	public String getBirthDate() {
//		return calendar.getDateInString();
//	}
//	
//	public String getGender() {
//		return (String) genders.getSelectedItem();
//	}
//	
//	public Team getTeam() {
//		Team teamSelected = null;
//		int i = 0;
//		while(teamSelected == null) {
//			if(teams.getSelectedItem().equals(Team.values()[i].getNameTeam())) {
//				teamSelected = Team.values()[i];
//			}
//			i++;
//		}
//		return teamSelected;
//	}
//	
//	public String getTotalTime() {
//		return panelSpinners.getTotalTime();
//	}
//	
//	public void clearComponents() {
//		id.setText(Constants.EMPTY);
//		firstName.setText(Constants.EMPTY);
//		secondName.setText(Constants.EMPTY);
//		lastName.setText(Constants.EMPTY);
//		calendar.setCalendar(null);
//		panelSpinners.resetSpinners();
//	}
//	
//	public void verifySecondName() {
//		if(secondName.getText().isEmpty())
//			secondName.setText(" ");
//	}
//	
//	public boolean verifyEmptyComponents() {
//		boolean isEmpty = true;
//		if(id.getText().isEmpty() || firstName.getText().isEmpty() || lastName.getText().isEmpty() || calendar.getDate() == null)
//			isEmpty = false;
//		return isEmpty;
//	}
//	
//	public void getInformationRunner(Runner runner) {
////		id.setEnabled(false);
//		id.setEditable(false);
//		id.setText(Integer.toString(runner.getId()));
//		firstName.setText(runner.getFirstName());
//		secondName.setText(runner.getSecondName());
//		lastName.setText(runner.getLastName());
//		calendar.setBirthDate(runner.getBirthDate());
//		genders.setSelectedItem(runner.getGender());
//		teams.setSelectedItem(runner.getTeam().getNameTeam());
//		panelSpinners.setSpinnersValues(runner.getTotalTime());
//	}
//	
//	public Runner createRunner() {
//		verifySecondName();
//		return RunnerManager.createRunner(getRunnerID(), getRunnerFirstName(), getRunnerSecondName(), getRunnerLastName(), Utilities.toDate(getBirthDate()), getGender(), getTeam(), Utilities.toTime(getTotalTime()));
//	}
//	
////	public static void main(String[] args) {
////		new JDialogAddRunners();
////	}
//
//}
