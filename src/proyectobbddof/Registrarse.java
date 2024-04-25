package proyectobbddof;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class Registrarse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrarse frame = new Registrarse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param b 
	 * @param object 
	 */
	public Registrarse() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		lblNewLabel_4 = new JLabel("DNI");
    	lblNewLabel_4.setBounds(276, 147, 28, 14);
    	getContentPane().add(lblNewLabel_4);
    	
    	lblNewLabel_3 = new JLabel("Gmail");
    	lblNewLabel_3.setBounds(93, 147, 46, 14);
    	getContentPane().add(lblNewLabel_3);
    	
    	lblNewLabel_2 = new JLabel("Contraseña");
    	lblNewLabel_2.setBounds(258, 64, 62, 14);
    	getContentPane().add(lblNewLabel_2);
    	
    	lblNewLabel_1 = new JLabel("Nombre");
    	lblNewLabel_1.setBounds(93, 64, 46, 14);
    	getContentPane().add(lblNewLabel_1);
    	
    	JPanel panel = new JPanel();
    	panel.setBackground(new Color(128, 255, 128));
    	panel.setBounds(0, 0, 434, 24);
    	getContentPane().add(panel);
    	
    	JLabel lblNewLabel = new JLabel("Registro de Usuario");
    	panel.add(lblNewLabel);
    	
    	textField_1 = new JTextField();
    	textField_1.setForeground(new Color(255, 255, 255));
    	textField_1.setBackground(new Color(255, 255, 255));
    	textField_1.setBounds(50, 64, 135, 50);
    	getContentPane().add(textField_1);
    	textField_1.setColumns(10);
    	
    	textField_2 = new JTextField();
    	textField_2.setBounds(222, 64, 135, 50);
    	getContentPane().add(textField_2);
    	textField_2.setColumns(10);
    	
    	textField_3 = new JTextField();
    	textField_3.setBounds(50, 147, 135, 50);
    	getContentPane().add(textField_3);
    	textField_3.setColumns(10);
    	
    	textField_4 = new JTextField();
    	textField_4.setBounds(222, 147, 135, 50);
    	getContentPane().add(textField_4);
    	textField_4.setColumns(10);
    	
    	JButton btnNewButton = new JButton("REGISTRAR USUARIO");
    	btnNewButton.setBounds(128, 215, 157, 23);
    	getContentPane().add(btnNewButton);
	}


}
