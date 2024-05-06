package proyectobbddof; // Declaración del paquete del código

import java.awt.EventQueue; // Importación de la clase EventQueue del paquete awt
import javax.swing.JFrame; // Importación de la clase JFrame del paquete javax.swing
import javax.swing.JPanel; // Importación de la clase JPanel del paquete javax.swing
import javax.swing.border.EmptyBorder; // Importación de la clase EmptyBorder del paquete javax.swing.border
import javax.swing.table.DefaultTableModel; // Importación de la clase DefaultTableModel del paquete javax.swing.table
import Conexionbbdd.ConexionMysql; // Importación de la clase ConexionMysql del paquete Conexionbbdd
import javax.swing.JOptionPane; // Importación de la clase JOptionPane del paquete javax.swing
import javax.swing.*; // Importación de las clases de javax.swing
import java.awt.*; // Importación de las clases de awt
import java.awt.event.ActionEvent; // Importación de la clase ActionEvent del paquete awt.event
import java.awt.event.ActionListener; // Importación de la clase ActionListener del paquete awt.event
import java.sql.*; // Importación de las clases de java.sql
import java.awt.event.MouseAdapter; // Importación de la clase MouseAdapter del paquete awt.event
import java.awt.event.MouseEvent; // Importación de la clase MouseEvent del paquete awt.event

// Declaración de la clase menu2 que extiende JFrame
public class menu2 extends JFrame {

    private static final long serialVersionUID = 1L; // Declaración de serialVersionUID como constante
    private JPanel contentPane; // Declaración de la variable contentPane de tipo JPanel
    private JTextField CampoBuscar; // Declaración de la variable CampoBuscar de tipo JTextField
    private JTable table; // Declaración de la variable table de tipo JTable
    private JTable table_1; // Declaración de la variable table_1 de tipo JTable

