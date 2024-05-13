package proyectobbddof; // Definición del paquete del código

import java.awt.Color; // Importar clase Color de AWT
import java.awt.EventQueue; // Importar clase EventQueue de AWT
import javax.swing.JButton; // Importar clase JButton de Swing
import javax.swing.JFrame; // Importar clase JFrame de Swing
import javax.swing.JLabel; // Importar clase JLabel de Swing
import javax.swing.JPanel; // Importar clase JPanel de Swing
import javax.swing.JTextField; // Importar clase JTextField de Swing
import javax.swing.border.EmptyBorder; // Importar clase EmptyBorder de Swing
import Conexionbbdd.ConexionMysql; // Importar clase ConexionMysql del paquete Conexionbbdd
import java.awt.Font; // Importar clase Font de AWT
import java.awt.event.MouseAdapter; // Importar clase MouseAdapter de AWT
import java.awt.event.MouseEvent; // Importar clase MouseEvent de AWT
import java.sql.ResultSet; // Importar clase ResultSet del paquete java.sql
import java.sql.SQLException; // Importar clase SQLException del paquete java.sql
import Conexionbbdd.ConexionMysql; // Importar clase ConexionMysql del paquete Conexionbbdd

// Declaración de la clase Registrarse que extiende JFrame
public class Registrarse extends JFrame {

	ConexionMysql conect=new ConexionMysql("root","test","login_proyecto"); // Instanciar objeto ConexionMysql con parámetros
	private static final long serialVersionUID = 1L; // Declaración de serialVersionUID como constante
	private JPanel contentPane; // Declaración de variable contentPane de tipo JPanel
	private JTextField textFieldDNI; // Declaración de variable textFieldDNI de tipo JTextField
    private  JTextField textFieldNombre; // Declaración de variable textFieldNombre de tipo JTextField
    private JTextField textFieldGmail; // Declaración de variable textFieldGmail de tipo JTextField
    private JTextField textFieldContraseña; // Declaración de variable textFieldContraseña de tipo JTextField
    private JLabel lblNewLabel_1; // Declaración de variable lblNewLabel_1 de tipo JLabel
    private JLabel lblNewLabel_2; // Declaración de variable lblNewLabel_2 de tipo JLabel
    private JLabel lblNewLabel_3; // Declaración de variable lblNewLabel_3 de tipo JLabel
    private JLabel lblNewLabel_4; // Declaración de variable lblNewLabel_4 de tipo JLabel

