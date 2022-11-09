package presentacion;

import java.awt.EventQueue;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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
import negocio.controllers.*;
import negocio.entities.Centro;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.ProfesorUCLM;
import negocio.entities.TipoCurso;

public class PantallaDireccionCursos extends JFrame {
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	private JTextField nombre_text;
	private JTextField creditos_text;
	private JTextField importe_text;
	private JTextField fecha_inicio_text;
	private JTextField fecha_final_text;
	private JTextField edicion_text;
	private JTextField estado_text;
	private JTextField id_text;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	private String fecha_inicio;
	private String fecha_fin;

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

	public PantallaDireccionCursos() {
		setTitle("Dirección de cursos");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 967, 507);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		GestorPropuestasCursos gestor = new GestorPropuestasCursos(); 
		DefaultListModel model_centro = new DefaultListModel();
		DefaultListModel model_profesor = new DefaultListModel();
		DefaultListModel model_curso = new DefaultListModel();

		JLabel cursos_label = new JLabel("Cursos");
		cursos_label.setBounds(55, 45, 45, 13);
		cursos_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(cursos_label);

		JList curso_list = new JList();
		curso_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		curso_list.setBounds(55, 68, 240, 320);
		contentPane.add(curso_list);

		JList centro_list = new JList();
		centro_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		centro_list.setBounds(370, 68, 158, 154);
		contentPane.add(centro_list);

		JList director_list = new JList();
		director_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		director_list.setBounds(558, 68, 158, 154);
		contentPane.add(director_list);

		JList secretario_list = new JList();
		secretario_list.setBounds(744, 68, 158, 154);
		contentPane.add(secretario_list);
		List<CursoPropio> listacurso = new ArrayList<>();
		List<ProfesorUCLM> listaprofesor = new ArrayList<>();
		List<Centro> listacentro = new ArrayList<>(); 

		listacurso = gestor.listarCursos();
		listacentro=gestor.listarCentros();
		listaprofesor= gestor.listarProfesoresUCLM();
		for (int i=0; i< listacurso.size(); i++) {
			model_curso.addElement(listacurso.get(i).getId());
		}
		for (int i=0; i< listacentro.size(); i++) {
			model_centro.addElement(listacentro.get(i).getIdCentro());
		}
		for (int i=0; i< listaprofesor.size(); i++) {
			model_profesor.addElement(listaprofesor.get(i).getDniProfesor());
		}

		curso_list.setModel(model_curso);
		centro_list.setModel(model_centro);
		director_list.setModel(model_profesor);
		secretario_list.setModel(model_profesor);

		JButton nuevo_curso_button = new JButton("Nuevo Curso");
		nuevo_curso_button.setBounds(138, 414, 158, 21);
		contentPane.add(nuevo_curso_button);

		JComboBox tipo_combobox = new JComboBox();
		tipo_combobox.setModel(new DefaultComboBoxModel(new TipoCurso[] {TipoCurso.MASTER, TipoCurso.EXPERTO, TipoCurso.ESPECIALISTA,TipoCurso.FORMACION_AVANZADA,
				TipoCurso.FORMACION_CONTINUA,TipoCurso.MICROCREDENCIALES,TipoCurso.CORTA_DURACION,TipoCurso.CURSOS_DE_VERANO,TipoCurso.FORMACION_DE_MAYORES}));
		tipo_combobox.setToolTipText("-Cursos-\r\n");
		tipo_combobox.setBounds(690, 303, 212, 22);
		contentPane.add(tipo_combobox);

		JButton editar_curso_button = new JButton("Editar Curso");	
		editar_curso_button.setEnabled(false);
		editar_curso_button.setBounds(306, 414, 158, 21);
		contentPane.add(editar_curso_button);

		JButton edicion_button = new JButton("Nueva Edición");
		edicion_button.setEnabled(false);
		edicion_button.setBounds(473, 414, 158, 21);
		contentPane.add(edicion_button);

