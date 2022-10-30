package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PantallaMatriculacion extends JFrame{
	private JPanel contentPane;
	private JTextPane textPaneEstado;
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
	public PantallaMatriculacion () {
		setTitle("Interfaz de Matriculacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(33, 61, 183, 310);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("Cursos");
		lblNewLabel.setBounds(33, 36, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Realizar Matricula");
		btnNewButton.setBounds(553, 348, 124, 23);
		contentPane.add(btnNewButton);
	}
	public void realizarMatriculacion() {
		// TODO - implement PantallaMatriculaci�n.realizarMatriculacion
		throw new UnsupportedOperationException();
	}
}