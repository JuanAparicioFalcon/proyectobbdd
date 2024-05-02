package proyectobbddof;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class menu2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchField;

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

        // Components
        JComboBox<String> searchComboBox = new JComboBox<>(new String[]{"Nombre", "Posición", "Categoría", "Edad", "Nacionalidad"});
        searchComboBox.setBackground(new Color(255, 255, 0));
        searchComboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar:", "Nombre", "Posición", "Categoría", "Edad", "Nacionalidad"}));
        searchComboBox.setBounds(307, 114, 144, 30);
        contentPane.add(searchComboBox);

        searchField = new JTextField();
        searchField.setBounds(484, 114, 180, 30);
        contentPane.add(searchField);

        JButton searchButton = new JButton("Buscar");
        searchButton.setBackground(new Color(255, 255, 0));
        searchButton.setForeground(new Color(0, 0, 0));
        searchButton.setBounds(694, 114, 100, 30);
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
        // TODO: Replace with actual database connection and query execution
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdatabase", "username", "password");
            String query = "SELECT * FROM players WHERE " + field + " = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();

            // Process the result set here or pass it to another component
            // For now, we will just print to console
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + ", " + rs.getString("posicion"));
            }

            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

