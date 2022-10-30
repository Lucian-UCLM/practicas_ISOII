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
	private JTextField fecha_inicio_text;
	private JTextField fecha_final_text;
	private JTextField edicion_text;
	private JTextField estado_text;
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
		nuevo_curso_button.setBounds(55, 764, 158, 21);
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
		editar_curso_button.setBounds(223, 764, 158, 21);
		contentPane.add(editar_curso_button);
		
		
		JButton edicion_button = new JButton("Nueva Edición");
		edicion_button.setEnabled(false);
		edicion_button.setBounds(390, 764, 158, 21);
		edicion_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(edicion_button);
		
		JLabel informacion_curso_label = new JLabel("Datos Curso");
		informacion_curso_label.setBounds(403, 45, 90, 13);
		informacion_curso_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(informacion_curso_label);
		
		curso_table = new JTable();
		curso_table.setBounds(403, 68, 493, 320);
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
		nombre_text.setBounds(56, 462, 316, 19);
		contentPane.add(nombre_text);
		nombre_text.setColumns(10);
		
		creditos_text = new JTextField();
		creditos_text.setColumns(10);
		creditos_text.setBounds(382, 462, 60, 19);
		contentPane.add(creditos_text);
		
		importe_text = new JTextField();
		importe_text.setColumns(10);
		importe_text.setBounds(452, 462, 96, 19);
		contentPane.add(importe_text);
		
		JLabel nombre_curso_label = new JLabel("Nombre curso");
		nombre_curso_label.setBounds(55, 448, 91, 13);
		contentPane.add(nombre_curso_label);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(55, 410, 841, 8);
		contentPane.add(separator_1);
		
		JLabel creditos_label = new JLabel("Créditos");
		creditos_label.setBounds(381, 448, 61, 13);
		contentPane.add(creditos_label);
		
		JLabel importe_label = new JLabel("Importe");
		importe_label.setBounds(452, 448, 91, 13);
		contentPane.add(importe_label);
		
		JLabel centro_label = new JLabel("Centro");
		centro_label.setBounds(55, 505, 91, 13);
		contentPane.add(centro_label);
		
		centro_text = new JTextField();
		centro_text.setColumns(10);
		centro_text.setBounds(56, 519, 386, 19);
		contentPane.add(centro_text);
		
		fecha_inicio_text = new JTextField();
		fecha_inicio_text.setColumns(10);
		fecha_inicio_text.setBounds(452, 519, 96, 19);
		contentPane.add(fecha_inicio_text);
		
		JLabel fecha_inicio_label = new JLabel("Fecha de inicio");
		fecha_inicio_label.setBounds(452, 505, 119, 13);
		contentPane.add(fecha_inicio_label);
		
		JLabel materias_label = new JLabel("Materias");
		materias_label.setBounds(55, 571, 91, 13);
		contentPane.add(materias_label);
		
		JLabel prof_responsable_label = new JLabel("Profesor responsable");
		prof_responsable_label.setBounds(246, 571, 135, 13);
		contentPane.add(prof_responsable_label);
		
		JLabel otros_prof_label = new JLabel("Otros profesores");
		otros_prof_label.setBounds(429, 571, 119, 13);
		contentPane.add(otros_prof_label);
		
		JList materias_list = new JList();
		materias_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		materias_list.setBounds(55, 583, 119, 154);
		contentPane.add(materias_list);
		
		JList prof_responsable_list = new JList();
		prof_responsable_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		prof_responsable_list.setBounds(246, 583, 119, 154);
		contentPane.add(prof_responsable_list);
		
		JList otros_profesores_list = new JList();
		otros_profesores_list.setBounds(429, 583, 119, 154);
		contentPane.add(otros_profesores_list);
		
		fecha_final_text = new JTextField();
		fecha_final_text.setColumns(10);
		fecha_final_text.setBounds(558, 519, 96, 19);
		contentPane.add(fecha_final_text);
		
		JLabel fecha_final_label = new JLabel("Fecha de finalización");
		fecha_final_label.setBounds(558, 505, 119, 13);
		contentPane.add(fecha_final_label);
		
		edicion_text = new JTextField();
		edicion_text.setColumns(10);
		edicion_text.setBounds(558, 462, 96, 19);
		contentPane.add(edicion_text);
		
		JLabel edicion_label = new JLabel("Edición");
		edicion_label.setBounds(558, 448, 91, 13);
		contentPane.add(edicion_label);
		
		JButton vaciar_button = new JButton("Vaciar todo");
		vaciar_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre_text.setText("");
				centro_text.setText("");
				creditos_text.setText("");
				importe_text.setText("");
				fecha_inicio_text.setText("");
				fecha_final_text.setText("");
				edicion_text.setText("");
				estado_text.setText("");
				materias_list.clearSelection();
				prof_responsable_list.clearSelection();
				otros_profesores_list.clearSelection();
				editar_curso_button.disable();
				edicion_button.disable();
			}
		});
		vaciar_button.setBounds(558, 764, 158, 21);
		contentPane.add(vaciar_button);
		
		estado_text = new JTextField();
		estado_text.setEnabled(false);
		estado_text.setEditable(false);
		estado_text.setColumns(10);
		estado_text.setBounds(664, 462, 96, 19);
		contentPane.add(estado_text);
		
		JLabel estado_label = new JLabel("Estado");
		estado_label.setEnabled(false);
		estado_label.setBounds(664, 448, 91, 13);
		contentPane.add(estado_label);
	}
	public void altaCurso() {
		throw new UnsupportedOperationException();
	}

	public void edicionCurso() {
		// TODO - implement PantallaDireccionCursos.edicionCurso
		throw new UnsupportedOperationException();
	}
}