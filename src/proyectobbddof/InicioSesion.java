package proyectobbddof;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Conexionbbdd.ConexionMysql;


public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblfondo=new JLabel("");
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
				
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
	public InicioSesion() {
		setTitle("Manager App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1980, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(1409, 295, 320, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(1409, 387, 320, 35);
		contentPane.add(passwordField);
		
		JLabel lblContraseña = new JLabel("Contraseña: ");
		lblContraseña.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
		lblContraseña.setForeground(new Color(0, 128, 0));
		lblContraseña.setBackground(new Color(0, 128, 0));
		lblContraseña.setBounds(1279, 370, 176, 66);
		contentPane.add(lblContraseña);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
		lblUsuario.setForeground(new Color(0, 128, 0));
		lblUsuario.setBackground(new Color(0, 128, 0));
		lblUsuario.setBounds(1306, 274, 161, 74);
		contentPane.add(lblUsuario);
		
		JLabel lblTitulo = new JLabel("App oficial del Real Betis Balompié");
		lblTitulo.setForeground(new Color(0, 128, 0));
		lblTitulo.setFont(new Font("Mongolian Baiti", Font.BOLD, 60));
		lblTitulo.setBounds(38, -36, 1062, 230);
		contentPane.add(lblTitulo);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConexionMysql conexion = new ConexionMysql("root","test","login_proyecto");
    			try {
					conexion.conectar();
					String sentencia="INSERT INTO Usuarios (Nombre, Email, Contraseña, DNI) VALUES ();
					conexion.ejecutarInsertDeleteUpdate(sentencia);
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
		btnNewButton.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(1520, 480, 105, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButtonr = new JButton("Registrarse");
		btnNewButtonr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrarse fr= new Registrarse();
				fr.setVisible(true);
			}
		});
		btnNewButtonr.setForeground(Color.WHITE);
		btnNewButtonr.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
		btnNewButtonr.setBackground(new Color(0, 128, 0));
		btnNewButtonr.setBounds(1624, 207, 105, 35);
		contentPane.add(btnNewButtonr);
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setForeground(new Color(0, 128, 0));
		lblFondo.setBounds(0, 0, 1980, 1080);
		lblFondo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblFondo);
		ImageIcon icono2=new ImageIcon(InicioSesion.class.getResource("/img/pelegrini3.jpg"));
				Image imagen2 =	icono2.getImage().getScaledInstance(lblFondo.getWidth(),lblFondo.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon iconoAjustado2 = new ImageIcon(imagen2);
				lblFondo.setIcon(iconoAjustado2);
		
		
	}
}
