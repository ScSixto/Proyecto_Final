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
//import javax.swing.JDialog;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//import controllers.Actions;
//
//public class JDialogSearchRunner extends JDialog{
//
//	private static final long serialVersionUID = 1L;
//	
//	private JTextFieldRunner id;
//	private JButtonsMenuAndDialogs buttonDelete, buttonCancel;
//
//	public JDialogSearchRunner(JFramePpal frame,ActionListener actionListenner,String title, String routeImage, boolean anotherButton) {
//		setMinimumSize(new Dimension(400,160));
//		setIconImage(new ImageIcon(routeImage).getImage());
//		setLocationRelativeTo(frame);
//		setTitle(title);
//		getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
//		setModal(true);
//		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
//		initComponents(actionListenner, anotherButton);
//	}
//	
//	private void initComponents(ActionListener actionListenner, boolean anotherButton) {
//		addTextField();
//		if(anotherButton == false)
//			addButtonsDelete(actionListenner);
//		else
//			addButtonsEdit(actionListenner);
//	}
//	
//	private void addTextField() {
//		add(createLabel(Constants.MESSAGE_GET_ID_RUNNER));
//		id = new JTextFieldRunner();
//		add(id);
//	}
//	
//	private void addButtonsDelete(ActionListener actionListenner) {
//		JPanel panelButtons = createPanel(10);
//		panelButtons.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
//		buttonDelete = new JButtonsMenuAndDialogs("resources/img/botonEliminar.png",120,35);
//		buttonDelete.addActionListener(actionListenner);
//		buttonDelete.setActionCommand(Actions.CLOSE_DELETE_DIALOG.toString());
//		panelButtons.add(buttonDelete);
//		buttonCancel = new JButtonsMenuAndDialogs("resources/img/botonCancelar.png",120,35);
//		buttonCancel.addActionListener(actionListenner);
//		buttonCancel.setActionCommand(Actions.CLOSE_DIALOG_DELETE_CANCEL.toString());
//		panelButtons.add(buttonCancel);
//		add(panelButtons);
//	}
//	
//	private void addButtonsEdit(ActionListener actionListenner) {
//		JPanel panelButtons = createPanel(10);
//		panelButtons.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
//		buttonDelete = new JButtonsMenuAndDialogs("resources/img/botonEditar.png",120,35);
//		buttonDelete.addActionListener(actionListenner);
//		buttonDelete.setActionCommand(Actions.CLOSE_EDIT_DIALOG.toString());
//		panelButtons.add(buttonDelete);
//		buttonCancel = new JButtonsMenuAndDialogs("resources/img/botonCancelar.png",120,35);
//		buttonCancel.addActionListener(actionListenner);
//		buttonCancel.setActionCommand(Actions.CLOSE_DIALOG_EDIT_CANCEL.toString());
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
//		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
//		label.setForeground(Color.BLACK);
//		label.setAlignmentX(CENTER_ALIGNMENT);
//		label.setFont(new Font("Calibri", Font.ITALIC, 14));
//		label.setOpaque(false);
//		return label;
//	}
//	
//	public void clearComponents() {
//		id.setText(Constants.EMPTY);
//	}
//	
//	public int getId() {
//		return Integer.parseInt(id.getText());
//	}
//	
//	public boolean verifyEmptyComponent() {
//		boolean isEmpty = true;
//		if(id.getText().isEmpty())
//			isEmpty = false;
//		return isEmpty;
//	}
//	
////	public static void main(String[] args) {
////		new JDialogSearchRunner().setVisible(true);
////	}
//
//}
