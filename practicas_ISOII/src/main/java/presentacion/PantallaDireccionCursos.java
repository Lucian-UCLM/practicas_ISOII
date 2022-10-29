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
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class PantallaDireccionCursos extends JFrame{
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	private JTable curso_table;
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
	public PantallaDireccionCursos () {
		setTitle("Dirección de cursos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel cursos_label = new JLabel("Cursos");
		cursos_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cursos_label.setBounds(55, 45, 45, 13);
		contentPane.add(cursos_label);
		
		JList curso_list = new JList();
		curso_list.setBounds(55, 68, 240, 320);
		contentPane.add(curso_list);
		
		JButton nuevo_curso_button = new JButton("Nuevo Curso");
		nuevo_curso_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		nuevo_curso_button.setBounds(438, 367, 99, 21);
		contentPane.add(nuevo_curso_button);
		
		JButton editar_curso_button = new JButton("Editar Curso");
		editar_curso_button.setBounds(603, 367, 99, 21);
		contentPane.add(editar_curso_button);
		
		JButton nueva_edicion_curso = new JButton("Nueva Edición");
		nueva_edicion_curso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		nueva_edicion_curso.setBounds(758, 367, 99, 21);
		contentPane.add(nueva_edicion_curso);
		
		JLabel informacion_curso_label = new JLabel("Datos Curso");
		informacion_curso_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		informacion_curso_label.setBounds(403, 45, 90, 13);
		contentPane.add(informacion_curso_label);
		
		curso_table = new JTable();
		curso_table.setFillsViewportHeight(true);
		curso_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre"
			}
		));
		curso_table.setBounds(403, 68, 493, 289);
		contentPane.add(curso_table);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(351, 68, 2, 320);
		contentPane.add(separator);
	}
	public void altaCurso() {
		// TODO - implement PantallaDireccionCursos.altaCurso
		throw new UnsupportedOperationException();
	}

	public void edicionCurso() {
		// TODO - implement PantallaDireccionCursos.edicionCurso
		throw new UnsupportedOperationException();
	}
}