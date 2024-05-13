package proyectobbddof; // Declaración del paquete del código

import java.awt.Color; // Importación de la clase Color del paquete awt
import java.awt.EventQueue; // Importación de la clase EventQueue del paquete awt
import java.awt.Font; // Importación de la clase Font del paquete awt
import java.awt.Image; // Importación de la clase Image del paquete awt
import java.awt.event.ActionEvent; // Importación de la clase ActionEvent del paquete awt.event
import java.awt.event.ActionListener; // Importación de la clase ActionListener del paquete awt.event
import java.awt.event.MouseAdapter; // Importación de la clase MouseAdapter del paquete awt.event
import java.awt.event.MouseEvent; // Importación de la clase MouseEvent del paquete awt.event
import java.sql.ResultSet; // Importación de la clase ResultSet del paquete java.sql
import java.sql.SQLException; // Importación de la clase SQLException del paquete java.sql
import javax.swing.ImageIcon; // Importación de la clase ImageIcon del paquete javax.swing
import javax.swing.JButton; // Importación de la clase JButton del paquete javax.swing
import javax.swing.JFrame; // Importación de la clase JFrame del paquete javax.swing
import javax.swing.JLabel; // Importación de la clase JLabel del paquete javax.swing
import javax.swing.JOptionPane; // Importación de la clase JOptionPane del paquete javax.swing
import javax.swing.JPanel; // Importación de la clase JPanel del paquete javax.swing
import javax.swing.JPasswordField; // Importación de la clase JPasswordField del paquete javax.swing
import javax.swing.JTextField; // Importación de la clase JTextField del paquete javax.swing
import javax.swing.border.EmptyBorder; // Importación de la clase EmptyBorder del paquete javax.swing
import Conexionbbdd.ConexionMysql; // Importación de la clase ConexionMysql del paquete Conexionbbdd

