package presentacion;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import Presentacion.IU_Administrador;
//import Presentacion.IU_InscribirSocio;

import javax.swing.JLabel;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class PantallaLogin extends JFrame {
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	private JTextField textField;
	private JTextField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaLogin frame = new PantallaLogin ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		}); 
	}
	public PantallaLogin () {
		setTitle("Interfaz de login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 204);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(74, 47, 179, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(74, 101, 179, 20);
		contentPane.add(textField_1);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(74, 24, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setBounds(74, 78, 70, 14);
		contentPane.add(lblContrasenia);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PantallaPrincipal frame = new PantallaPrincipal ();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} 
				});
			}
		});
		btnNewButton.setBounds(129, 131, 70, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblUsuarioIncorrecto = new JLabel("¡Usuario incorrecto!");
		lblUsuarioIncorrecto.setBounds(149, 24, 104, 14);
		contentPane.add(lblUsuarioIncorrecto);
		
		JLabel lblContraseniaIncorrecta = new JLabel("¡Contraseña incorrecta!");
		lblContraseniaIncorrecta.setBounds(149, 78, 122, 14);
		contentPane.add(lblContraseniaIncorrecta);
	}
	public void login() {
		// TODO - implement PantallaLogin.login
		throw new UnsupportedOperationException();
	}

	public void logout() {
		// TODO - implement PantallaLogin.logout
		throw new UnsupportedOperationException();
	}
}