package presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PantallaEmpleadosVicerrectorado extends JFrame {
	private JPanel contentPane;
	private JTextPane textPaneEstado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaLogin frame = new PantallaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PantallaEmpleadosVicerrectorado() {
		setTitle("Interfaz de login");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 446, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cursos");
		lblNewLabel.setBounds(99, 50, 41, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecciona un Estado", "Propuesto", "Validado", "Rechazado", "En matriculación", "En impartición", "Terminado"}));
		comboBox.setToolTipText("-Cursos-\r\n");
		comboBox.setBounds(47, 282, 147, 22);
		contentPane.add(comboBox);
		
		JList list = new JList();
		list.setBounds(235, 69, 147, 202);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Aplicar");
		btnNewButton.setBounds(71, 315, 89, 23);
		contentPane.add(btnNewButton);
		
		JList list_1 = new JList();
		list_1.setBounds(47, 69, 147, 202);
		contentPane.add(list_1);
		
		JLabel lblCursosAprobados = new JLabel("Cursos Aprobados \"Validados\"");
		lblCursosAprobados.setBounds(258, 50, 162, 14);
		contentPane.add(lblCursosAprobados);
		
		JButton btnNewButton_1 = new JButton("Dar de Alta");
		btnNewButton_1.setBounds(258, 282, 89, 23);
		contentPane.add(btnNewButton_1);
	}

	public void evaluarCurso() {
		throw new UnsupportedOperationException();
	}
}