    // Método main, punto de entrada del programa
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                menu2 frame = new menu2(); // Crear objeto frame de la clase menu2
                frame.setVisible(true); // Hacer visible la ventana
            } catch (Exception e) { // Capturar excepciones
                e.printStackTrace(); // Imprimir traza de excepción
            }
        });
    }

    // Constructor de la clase menu2
    public menu2() {
        setTitle("Manager App"); // Establecer título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establecer operación de cierre de la ventana
        setBounds(100, 100, 1200, 800); // Establecer posición y tamaño de la ventana
        contentPane = new JPanel(); // Crear objeto contentPane de tipo JPanel
        contentPane.setBackground(new Color(128, 255, 255)); // Establecer color de fondo del panel
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Establecer borde vacío del panel
        setContentPane(contentPane); // Establecer panel de contenido en la ventana
        
        contentPane.setLayout(null); // Establecer el diseño del panel como nulo

        // ComboBox para seleccionar opciones
        JComboBox<String> ComboOpcion = new JComboBox<>(new String[]{"Nombre", "Posición", "Categoría", "Edad", "Nacionalidad"}); // Crear objeto ComboOpcion de tipo JComboBox con opciones
        ComboOpcion.setBounds(287, 109, 165, 35); // Establecer posición y tamaño del combo
        ComboOpcion.setFont(new Font("Mongolian Baiti", Font.BOLD, 15)); // Establecer fuente y estilo del combo
        ComboOpcion.setBackground(new Color(255, 255, 0)); // Establecer color de fondo del combo
        ComboOpcion.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar:", "Nombre", "Posición", "Categoría", "Edad", "Nacionalidad"})); // Establecer modelo del combo
        contentPane.add(ComboOpcion); // Agregar combo al panel de contenido

        // Campo de texto para buscar
        CampoBuscar = new JTextField(); // Crear objeto CampoBuscar de tipo JTextField
        CampoBuscar.setBounds(494, 109, 198, 35); // Establecer posición y tamaño del campo de texto
        contentPane.add(CampoBuscar); // Agregar campo de texto al panel de contenido

<<<<<<< Updated upstream
        // Botón para buscar
        JButton BtnBuscar = new JButton("Buscar"); // Crear objeto BtnBuscar de tipo JButton con texto "Buscar"
        BtnBuscar.setBounds(733, 113, 87, 27); // Establecer posición y tamaño del botón
        BtnBuscar.setFont(new Font("Mongolian Baiti", Font.BOLD, 15)); // Establecer fuente y estilo del botón
        BtnBuscar.setBackground(new Color(255, 255, 0)); // Establecer color de fondo del botón
        BtnBuscar.setForeground(new Color(0, 0, 0)); // Establecer color del texto del botón
        contentPane.add(BtnBuscar); // Agregar botón al panel de contenido
=======
        JButton searchButton = new JButton("Buscar");
        searchButton.addMouseListener(new MouseAdapter() {
        	@Override
        	//aqui deberia ir el try/catch
        	public void mouseClicked(MouseEvent e) {
        		
        		
        		
        		 performSearch(searchComboBox.getSelectedItem().toString(), searchField.getText());
        		 
        		 
        		
        	}
        });
        searchButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
        searchButton.setBackground(new Color(255, 255, 0));
        searchButton.setForeground(new Color(0, 0, 0));
        searchButton.setBounds(733, 113, 87, 27);
        contentPane.add(searchButton);
>>>>>>> Stashed changes

        // Manejador de eventos para el botón de búsqueda
        BtnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
<<<<<<< Updated upstream
                ConexionMysql conexion = new ConexionMysql("root","","login_proyecto"); // Crear objeto conexion de tipo ConexionMysql con parámetros
                String sentencia=""; // Declaración de la variable sentencia como cadena
                
                try { // Intentar ejecutar
                    conexion.conectar(); // Conectar a la base de datos
                    if(ComboOpcion.getSelectedIndex()==1) { // Si se selecciona "Nombre"
                        sentencia="SELECT * FROM Cantera WHERE Nombre='"+CampoBuscar.getText()+"'"; // Definir sentencia SQL para buscar por nombre
                    }
                    else if(ComboOpcion.getSelectedIndex()==2) { // Si se selecciona "Posición"
                        sentencia="SELECT * FROM Cantera WHERE Posicion='"+CampoBuscar.getText()+"'"; // Definir sentencia SQL para buscar por posición
                    }
                    else if(ComboOpcion.getSelectedIndex()==3) { // Si se selecciona "Categoría"
                        sentencia="SELECT * FROM Cantera WHERE Categoria='"+CampoBuscar.getText()+"'"; // Definir sentencia SQL para buscar por categoría
                    }
                    else if(ComboOpcion.getSelectedIndex()==4) { // Si se selecciona "Edad"
                        sentencia="SELECT * FROM Cantera WHERE Edad='"+CampoBuscar.getText()+"'"; // Definir sentencia SQL para buscar por edad
                    }
                    else if(ComboOpcion.getSelectedIndex()==5) { // Si se selecciona "Nacionalidad"
                        sentencia="SELECT * FROM Cantera WHERE Nacionalidad='"+CampoBuscar.getText()+"'"; // Definir sentencia SQL para buscar por nacionalidad
                    }
                    
                    ResultSet ResultadoNombre=conexion.ejecutarSelect(sentencia); // Ejecutar sentencia SQL y obtener resultado
                    DefaultTableModel model = new DefaultTableModel(); // Crear objeto model de tipo DefaultTableModel
                    model.addColumn("Nombre"); // Añadir columna "Nombre" al modelo
                    model.addColumn("Posición"); // Añadir columna "Posición" al modelo
                    model.addColumn("Categoría"); // Añadir columna "Categoría" al modelo
                    model.addColumn("Edad"); // Añadir columna "Edad" al modelo
                    model.addColumn("Nacionalidad"); // Añadir columna "Nacionalidad" al modelo
                    table.setModel(model); // Establecer modelo de la tabla
                    
                    while(ResultadoNombre.next()){ // Mientras haya resultados
                        Object [] fila = { ResultadoNombre.getString("nombre"), ResultadoNombre.getString("posicion"), ResultadoNombre.getString("categoria"), ResultadoNombre.getInt("edad"),  ResultadoNombre.getString("nacionalidad")}; // Crear fila con datos
                        model.addRow(fila); // Añadir fila al modelo de la tabla
                    }
                     
                } catch (SQLException e1) { // Capturar excepciones de SQL
                    e1.printStackTrace(); // Imprimir traza de excepción
                }finally { // Bloque finally
                    try { // Intentar ejecutar
                        conexion.desconectar(); // Desconectar de la base de datos
                    } catch (SQLException e1) { // Capturar excepciones de SQL
                        e1.printStackTrace(); // Imprimir traza de excepción
                    }
=======
                performSearch(searchComboBox.getSelectedItem().toString(), searchField.getText());
            }
        });
        
       
        // Background Image Setup
        JLabel lblFondo = new JLabel("");
        lblFondo.setBounds(0, 0, 1200, 800);
        ImageIcon icono2 = new ImageIcon(this.getClass().getResource("/img/fondo.jpg"));
        Image imagen2 = icono2.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconoAjustado2 = new ImageIcon(imagen2);
        lblFondo.setIcon(iconoAjustado2);
        contentPane.add(lblFondo);
    }
    
    

    private  void performSearch(String field, String value) {
    	
    	DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos resultados

        // TODO: Replace with actual database connection and query execution
    	try {
        	ConexionMysql conexion = new ConexionMysql("root","test","login_proyecto");
        	conexion.conectar();
            String query = "SELECT * FROM players WHERE " + field + " = ?";
            ResultSet inicio=conexion.ejecutarSelect(query);
           
            

                // Agregar los resultados a la tabla
                while (inicio.next()) {
                    String nombre = inicio.getString("nombre");
                    String posicion = inicio.getString("posicion");
                    String categoria = inicio.getString("categoria");
                    int edad = inicio.getInt("edad");
                    String nacionalidad = inicio.getString("nacionalidad");
                    model.addRow(new Object[]{nombre, posicion, categoria, edad, nacionalidad});
>>>>>>> Stashed changes
                }
                
            }
        });
        
        // Tabla para mostrar resultados
        table = new JTable(); // Crear objeto table de tipo JTable
        table.setBounds(184, 231, 822, 450); // Establecer posición y tamaño de la tabla
        contentPane.add(table); // Agregar tabla al panel de contenido
        
        // Etiqueta para imagen de fondo
        JLabel lblFondo = new JLabel(""); // Crear objeto lblFondo de tipo JLabel
        lblFondo.setBounds(0, 0, 1200, 800); // Establecer posición y tamaño de la etiqueta
        ImageIcon icono2 = new ImageIcon(this.getClass().getResource("/img/fondo.jpg")); // Crear objeto icono2 de tipo ImageIcon con la imagen fondo.jpg
        Image imagen2 = icono2.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH); // Escalar la imagen al tamaño de la etiqueta
        ImageIcon iconoAjustado2 = new ImageIcon(imagen2); // Crear objeto iconoAjustado2 de tipo ImageIcon con la imagen escalada
        lblFondo.setIcon(iconoAjustado2); // Establecer icono escalado como imagen de fondo
        contentPane.add(lblFondo); // Agregar etiqueta al panel de contenido
        
        JScrollPane scrollPane = new JScrollPane(); // Crear objeto scrollPane de tipo JScrollPane
        scrollPane.setBounds(184, 231, 822, 450); // Establecer posición y tamaño del panel de desplazamiento
        contentPane.add(scrollPane); // Agregar panel de desplazamiento al panel de contenido
        
    }
}