	// Método main, punto de entrada del programa
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // Invocación de EventQueue.invokeLater para la ejecución en el hilo de despacho de eventos
			public void run() { // Método run para ejecutar la aplicación
				try { // Intentar ejecutar
					Registrarse frame = new Registrarse(); // Crear objeto frame de la clase Registrarse
					frame.setVisible(true); // Hacer visible la ventana
				} catch (Exception e) { // Capturar excepciones
					e.printStackTrace(); // Imprimir traza de excepción
				}
			}
		});
	}

	// Constructor de la clase Registrarse
	public Registrarse() {
		// Configuración de la ventana
		setTitle("Registrarse");// Establecer título de la ventana
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Configurar operación de cierre de ventana
		setBounds(100, 100, 450, 300); // Establecer posición y tamaño de la ventana
		contentPane = new JPanel(); // Crear objeto contentPane de tipo JPanel
		contentPane.setBackground(new Color(128, 255, 128)); // Establecer color de fondo del panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Establecer borde vacío
		setContentPane(contentPane); // Establecer panel de contenido en la ventana
		contentPane.setLayout(null); // Establecer el diseño del panel como nulo
		
		// Etiqueta y campo de texto para el DNI
		lblNewLabel_4 = new JLabel("DNI"); // Crear objeto lblNewLabel_4 de tipo JLabel con texto "DNI"
		lblNewLabel_4.setFont(new Font("Mongolian Baiti", Font.BOLD, 15)); // Establecer fuente y estilo de la etiqueta
    	lblNewLabel_4.setBounds(304, 114, 56, 14); // Establecer posición y tamaño de la etiqueta
    	getContentPane().add(lblNewLabel_4); // Agregar etiqueta al panel de contenido
    	textFieldDNI = new JTextField(); // Crear objeto textFieldDNI de tipo JTextField
    	textFieldDNI.setForeground(new Color(0, 0, 0)); // Establecer color de texto
    	textFieldDNI.setBackground(new Color(255, 255, 255)); // Establecer color de fondo
    	textFieldDNI.setBounds(258, 139, 131, 23); // Establecer posición y tamaño del campo de texto
    	getContentPane().add(textFieldDNI); // Agregar campo de texto al panel de contenido
    	textFieldDNI.setColumns(10); // Establecer número de columnas del campo de texto
		
    	// Etiqueta y campo de texto para el Email
    	lblNewLabel_3 = new JLabel("Email"); // Crear objeto lblNewLabel_3 de tipo JLabel con texto "Email"
    	lblNewLabel_3.setFont(new Font("Mongolian Baiti", Font.BOLD, 14)); // Establecer fuente y estilo de la etiqueta
    	lblNewLabel_3.setBounds(95, 114, 48, 14); // Establecer posición y tamaño de la etiqueta
    	getContentPane().add(lblNewLabel_3); // Agregar etiqueta al panel de contenido
    	textFieldGmail = new JTextField(); // Crear objeto textFieldGmail de tipo JTextField
    	textFieldGmail.setBounds(47, 139, 131, 23); // Establecer posición y tamaño del campo de texto
    	getContentPane().add(textFieldGmail); // Agregar campo de texto al panel de contenido
    	textFieldGmail.setColumns(10); // Establecer número de columnas del campo de texto
    	
    	// Etiqueta y campo de texto para la Contraseña
    	lblNewLabel_2 = new JLabel("Contraseña"); // Crear objeto lblNewLabel_2 de tipo JLabel con texto "Contraseña"
    	lblNewLabel_2.setFont(new Font("Mongolian Baiti", Font.BOLD, 14)); // Establecer fuente y estilo de la etiqueta
    	lblNewLabel_2.setBounds(293, 38, 67, 14); // Establecer posición y tamaño de la etiqueta
    	getContentPane().add(lblNewLabel_2); // Agregar etiqueta al panel de contenido
    	textFieldContraseña = new JTextField(); // Crear objeto textFieldContraseña de tipo JTextField
    	textFieldContraseña.setBounds(258, 63, 131, 23); // Establecer posición y tamaño del campo de texto
    	getContentPane().add(textFieldContraseña); // Agregar campo de texto al panel de contenido
    	textFieldContraseña.setColumns(10); // Establecer número de columnas del campo de texto
    	
    	// Etiqueta y campo de texto para el Nombre
    	lblNewLabel_1 = new JLabel("Nombre"); // Crear objeto lblNewLabel_1 de tipo JLabel con texto "Nombre"
    	lblNewLabel_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 14)); // Establecer fuente y estilo de la etiqueta
    	lblNewLabel_1.setBounds(81, 38, 62, 14); // Establecer posición y tamaño de la etiqueta
    	getContentPane().add(lblNewLabel_1); // Agregar etiqueta al panel de contenido
    	textFieldNombre = new JTextField(); // Crear objeto textFieldNombre de tipo JTextField
    	textFieldNombre.setBounds(47, 63, 131, 23); // Establecer posición y tamaño del campo de texto
    	getContentPane().add(textFieldNombre); // Agregar campo de texto al panel de contenido
    	textFieldNombre.setColumns(10); // Establecer número de columnas del campo de texto
    	
    	// Botón para registrar usuario
    	JButton btnNewButton = new JButton("REGISTRAR USUARIO"); // Crear objeto btnNewButton de tipo JButton con texto "REGISTRAR USUARIO"
    	btnNewButton.addMouseListener(new MouseAdapter() { // Añadir adaptador de ratón al botón
    		@Override
    		public void mouseClicked(MouseEvent e) { // Método para manejar clics de ratón
    			ConexionMysql conexion = new ConexionMysql("root","test","login_proyecto"); // Crear objeto conexion de tipo ConexionMysql con parámetros
    			try { // Intentar ejecutar
					conexion.conectar(); // Conectar a la base de datos
					String sentencia2="INSERT INTO Usuarios (Nombre, Email, Contraseña, DNI) VALUES ('"+textFieldNombre.getText()+"','"+textFieldGmail.getText()+"','"+textFieldContraseña.getText()+"','"+textFieldDNI.getText()+"')"; // Definir sentencia SQL de inserción
					 conexion.ejecutarInsertDeleteUpdate(sentencia2); // Ejecutar sentencia SQL de inserción
					
						InicioSesion cierreRegistro = new InicioSesion(); // Crear objeto cierreRegistro de tipo InicioSesion
						cierreRegistro.setVisible(true); // Hacer visible la ventana de inicio de sesión
						dispose(); // Cerrar la ventana actual
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
    	btnNewButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 11)); // Establecer fuente y estilo del botón
    	btnNewButton.setBounds(135, 187, 159, 32); // Establecer posición y tamaño del botón
    	getContentPane().add(btnNewButton); // Agregar botón al panel de contenido
	}
}

