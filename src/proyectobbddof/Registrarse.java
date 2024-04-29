package proyectobbddof;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import PlantillaConexionbbdd.ConexionMySQL;


public class Registrarse extends JFrame {

	ConexionMySQL conect=new ConexionMySQL("root","test","login_proyecto");
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDNI;
    private  JTextField textFieldNombre;
    private JTextField textFieldGmail;
    private JTextField textFieldContraseña;
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

	
	public Registrarse() {
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_4 = new JLabel("DNI");
		lblNewLabel_4.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
    	lblNewLabel_4.setBounds(304, 114, 56, 14);
    	getContentPane().add(lblNewLabel_4);
    	
    	lblNewLabel_3 = new JLabel("Gmail");
    	lblNewLabel_3.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
    	lblNewLabel_3.setBounds(95, 114, 48, 14);
    	getContentPane().add(lblNewLabel_3);
    	
    	lblNewLabel_2 = new JLabel("Contraseña");
    	lblNewLabel_2.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
    	lblNewLabel_2.setBounds(293, 38, 67, 14);
    	getContentPane().add(lblNewLabel_2);
    	
    	lblNewLabel_1 = new JLabel("Nombre");
    	lblNewLabel_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
    	lblNewLabel_1.setBounds(81, 38, 62, 14);
    	getContentPane().add(lblNewLabel_1);
    	
    	textFieldDNI = new JTextField();
    	textFieldDNI.setForeground(new Color(0, 0, 0));
    	textFieldDNI.setBackground(new Color(255, 255, 255));
    	textFieldDNI.setBounds(258, 139, 131, 23);
    	getContentPane().add(textFieldDNI);
    	textFieldDNI.setColumns(10);
    	
    	textFieldNombre = new JTextField();
    	textFieldNombre.setBounds(47, 63, 131, 23);
    	getContentPane().add(textFieldNombre);
    	textFieldNombre.setColumns(10);
    	
    	textFieldGmail = new JTextField();
    	textFieldGmail.setBounds(47, 139, 131, 23);
    	getContentPane().add(textFieldGmail);
    	textFieldGmail.setColumns(10);
    	
    	textFieldContraseña = new JTextField();
    	textFieldContraseña.setBounds(258, 63, 131, 23);
    	getContentPane().add(textFieldContraseña);
    	textFieldContraseña.setColumns(10);
    	
    	JButton btnNewButton = new JButton("REGISTRAR USUARIO");
    	btnNewButton.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			
    		}
    	});
    	btnNewButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 11));
    	btnNewButton.setBounds(135, 187, 159, 32);
    	getContentPane().add(btnNewButton);
	}


}
