package proyectobbddof;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setForeground(new Color(0, 128, 0));
		lblFondo.setBounds(0, 0, 1980, 1080);
		lblFondo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblFondo);
		ImageIcon icono2=new ImageIcon(InicioSesion.class.getResource("/img/fondo.jpg"));
				Image imagen2 =	icono2.getImage().getScaledInstance(lblFondo.getWidth(),lblFondo.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon iconoAjustado2 = new ImageIcon(imagen2);
				lblFondo.setIcon(iconoAjustado2);
	}

}
