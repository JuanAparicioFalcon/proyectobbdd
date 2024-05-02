package proyectobbddof;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Conexionbbdd.ConexionMysql;

import javax.swing.JOptionPane;


import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menu2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchField;
    private JTable table;
   
    
   
    

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                menu2 frame = new menu2();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public menu2() {
			
			
		

        setTitle("Manager App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 800);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        table = new JTable();
        table.setBounds(184, 231, 822, 214);
        contentPane.add(table);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Posición");
        model.addColumn("Categoría");
        model.addColumn("Edad");
        model.addColumn("Nacionalidad");
        table.setModel(model);

        // Components
        JComboBox<String> searchComboBox = new JComboBox<>(new String[]{"Nombre", "Posición", "Categoría", "Edad", "Nacionalidad"});
        searchComboBox.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
        searchComboBox.setBackground(new Color(255, 255, 0));
        searchComboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar:", "Nombre", "Posición", "Categoría", "Edad", "Nacionalidad"}));
        searchComboBox.setBounds(287, 109, 165, 35);
        contentPane.add(searchComboBox);

        searchField = new JTextField();
        searchField.setBounds(494, 109, 198, 35);
        contentPane.add(searchField);

        JButton searchButton = new JButton("Buscar");
        searchButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		 performSearch(searchComboBox.getSelectedItem().toString(), searchField.getText());
        		
        	}
        });
        searchButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
        searchButton.setBackground(new Color(255, 255, 0));
        searchButton.setForeground(new Color(0, 0, 0));
        searchButton.setBounds(733, 113, 87, 27);
        contentPane.add(searchButton);

        // Search action
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
    
    

    private void performSearch(String field, String value) {
    	
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
                }
                
                inicio.close();
            
            conexion.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fallo en la busqueda.");
        }
    }
}

