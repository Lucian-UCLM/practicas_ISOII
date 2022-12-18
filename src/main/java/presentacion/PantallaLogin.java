package presentacion;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.JTextField;

public class PantallaLogin extends JFrame implements ActionListener {
	
	private JButton loginButton = new JButton("Login");
	public static void main(String[] args) {
		PantallaLogin frame = new PantallaLogin ();
		frame.setVisible(true);
	}
	public PantallaLogin () {
		inicializarElementos();
	}
	public void login() {
		// TODO - implement PantallaLogin.login
		throw new UnsupportedOperationException();
	}

	public void logout() {
		// TODO - implement PantallaLogin.logout
		throw new UnsupportedOperationException();
	}
	public void inicializarElementos() {
		setTitle("Interfaz de login");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 204);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField usuarioField = new JTextField();
		usuarioField.setBounds(74, 47, 179, 20);
		contentPane.add(usuarioField);
		usuarioField.setColumns(10);
		
		JTextField passField = new JTextField();
		passField.setColumns(10);
		passField.setBounds(74, 101, 179, 20);
		contentPane.add(passField);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(74, 24, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setBounds(74, 78, 70, 14);
		contentPane.add(lblContrasenia);
				
		JLabel lblUsuarioIncorrecto = new JLabel("¡Usuario incorrecto!");
		lblUsuarioIncorrecto.setBounds(149, 24, 104, 14);
		contentPane.add(lblUsuarioIncorrecto);
		
		JLabel lblContraseniaIncorrecta = new JLabel("¡Contraseña incorrecta!");
		lblContraseniaIncorrecta.setBounds(149, 78, 122, 14);
		contentPane.add(lblContraseniaIncorrecta);
		
		this.loginButton.addActionListener(this);
		this.loginButton.setBounds(129, 131, 70, 23);
		this.add(loginButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== loginButton) {
			PantallaPrincipal frame = new PantallaPrincipal ();
			frame.setVisible(true);
		}
	}
	
}