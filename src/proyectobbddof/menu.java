package proyectobbddof;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Conexionbbdd.ConexionMysql;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class menu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchField;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                menu frame = new menu();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public menu() {
        setTitle("Manager App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JComboBox<String> searchComboBox = new JComboBox<>(new String[]{"Nombre", "Posición", "Categoría", "Edad", "Nacionalidad"});
        searchComboBox.setBounds(20, 20, 180, 30);
        contentPane.add(searchComboBox);

        searchField = new JTextField();
        searchField.setBounds(210, 20, 180, 30);
        contentPane.add(searchField);

        JButton searchButton = new JButton("Buscar");
        searchButton.setBounds(400, 20, 100, 30);
        contentPane.add(searchButton);

        // Crear la tabla
        table = new JTable();
        table.setBounds(20, 80, 740, 400); // Ubicación y tamaño de la tabla
        contentPane.add(table);

        // Configurar el modelo de la tabla con las columnas
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Posición");
        model.addColumn("Categoría");
        model.addColumn("Edad");
        model.addColumn("Nacionalidad");
        table.setModel(model);

        // Acción del botón de búsqueda
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performSearch(searchComboBox.getSelectedItem().toString(), searchField.getText());
            }
        });
    }

    private void performSearch(String field, String value) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos resultados

        // Realizar la búsqueda en la base de datos
        try {
        	ConexionMysql conexion = new ConexionMysql("root","test","login_proyecto");
        	conexion.conectar();
            String query = "SELECT * FROM players WHERE " + field + " = ?";
            ResultSet inicio=conexion.ejecutarSelect(query);
            if(inicio.next()) {
            	
            }
            
            conexion.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fallo en la busqueda.");
        }
    }
}