// Declaración de la clase InicioSesion que extiende JFrame
public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L; // Declaración de serialVersionUID como constante
	private JPanel contentPane; // Declaración de la variable contentPane de tipo JPanel
	private final JLabel lblfondo=new JLabel(""); // Declaración de la etiqueta lblfondo como constante de tipo JLabel
	private JPasswordField passwordField; // Declaración de la variable passwordField de tipo JPasswordField
	private JTextField textField; // Declaración de la variable textField de tipo JTextField

	// Método main, punto de entrada del programa
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // Invocación de EventQueue.invokeLater para la ejecución en el hilo de despacho de eventos
			public void run() { // Método run para ejecutar la aplicación
				try { // Intentar ejecutar
					InicioSesion frame = new InicioSesion(); // Crear objeto frame de la clase InicioSesion
					frame.setVisible(true); // Hacer visible la ventana
				} catch (Exception e) { // Capturar excepciones
					e.printStackTrace(); // Imprimir traza de excepción
				}
			}
		});
	}

	// Constructor de la clase InicioSesion
	public InicioSesion() {
		setTitle("Manager App"); // Establecer título de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establecer operación de cierre de la ventana
		setBounds(0, 0, 1980, 1080); // Establecer posición y tamaño de la ventana
		contentPane = new JPanel(); // Crear objeto contentPane de tipo JPanel
		contentPane.setBackground(new Color(128, 255, 255)); // Establecer color de fondo del panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Establecer borde vacío del panel

		setContentPane(contentPane); // Establecer panel de contenido en la ventana
		contentPane.setLayout(null); // Establecer el diseño del panel como nulo

		// Campo de texto para el usuario
		textField = new JTextField(); // Crear objeto textField de tipo JTextField
		textField.setBounds(1409, 295, 320, 35); // Establecer posición y tamaño del campo de texto
		contentPane.add(textField); // Agregar campo de texto al panel de contenido
		textField.setColumns(10); // Establecer número de columnas del campo de texto

		// Campo de contraseña
		passwordField = new JPasswordField(); // Crear objeto passwordField de tipo JPasswordField
		passwordField.setBounds(1409, 387, 320, 35); // Establecer posición y tamaño del campo de contraseña
		contentPane.add(passwordField); // Agregar campo de contraseña al panel de contenido
		JLabel lblContraseña = new JLabel("Contraseña: "); // Crear objeto lblContraseña de tipo JLabel con texto "Contraseña"
		lblContraseña.setFont(new Font("Mongolian Baiti", Font.BOLD, 20)); // Establecer fuente y estilo de la etiqueta
		lblContraseña.setForeground(new Color(0, 128, 0)); // Establecer color del texto de la etiqueta
		lblContraseña.setBackground(new Color(0, 128, 0)); // Establecer color de fondo de la etiqueta
		lblContraseña.setBounds(1279, 370, 176, 66); // Establecer posición y tamaño de la etiqueta
		contentPane.add(lblContraseña); // Agregar etiqueta al panel de contenido

		// Etiqueta para el usuario
		JLabel lblUsuario = new JLabel("Usuario: "); // Crear objeto lblUsuario de tipo JLabel con texto "Usuario"
		lblUsuario.setFont(new Font("Mongolian Baiti", Font.BOLD, 20)); // Establecer fuente y estilo de la etiqueta
		lblUsuario.setForeground(new Color(0, 128, 0)); // Establecer color del texto de la etiqueta
		lblUsuario.setBackground(new Color(0, 128, 0)); // Establecer color de fondo de la etiqueta
		lblUsuario.setBounds(1306, 274, 161, 74); // Establecer posición y tamaño de la etiqueta
		contentPane.add(lblUsuario); // Agregar etiqueta al panel de contenido

		// Título de la aplicación
		JLabel lblTitulo = new JLabel("App oficial del Real Betis Balompié"); // Crear objeto lblTitulo de tipo JLabel con texto "App oficial del Real Betis Balompié"
		lblTitulo.setForeground(new Color(0, 128, 0)); // Establecer color del texto de la etiqueta
		lblTitulo.setFont(new Font("Mongolian Baiti", Font.BOLD, 60)); // Establecer fuente y estilo de la etiqueta
		lblTitulo.setBounds(38, -36, 1062, 230); // Establecer posición y tamaño de la etiqueta
		contentPane.add(lblTitulo); // Agregar etiqueta al panel de contenido

		// Botón para iniciar sesión
		JButton btnNewButton = new JButton("Ingresar"); // Crear objeto btnNewButton de tipo JButton con texto "Ingresar"
		btnNewButton.addMouseListener(new MouseAdapter() { // Agregar adaptador de ratón al botón
			@Override
			public void mouseClicked(MouseEvent e) { // Método para manejar clics de ratón
				ConexionMysql conexion = new ConexionMysql("root","test","login_proyecto"); // Crear objeto conexion de tipo ConexionMysql con parámetros
    			try { // Intentar ejecutar
					conexion.conectar(); // Conectar a la base de datos
					String sentencia="SELECT * FROM Usuarios WHERE Nombre='"+textField.getText()+"' AND Contraseña='"+new String (passwordField.getPassword())+"'"; // Definir sentencia SQL para buscar usuario
					ResultSet inicio=conexion.ejecutarSelect(sentencia); // Ejecutar sentencia SQL y obtener resultado
					if(inicio.next()) { // Si hay resultados
						menu2 ventanaMenu = new menu2(); // Crear objeto ventanaMenu de tipo menu2
						ventanaMenu.setVisible(true); // Hacer visible la ventana del menú
						dispose(); // Cerrar la ventana actual
					} else { // Si no hay resultados
						JOptionPane.showMessageDialog(null, "Fallo al iniciar sesión."); // Mostrar mensaje de error
						textField.setText(" "); // Limpiar campo de texto del usuario
						passwordField.setText(""); // Limpiar campo de contraseña
					}
					
				} catch (SQLException e1) { // Capturar excepciones de SQL
					e1.printStackTrace(); // Imprimir traza de excepción
				} finally { // Bloque finally
					try { // Intentar ejecutar
						conexion.desconectar(); // Desconectar de la base de datos
					} catch (SQLException e1) { // Capturar excepciones de SQL
						e1.printStackTrace(); // Imprimir traza de excepción
					}
				}
    		}
    	});
		btnNewButton.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16)); // Establecer fuente y estilo del botón
		btnNewButton.setForeground(new Color(255, 255, 255)); // Establecer color del texto del botón
		btnNewButton.setBackground(new Color(0, 128, 0)); // Establecer color de fondo del botón
		btnNewButton.setBounds(1520, 480, 105, 35); // Establecer posición y tamaño del botón
		contentPane.add(btnNewButton); // Agregar botón al panel de contenido

		// Botón para registrarse
		JButton btnNewButtonr = new JButton("Registrarse"); // Crear objeto btnNewButtonr de tipo JButton con texto "Registrarse"
		btnNewButtonr.addActionListener(new ActionListener() { // Agregar oyente de acción al botón
			public void actionPerformed(ActionEvent e) { // Método para manejar eventos de acción
				Registrarse fr= new Registrarse(); // Crear objeto fr de tipo Registrarse
				fr.setVisible(true); // Hacer visible la ventana de registro
			}
		});
		btnNewButtonr.setForeground(Color.WHITE); // Establecer color del texto del botón
		btnNewButtonr.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16)); // Establecer fuente y estilo del botón
		btnNewButtonr.setBackground(new Color(0, 128, 0)); // Establecer color de fondo del botón
		btnNewButtonr.setBounds(1624, 207, 105, 35); // Establecer posición y tamaño del botón
		contentPane.add(btnNewButtonr); // Agregar botón al panel de contenido

		// Imagen de fondo
		JLabel lblFondo = new JLabel(""); // Crear objeto lblFondo de tipo JLabel
		lblFondo.setForeground(new Color(0, 128, 0)); // Establecer color del texto de la etiqueta
		lblFondo.setBounds(0, 0, 1980, 1080); // Establecer posición y tamaño de la etiqueta
		lblFondo.setFont(new Font("Times New Roman", Font.PLAIN, 18)); // Establecer fuente y estilo de la etiqueta
		contentPane.add(lblFondo); // Agregar etiqueta al panel de contenido
		ImageIcon icono2=new ImageIcon(InicioSesion.class.getResource("/img/pelegrini3.jpg")); // Crear objeto icono2 de tipo ImageIcon con la imagen pelegrini3.jpg
		Image imagen2 =	icono2.getImage().getScaledInstance(lblFondo.getWidth(),lblFondo.getHeight(), Image.SCALE_SMOOTH); // Escalar la imagen al tamaño de la etiqueta
		ImageIcon iconoAjustado2 = new ImageIcon(imagen2); // Crear objeto iconoAjustado2 de tipo ImageIcon con la imagen escalada
		lblFondo.setIcon(iconoAjustado2); // Establecer icono escalado como imagen de fondo
	}
}

