package proyectobbddof;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblfondo=new JLabel("");
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
				
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menu() {
		setTitle("Manager App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1980, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Nombre", "Posicion", "Edad", "Categoria", "Nacionalidad"
			}
		));
		table.setBounds(262, 203, 722, 345);
		contentPane.add(table);
		btnNewButton_1.setBounds(1217, 600, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(962, 240, 46, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(1088, 176, 218, 69);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar:", "Nombre", "Posicion", "Edad", "Categoria", "Nacionalidad"}));
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Filtrador Cantera");
		btnNewButton.setBounds(683, 117, 623, 61);
		btnNewButton.setBackground(new Color(255, 255, 255));
		contentPane.add(btnNewButton);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 1980, 1080);
		lblFondo.setForeground(new Color(0, 128, 0));
		lblFondo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblFondo);
		ImageIcon icono2=new ImageIcon(menu.class.getResource("/img/fondo.jpg"));
				Image imagen2 =	icono2.getImage().getScaledInstance(lblFondo.getWidth(),lblFondo.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon iconoAjustado2 = new ImageIcon(imagen2);
				lblFondo.setIcon(iconoAjustado2);
				
		
		
		
	}
}