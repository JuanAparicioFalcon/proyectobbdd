import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Conexionbbdd.ConexionMysql;
import PlantillaConexionbbdd.ConexionMySQL;
import proyectobbddof.InicioSesion;
import proyectobbddof.Registrarse;

public class camposprueba extends JFrame {

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
    private JTextField textField;
    private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					camposprueba frame = new camposprueba();
					frame.setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public camposprueba() {
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_4 = new JLabel("Nacionalidad");
		lblNewLabel_4.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
    	lblNewLabel_4.setBounds(291, 120, 99, 14);
    	getContentPane().add(lblNewLabel_4);
    	
    	lblNewLabel_3 = new JLabel("Categoria");
    	lblNewLabel_3.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
    	lblNewLabel_3.setBounds(307, 49, 96, 14);
    	getContentPane().add(lblNewLabel_3);
    	
    	lblNewLabel_2 = new JLabel("Edad");
    	lblNewLabel_2.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
    	lblNewLabel_2.setBounds(197, 90, 67, 14);
    	getContentPane().add(lblNewLabel_2);
    	
    	lblNewLabel_1 = new JLabel("Nombre");
    	lblNewLabel_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
    	lblNewLabel_1.setBounds(65, 49, 62, 14);
    	getContentPane().add(lblNewLabel_1);
    	
    	lblNewLabel = new JLabel("Posicion");
    	lblNewLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
    	lblNewLabel.setBounds(64, 119, 99, 14);
    	contentPane.add(lblNewLabel);
    	
    	textField = new JTextField();
    	textField.setForeground(Color.BLACK);
    	textField.setColumns(10);
    	textField.setBackground(Color.WHITE);
    	textField.setBounds(31, 145, 131, 23);
    	contentPane.add(textField);
    	
    	textFieldDNI = new JTextField();
    	textFieldDNI.setForeground(new Color(0, 0, 0));
    	textFieldDNI.setBackground(new Color(255, 255, 255));
    	textFieldDNI.setBounds(272, 145, 131, 23);
    	getContentPane().add(textFieldDNI);
    	textFieldDNI.setColumns(10);
    	
    	textFieldNombre = new JTextField();
    	textFieldNombre.setBounds(25, 74, 131, 23);
    	getContentPane().add(textFieldNombre);
    	textFieldNombre.setColumns(10);
    	
    	textFieldGmail = new JTextField();
    	textFieldGmail.setBounds(274, 74, 131, 23);
    	getContentPane().add(textFieldGmail);
    	textFieldGmail.setColumns(10);
    	
    	textFieldContraseña = new JTextField();
    	textFieldContraseña.setBounds(197, 115, 34, 23);
    	getContentPane().add(textFieldContraseña);
    	textFieldContraseña.setColumns(10);
    	
    	JButton btnNewButton = new JButton("AÑADIR JUGADOR");
    	btnNewButton.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			ConexionMysql conexion = new ConexionMysql("root","test","login_proyecto");
    			try {
					conexion.conectar();
					String sentencia2="INSERT INTO Usuarios (Nombre, Email, Contraseña, DNI) VALUES ('"+textFieldNombre.getText()+"','"+textFieldGmail.getText()+"','"+textFieldContraseña.getText()+"','"+textFieldDNI.getText()+"')";
					 conexion.ejecutarInsertDeleteUpdate(sentencia2);
					
						InicioSesion cierreRegistro = new InicioSesion();
						cierreRegistro.setVisible(true);
						dispose();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						conexion.desconectar();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
    		}
    	});
    	btnNewButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 11));
    	btnNewButton.setBounds(129, 192, 159, 32);
    	getContentPane().add(btnNewButton);
	}


}