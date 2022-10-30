package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PantallaJefeGabineteVicerrectorado extends JFrame{
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	private JTextField textField;
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
	public PantallaJefeGabineteVicerrectorado () {
		setTitle("Interfaz de jefe de gabinete");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(198, 71, 91, 231);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(43, 71, 91, 231);
		contentPane.add(list_1);
		
		JList list_2 = new JList();
		list_2.setBounds(347, 71, 91, 231);
		contentPane.add(list_2);
		
		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setBounds(198, 46, 46, 14);
		contentPane.add(lblCursos);
		
		JLabel lblEdiciones = new JLabel("Ediciones");
		lblEdiciones.setBounds(43, 48, 46, 14);
		contentPane.add(lblEdiciones);
		
		textField = new JTextField();
		textField.setBounds(43, 313, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	public void realizarConsulta() {
		// TODO - implement PantallaJefeGabineteVicerrectorado.realizarConsulta
		throw new UnsupportedOperationException();
	}
}