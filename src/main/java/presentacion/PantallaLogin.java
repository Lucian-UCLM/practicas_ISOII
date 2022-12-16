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
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	private JTextField textField;
	private JTextField textField_1;
	public static void main(String[] args) {
		PantallaLogin frame = new PantallaLogin ();
		frame.setVisible(true);
	}
	public PantallaLogin () {
		super();
		setTitle("Interfaz de login");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
				PantallaPrincipal frame = new PantallaPrincipal ();
				frame.setVisible(true);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}