		JSeparator separator = new JSeparator();
		separator.setBounds(333, 68, 2, 320);
		separator.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator);

		nombre_text = new JTextField();
		nombre_text.setBounds(371, 259, 316, 19);
		contentPane.add(nombre_text);
		nombre_text.setColumns(10);

		creditos_text = new JTextField();
		creditos_text.setColumns(10);
		creditos_text.setBounds(371, 306, 60, 19);
		contentPane.add(creditos_text);

		importe_text = new JTextField();
		importe_text.setColumns(10);
		importe_text.setBounds(441, 306, 96, 19);
		contentPane.add(importe_text);

		JLabel nombre_curso_label = new JLabel("Nombre curso");
		nombre_curso_label.setBounds(370, 245, 91, 13);
		contentPane.add(nombre_curso_label);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(55, 396, 847, 8);
		contentPane.add(separator_1);

		JLabel creditos_label = new JLabel("Créditos");
		creditos_label.setBounds(370, 292, 61, 13);
		contentPane.add(creditos_label);

		JLabel importe_label = new JLabel("Importe");
		importe_label.setBounds(441, 292, 91, 13);
		contentPane.add(importe_label);

		fecha_inicio_text = new JTextField();
		fecha_inicio_text.setColumns(10);
		fecha_inicio_text.setBounds(370, 359, 135, 19);
		contentPane.add(fecha_inicio_text);

		JLabel fecha_inicio_label = new JLabel("Fecha de inicio");
		fecha_inicio_label.setBounds(370, 345, 119, 13);
		contentPane.add(fecha_inicio_label);

		JLabel centro_label = new JLabel("Centro");
		centro_label.setBounds(370, 56, 91, 13);
		contentPane.add(centro_label);

		JLabel director_label = new JLabel("Director");
		director_label.setBounds(561, 57, 135, 13);
		contentPane.add(director_label);

		JLabel secretario_label = new JLabel("Secretario");
		secretario_label.setBounds(744, 56, 119, 13);
		contentPane.add(secretario_label);

		fecha_final_text = new JTextField();
		fecha_final_text.setColumns(10);
		fecha_final_text.setBounds(515, 359, 135, 19);
		contentPane.add(fecha_final_text);

		JLabel fecha_final_label = new JLabel("Fecha de finalización");
		fecha_final_label.setBounds(515, 345, 119, 13);
		contentPane.add(fecha_final_label);

		edicion_text = new JTextField();
		edicion_text.setColumns(10);
		edicion_text.setBounds(547, 306, 96, 19);
		contentPane.add(edicion_text);

		JLabel edicion_label = new JLabel("Edición");
		edicion_label.setBounds(547, 292, 91, 13);
		contentPane.add(edicion_label);

		JButton limpiar_button = new JButton("Limpiar todo");
		limpiar_button.setBounds(641, 414, 158, 21);
		contentPane.add(limpiar_button);

		estado_text = new JTextField();
		estado_text.setEnabled(false);
		estado_text.setEditable(false);
		estado_text.setColumns(10);
		estado_text.setBounds(670, 359, 232, 19);
		contentPane.add(estado_text);

		JLabel estado_label = new JLabel("Estado");
		estado_label.setEnabled(false);
		estado_label.setBounds(670, 345, 91, 13);
		contentPane.add(estado_label);

		id_text = new JTextField();
		id_text.setColumns(10);
		id_text.setBounds(724, 259, 178, 19);
		contentPane.add(id_text);

		JLabel id_label = new JLabel("Id");
		id_label.setBounds(724, 244, 91, 13);
		contentPane.add(id_label);

		JLabel tipo_label = new JLabel("Tipo");
		tipo_label.setBounds(695, 290, 91, 13);
		contentPane.add(tipo_label);

		nuevo_curso_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!secretario_list.isSelectionEmpty() && !director_list.isSelectionEmpty() && !centro_list.isSelectionEmpty()) {
					gestor.realizarPropuestaCurso(id_text.getText(), nombre_text.getText(),
							Integer.parseInt(creditos_text.getText()), new Date(fecha_inicio_text.getText()),
							new Date(fecha_final_text.getText()), Double.parseDouble(importe_text.getText()),
							Integer.parseInt(edicion_text.getText()), EstadoCurso.PROPUESTO,TipoCurso.valueOf(tipo_combobox.getModel().getElementAt(tipo_combobox.getSelectedIndex()).toString()), 
							director_list.getModel().getElementAt(director_list.getSelectedIndex()).toString(), 
							secretario_list.getModel().getElementAt(secretario_list.getSelectedIndex()).toString(), 
							Integer.parseInt(centro_list.getModel().getElementAt(centro_list.getSelectedIndex()).toString()));

					model_curso.addElement(id_text.getText());
					curso_list.setModel(model_curso);
				}
			}
		});
		limpiar_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre_text.setText("");
				creditos_text.setText("");
				importe_text.setText("");
				fecha_inicio_text.setText("");
				fecha_final_text.setText("");
				edicion_text.setText("");
				estado_text.setText("");
				id_text.setText("");
				edicion_text.setEditable(true);
				id_text.setEditable(true);
				edicion_label.setEnabled(true);
				id_label.setEnabled(true);
				nuevo_curso_button.setEnabled(true);
				editar_curso_button.setEnabled(false);
				edicion_button.setEnabled(false);
				curso_list.clearSelection();
				centro_list.clearSelection();
				director_list.clearSelection();
				secretario_list.clearSelection();
			}
		});

		editar_curso_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!secretario_list.isSelectionEmpty() && !director_list.isSelectionEmpty() && !centro_list.isSelectionEmpty()) {
					gestor.editarPropuestaCurso(id_text.getText(), nombre_text.getText(),
							Integer.parseInt(creditos_text.getText()), new Date(fecha_inicio_text.getText()),
							new Date(fecha_final_text.getText()), Double.parseDouble(importe_text.getText()),
							Integer.parseInt(edicion_text.getText()), EstadoCurso.PROPUESTO,TipoCurso.valueOf(tipo_combobox.getModel().getElementAt(tipo_combobox.getSelectedIndex()).toString()), 
							director_list.getModel().getElementAt(director_list.getSelectedIndex()).toString(), 
							secretario_list.getModel().getElementAt(secretario_list.getSelectedIndex()).toString(), 
							Integer.parseInt(centro_list.getModel().getElementAt(centro_list.getSelectedIndex()).toString()));
				}
			}
		});
		
		edicion_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!secretario_list.isSelectionEmpty() && !director_list.isSelectionEmpty() && !centro_list.isSelectionEmpty()) {
					String[] id_num = id_text.getText().split("CPR");
					gestor.realizarPropuestaCurso(id_text.getText() + "(1)" /* "CPR" + Integer.parseInt(id[1])+1 */, nombre_text.getText(),
							Integer.parseInt(creditos_text.getText()), new Date(fecha_inicio_text.getText()),
							new Date(fecha_final_text.getText()), Double.parseDouble(importe_text.getText()),
							Integer.parseInt(edicion_text.getText())+1, EstadoCurso.PROPUESTO,TipoCurso.valueOf(tipo_combobox.getModel().getElementAt(tipo_combobox.getSelectedIndex()).toString()), 
							director_list.getModel().getElementAt(director_list.getSelectedIndex()).toString(), 
							secretario_list.getModel().getElementAt(secretario_list.getSelectedIndex()).toString(), 
							Integer.parseInt(centro_list.getModel().getElementAt(centro_list.getSelectedIndex()).toString()));

					model_curso.addElement(id_text.getText()+ "(1)");
					curso_list.setModel(model_curso);
				}
			}
		});

		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {

					String selectedItem = (String) curso_list.getSelectedValue();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
					CursoPropio curso = gestor.listarCurso(selectedItem);
					fecha_inicio = formatter.format(curso.getFechaInicio());
					fecha_fin = formatter.format(curso.getFechaFin());
					nombre_text.setText(curso.getNombre().toString());
					creditos_text.setText(curso.getECTS()+"");
					importe_text.setText(curso.getTasaMatricula()+"");
					fecha_inicio_text.setText(fecha_inicio);
					fecha_final_text.setText(fecha_fin);
					edicion_text.setText(curso.getEdicion()+"");
					estado_text.setText(curso.getEstado().toString());
					id_text.setText(selectedItem);
					edicion_text.setEditable(false);
					id_text.setEditable(false);
					edicion_label.setEnabled(false);
					id_label.setEnabled(false);
					nuevo_curso_button.setEnabled(false);
					editar_curso_button.setEnabled(true);
					edicion_button.setEnabled(true);
					for (int i = 0; i < TipoCurso.values().length; i++) {
						if(tipo_combobox.getModel().getElementAt(i).toString().equals(curso.getTipo().toString())) {
							tipo_combobox.setSelectedItem(tipo_combobox.getModel().getElementAt(i));
						}
					}
					for (int i = 0; i < centro_list.getModel().getSize(); i++) {
						if(centro_list.getModel().getElementAt(i).toString().equals(curso.getIdCentro() +"")) {
							centro_list.setSelectedIndex(i);
						}
					}
					for (int i = 0; i < director_list.getModel().getSize(); i++) {
						if(director_list.getModel().getElementAt(i).toString().equals(curso.getIdDirector())) {
							director_list.setSelectedIndex(i);
						}
					}
					for (int i = 0; i < secretario_list.getModel().getSize(); i++) {
						if(secretario_list.getModel().getElementAt(i).toString().equals(curso.getIdSecretario())) {
							secretario_list.setSelectedIndex(i);
						}
					}
					
				}
			}
		};
		curso_list.addMouseListener(mouseListener);
	}
}