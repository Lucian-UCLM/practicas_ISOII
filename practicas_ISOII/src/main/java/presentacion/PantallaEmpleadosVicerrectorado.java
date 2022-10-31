package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class PantallaEmpleadosVicerrectorado extends JFrame{
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
	public PantallaEmpleadosVicerrectorado () {
		setTitle("Interfaz de login");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 356, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void evaluarCurso() {
		// TODO - implement PantallaEmpleadosVicerrectorado.evaluarCurso
		throw new UnsupportedOperationException();
	}

}