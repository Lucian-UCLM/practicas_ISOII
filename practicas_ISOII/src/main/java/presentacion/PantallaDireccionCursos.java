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

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class PantallaDireccionCursos extends JFrame{
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	private JTable curso_table;
	private JTextField nombre_text;
	private JTextField creditos_text;
	private JTextField importe_text;
	private JTextField centro_text;
	private JTextField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaDireccionCursos frame = new PantallaDireccionCursos ();
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
		setBounds(100, 100, 967, 861);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel cursos_label = new JLabel("Cursos");
		cursos_label.setBounds(55, 45, 45, 13);
		cursos_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(cursos_label);
		
		JList curso_list = new JList();
		curso_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		curso_list.setBounds(55, 68, 240, 320);
		contentPane.add(curso_list);
		
		JButton nuevo_curso_button = new JButton("Nuevo Curso");
		nuevo_curso_button.setBounds(403, 367, 158, 21);
		nuevo_curso_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
				} catch (Exception e) {
					//mensaje de error
				}
			}
		});
		contentPane.add(nuevo_curso_button);
		
		JButton editar_curso_button = new JButton("Editar Curso");
		editar_curso_button.setEnabled(false);
		editar_curso_button.setBounds(571, 367, 158, 21);
		contentPane.add(editar_curso_button);
		
		JButton nueva_edicion_curso = new JButton("Nueva Edición");
		nueva_edicion_curso.setEnabled(false);
		nueva_edicion_curso.setBounds(738, 367, 158, 21);
		nueva_edicion_curso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(nueva_edicion_curso);
		
		JLabel informacion_curso_label = new JLabel("Datos Curso");
		informacion_curso_label.setBounds(403, 45, 90, 13);
		informacion_curso_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(informacion_curso_label);
		
		curso_table = new JTable();
		curso_table.setBounds(403, 68, 493, 289);
		curso_table.setFillsViewportHeight(true);
		curso_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Centro", "Duraci\u00F3n (meses)", "Creditos", "Nombre"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		contentPane.add(curso_table);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(351, 68, 2, 320);
		separator.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator);
		
		nombre_text = new JTextField();
		nombre_text.setBounds(404, 450, 316, 19);
		contentPane.add(nombre_text);
		nombre_text.setColumns(10);
		
		creditos_text = new JTextField();
		creditos_text.setColumns(10);
		creditos_text.setBounds(730, 450, 60, 19);
		contentPane.add(creditos_text);
		
		importe_text = new JTextField();
		importe_text.setColumns(10);
		importe_text.setBounds(800, 450, 96, 19);
		contentPane.add(importe_text);
		
		JLabel nombre_curso_label = new JLabel("Nombre curso");
		nombre_curso_label.setBounds(403, 436, 91, 13);
		contentPane.add(nombre_curso_label);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(403, 410, 493, 8);
		contentPane.add(separator_1);
		
		JLabel creditos_label = new JLabel("Créditos");
		creditos_label.setBounds(729, 436, 61, 13);
		contentPane.add(creditos_label);
		
		JLabel importe_label = new JLabel("Importe");
		importe_label.setBounds(800, 436, 91, 13);
		contentPane.add(importe_label);
		
		JLabel centro_label = new JLabel("Centro");
		centro_label.setBounds(403, 493, 91, 13);
		contentPane.add(centro_label);
		
		centro_text = new JTextField();
		centro_text.setColumns(10);
		centro_text.setBounds(404, 507, 386, 19);
		contentPane.add(centro_text);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(800, 507, 96, 19);
		contentPane.add(textField_1);
		
		JLabel duracion_label = new JLabel("Duración (meses)");
		duracion_label.setBounds(800, 493, 119, 13);
		contentPane.add(duracion_label);
		
		JLabel materias_label = new JLabel("Materias");
		materias_label.setBounds(403, 559, 91, 13);
		contentPane.add(materias_label);
		
		JLabel prof_responsable_label = new JLabel("Profesor responsable");
		prof_responsable_label.setBounds(594, 559, 135, 13);
		contentPane.add(prof_responsable_label);
		
		JLabel otros_prof_label = new JLabel("Otros profesores");
		otros_prof_label.setBounds(777, 559, 119, 13);
		contentPane.add(otros_prof_label);
		
		JList materias_list = new JList();
		materias_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		materias_list.setBounds(403, 571, 119, 154);
		contentPane.add(materias_list);
		
		JList prof_responsable_list = new JList();
		prof_responsable_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		prof_responsable_list.setBounds(594, 571, 119, 154);
		contentPane.add(prof_responsable_list);
		
		JList otros_profesores_list = new JList();
		otros_profesores_list.setBounds(777, 571, 119, 154);
		contentPane.add(otros_profesores_list);
	}
	public void altaCurso() {
		throw new UnsupportedOperationException();
	}

	public void edicionCurso() {
		// TODO - implement PantallaDireccionCursos.edicionCurso
		throw new UnsupportedOperationException();
	}
}