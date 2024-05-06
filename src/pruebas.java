import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import proyectobbddof.Registrarse;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pruebas extends JFrame {
	private JTextField nombreField;
	private JTextField posicionField;
	private JTextField edadField;
	private JTextField categoriaField;
	private JTextField nacionalidadField;
	private JButton addButton;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pruebas frame = new pruebas();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	

		    
	}
	 
	public pruebas() {

	     JPanel panel = new JPanel();
	     JButton addButton = new JButton("Añadir jugador");
	     addButton.addMouseListener(new MouseAdapter() {
	     	@Override
	     	public void mouseClicked(MouseEvent e) {
	     		
					camposprueba fr= new camposprueba();
					fr.setVisible(true);
				
	     	}
	     });
		        
		        addButton.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                // Crear la ventana de diálogo para añadir jugador
		                JFrame dialog = new JFrame("Añadir Jugador");
		                JPanel dialogPanel = new JPanel(new GridLayout(5, 2));
		                
		                JTextField nombreField = new JTextField(20);
		                JTextField posicionField = new JTextField(20);
		                JTextField edadField = new JTextField(20);
		                JTextField categoriaField = new JTextField(20);
		                JTextField nacionalidadField = new JTextField(20);
		                
		            
		                
		                JButton addButton = new JButton("Añadir");
		                addButton.addActionListener(new ActionListener() {
		                    public void actionPerformed(ActionEvent e) {
		                        // Obtener los datos del jugador ingresados por el usuario
		                        String nombre = nombreField.getText();
		                        String posicion = posicionField.getText();
		                        int edad = Integer.parseInt(edadField.getText());
		                        String categoria = categoriaField.getText();
		                        String nacionalidad = nacionalidadField.getText();

		                       
		
		                    }
	}
	
		                });
		        });
	}
		              

	
		                
		           

	

	
