package presentacion;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import negocio.controllers.GestorPropuestasCursos;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.Color;


public class PantallaEmpleadosVicerrectorado extends JFrame {
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	private JTextField fecha_propuesto_text;

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
		setBounds(100, 100, 650, 347);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList curso_list = new JList();
		curso_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		curso_list.setBounds(47, 69, 147, 202);
		contentPane.add(curso_list);
		
		GestorPropuestasCursos gestor = new GestorPropuestasCursos(); 
		List<CursoPropio> lista = new ArrayList<>(); 
		lista = gestor.listarCursos();
		DefaultListModel model_curso = new DefaultListModel();
		int i=0;
		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			model_curso.addElement(lista.get(i).getId());
			iterator.next();
			i++;
		}
		
		curso_list.setModel(model_curso);
		
		JLabel curso_label = new JLabel("Cursos");
		curso_label.setBounds(47, 50, 41, 14);
		contentPane.add(curso_label);
		
		JComboBox estado_combobox = new JComboBox();
		estado_combobox.setModel(new DefaultComboBoxModel(new EstadoCurso[] {EstadoCurso.PROPUESTO, EstadoCurso.VALIDADO, EstadoCurso.PROPUESTA_RECHAZADA}));
		estado_combobox.setToolTipText("-Cursos-\r\n");
		estado_combobox.setBounds(204, 192, 103, 22);
		contentPane.add(estado_combobox);
		
		JList curso_aprobado_list = new JList();
		curso_aprobado_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		curso_aprobado_list.setBounds(360, 69, 147, 202);
		contentPane.add(curso_aprobado_list);
		
		JButton aplicar_button = new JButton("Aplicar");
		aplicar_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		aplicar_button.setBounds(204, 248, 89, 23);
		contentPane.add(aplicar_button);
		
		JLabel curso_aprobados_label = new JLabel("Cursos Aprobados \"Validados\"");
		curso_aprobados_label.setBounds(360, 50, 187, 14);
		contentPane.add(curso_aprobados_label);
		
		JButton dar_alta_button = new JButton("Dar de Alta");
		dar_alta_button.setBounds(517, 248, 109, 23);
		contentPane.add(dar_alta_button);
		
		JLabel fecha_propuesto_label = new JLabel("Curso propuesto el:");
		fecha_propuesto_label.setBounds(204, 69, 146, 22);
		contentPane.add(fecha_propuesto_label);
		
		fecha_propuesto_text = new JTextField();
		fecha_propuesto_text.setEditable(false);
		fecha_propuesto_text.setBounds(204, 89, 96, 19);
		contentPane.add(fecha_propuesto_text);
		fecha_propuesto_text.setColumns(10);
	}

	public void evaluarCurso() {
		throw new UnsupportedOperationException();
	}
}