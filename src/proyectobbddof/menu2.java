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
        
        JButton btnNewButton = new JButton("Actualizar");
        btnNewButton.setBounds(886, 115, 89, 23);
        contentPane.add(btnNewButton);
        
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
    	
    	int opcion = searchComboBox.
    }
    public void mostrarDatosCliente(int opbuscar, String valor) {
    	DefaultTableModel tcliente = new DefaultTableModel();
    	tcliente.addColumn("NOMBRE");
    	tcliente.addColumn("POSICION");
    	tcliente.addColumn("EDAD");
    	tcliente.addColumn("CATEGORIA");
    	tcliente.addColumn("NACIONALIDAD");
    	table.setModel(tcliente);
    	
    	String codsql;
    	
    	if(opbuscar == 0 && valor ==null) {
    		codsql= "SELECT * FROM Cantera WHERE Nombre= '"+valor+"'";
    	}else {
    		if(opbuscar ==1 && valor !=null) {
    			codsql= "SELECT * FROM Cantera WHERE Posicion = '"+valor+"'";
    		}else {
    			if(opbuscar ==2 && valor !=null) {
    			codsql= "SELECT * FROM Cantera WHERE Edad = '"+valor+"'";
    			}else {
    				if(opbuscar ==3 && valor !=null){
    					codsql= "SELECT * FROM Cantera WHERE Categoria = '"+valor+"'";
    				}else {
    					if(opbuscar ==4 && valor !=null) {
    						codsql= "SELECT * FROM Cantera WHERE Nacionalidad = '"+valor+"'";
    					}
    				}
    			}
    		}
    	}
    }
    public void Actualizar() {
    	ConexionMysql conexion = new ConexionMysql("root","test","login_proyecto");
    	int fila= table.getSelectedRow();
    	String Nombre = table.getValueAt(fila, 0).toString();
    	String Posicion = table.getValueAt(fila, 1).toString();
    	int Edad = Integer.parseInt(this.table.getValueAt(fila, 2).toString());
    	String Categoria = table.getValueAt(fila, 3).toString();
    	String Nacionalidad = table.getValueAt(fila, 4).toString();
    	
    	try {
    		conexion.conectar();
			String sentencia2="UPDATE Cantera SET Nombre='"+Nombre+"',Posicion='"+Posicion+"',Edad='"+Edad+"',Categoria='"+Categoria+"',Nacionalidad='"+Nacionalidad+"')";
			 conexion.ejecutarInsertDeleteUpdate(sentencia2);
			 mostrarDatosCliente(0,null);
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
}