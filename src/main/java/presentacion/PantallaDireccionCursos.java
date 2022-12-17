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
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

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

public class PantallaDireccionCursos extends JFrame implements ActionListener, MouseListener {
	private JLabel edicionlabel;
	private JLabel idlabel;
	
	private JTextField nombretext;
	private JTextField creditostext;
	private JTextField importetext;
	private JTextField ediciontext;
	private JTextField estadotext;
	private JTextField idtext;
	
	private JDateChooser fechainicio = new JDateChooser();
	private JDateChooser fechafin = new JDateChooser();
	
	private JButton edicionbutton = new JButton("Nueva Edición");
	private JButton limpiarbutton = new JButton("Limpiar todo");
	private JButton editarcursobutton = new JButton("Editar Curso");
	private JButton nuevocursobutton = new JButton("Nuevo Curso");
	
	private JList<String> cursolist;
	private JList<Integer> centrolist;
	private JList<String> directorlist;
	private JList<String> secretariolist;
	
	private JComboBox<TipoCurso> tipocombobox;
	
	private GestorPropuestasCursos gestor;
	private DefaultListModel<String> modelprofesor = new DefaultListModel<>();
	private DefaultListModel<String> modelcurso = new DefaultListModel<>();
	private DefaultListModel<Integer> modelcentro = new DefaultListModel<>();
	
	
	public PantallaDireccionCursos() {
		inicializarComponentes();
	}
	
	public void inicializarComponentes () {
		setTitle("Dirección de cursos");
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setBounds(100, 100, 967, 507);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		gestor = new GestorPropuestasCursos();

		JLabel cursoslabel = new JLabel("Cursos");
		cursoslabel.setBounds(55, 45, 45, 13);
		cursoslabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(cursoslabel);

		cursolist = new JList<>();
		cursolist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cursolist.setBounds(55, 68, 240, 320);
		contentPane.add(cursolist);

		centrolist = new JList<>();
		centrolist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		centrolist.setBounds(370, 68, 158, 154);
		contentPane.add(centrolist);

		directorlist = new JList<>();
		directorlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		directorlist.setBounds(558, 68, 158, 154);
		contentPane.add(directorlist);

		secretariolist = new JList<>();
		secretariolist.setBounds(744, 68, 158, 154);
		contentPane.add(secretariolist);
		
		nuevocursobutton.setBounds(138, 414, 158, 21);
		contentPane.add(nuevocursobutton);

		tipocombobox = new JComboBox<>();
		tipocombobox.setModel(new DefaultComboBoxModel<>(new TipoCurso[] {TipoCurso.MASTER, TipoCurso.EXPERTO, TipoCurso.ESPECIALISTA,TipoCurso.FORMACION_AVANZADA,
				TipoCurso.FORMACION_CONTINUA,TipoCurso.MICROCREDENCIALES,TipoCurso.CORTA_DURACION,TipoCurso.CURSOS_DE_VERANO,TipoCurso.FORMACION_DE_MAYORES}));
		tipocombobox.setToolTipText("-Cursos-\r\n");
		tipocombobox.setBounds(690, 303, 212, 22);
		contentPane.add(tipocombobox);

			
		editarcursobutton.setEnabled(false);
		editarcursobutton.setBounds(306, 414, 158, 21);
		contentPane.add(editarcursobutton);

		
		edicionbutton.setEnabled(false);
		edicionbutton.setBounds(473, 414, 158, 21);
		contentPane.add(edicionbutton);

		JSeparator separator = new JSeparator();
		separator.setBounds(333, 68, 2, 320);
		separator.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator);

		nombretext = new JTextField();
		nombretext.setBounds(371, 259, 316, 19);
		contentPane.add(nombretext);
		nombretext.setColumns(10);

		creditostext = new JTextField();
		creditostext.setColumns(10);
		creditostext.setBounds(371, 306, 60, 19);
		contentPane.add(creditostext);

		importetext = new JTextField();
		importetext.setColumns(10);
		importetext.setBounds(441, 306, 96, 19);
		contentPane.add(importetext);

		JLabel nombrecursolabel = new JLabel("Nombre curso");
		nombrecursolabel.setBounds(370, 245, 91, 13);
		contentPane.add(nombrecursolabel);

		JSeparator separator1 = new JSeparator();
		separator1.setBounds(55, 396, 847, 8);
		contentPane.add(separator1);

		JLabel creditoslabel = new JLabel("Créditos");
		creditoslabel.setBounds(370, 292, 61, 13);
		contentPane.add(creditoslabel);

		JLabel importelabel = new JLabel("Importe");
		importelabel.setBounds(441, 292, 91, 13);
		contentPane.add(importelabel);

		JLabel fechainiciolabel = new JLabel("Fecha de inicio");
		fechainiciolabel.setBounds(370, 345, 119, 13);
		contentPane.add(fechainiciolabel);

		JLabel centrolabel = new JLabel("Centro");
		centrolabel.setBounds(370, 56, 91, 13);
		contentPane.add(centrolabel);

		JLabel directorlabel = new JLabel("Director");
		directorlabel.setBounds(561, 57, 135, 13);
		contentPane.add(directorlabel);

		JLabel secretariolabel = new JLabel("Secretario");
		secretariolabel.setBounds(744, 56, 119, 13);
		contentPane.add(secretariolabel);

		JLabel fechafinallabel = new JLabel("Fecha de finalización");
		fechafinallabel.setBounds(515, 345, 119, 13);
		contentPane.add(fechafinallabel);

		ediciontext = new JTextField();
		ediciontext.setColumns(10);
		ediciontext.setBounds(547, 306, 96, 19);
		contentPane.add(ediciontext);

		edicionlabel = new JLabel("Edición");
		edicionlabel.setBounds(547, 292, 91, 13);
		contentPane.add(edicionlabel);

		limpiarbutton.setBounds(641, 414, 158, 21);
		contentPane.add(limpiarbutton);

		estadotext = new JTextField();
		estadotext.setEnabled(false);
		estadotext.setEditable(false);
		estadotext.setColumns(10);
		estadotext.setBounds(670, 359, 232, 19);
		contentPane.add(estadotext);

		JLabel estadolabel = new JLabel("Estado");
		estadolabel.setEnabled(false);
		estadolabel.setBounds(670, 345, 91, 13);
		contentPane.add(estadolabel);

		idtext = new JTextField();
		idtext.setColumns(10);
		idtext.setBounds(724, 259, 178, 19);
		contentPane.add(idtext);

		idlabel = new JLabel("Id");
		idlabel.setBounds(724, 244, 91, 13);
		contentPane.add(idlabel);

		JLabel tipolabel = new JLabel("Tipo");
		tipolabel.setBounds(695, 290, 91, 13);
		contentPane.add(tipolabel);
		
		fechainicio.setBounds(515, 359, 125, 23);
		contentPane.add(fechainicio);
		
		fechafin.setBounds(370, 359, 125, 23);
		contentPane.add(fechafin);

		nuevocursobutton.addActionListener(this);
		limpiarbutton.addActionListener(this);
		editarcursobutton.addActionListener(this);
		edicionbutton.addActionListener(this);
		
		List<CursoPropio> listacurso = gestor.listarCursos();
		List<ProfesorUCLM> listaprofesor = gestor.listarProfesoresUCLM();
		List<Centro> listacentro = gestor.listarCentros(); 
		
		for (int i=0; i< listacurso.size(); i++) {
			modelcurso.addElement(listacurso.get(i).getId());
		}
		for (int i=0; i< listacentro.size(); i++) {
			modelcentro.addElement(listacentro.get(i).getIdCentro());
		}
		for (int i=0; i< listaprofesor.size(); i++) {
			modelprofesor.addElement(listaprofesor.get(i).getDniProfesor());
		}

		cursolist.setModel(modelcurso);
		centrolist.setModel(modelcentro);
		directorlist.setModel(modelprofesor);
		secretariolist.setModel(modelprofesor);
		
		cursolist.addMouseListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nuevocursobutton && !secretariolist.isSelectionEmpty() && !directorlist.isSelectionEmpty() && !centrolist.isSelectionEmpty()) {
			gestor.realizarPropuestaCurso(idtext.getText(), nombretext.getText(),
					Integer.parseInt(creditostext.getText()), fechainicio.getDate(),
					fechafin.getDate(), Double.parseDouble(importetext.getText()),
					Integer.parseInt(ediciontext.getText()), EstadoCurso.PROPUESTO,TipoCurso.valueOf(tipocombobox.getModel().getElementAt(tipocombobox.getSelectedIndex()).toString()), 
					directorlist.getModel().getElementAt(directorlist.getSelectedIndex()), 
					secretariolist.getModel().getElementAt(secretariolist.getSelectedIndex()), 
					Integer.parseInt(centrolist.getModel().getElementAt(centrolist.getSelectedIndex()).toString()));

			modelcurso.addElement(idtext.getText());
			cursolist.setModel(modelcurso);
		}
		if (e.getSource() == limpiarbutton) {
			nombretext.setText("");
			creditostext.setText("");
			importetext.setText("");
			fechainicio.setDate(null);
			fechafin.setDate(null);
			ediciontext.setText("");
			estadotext.setText("");
			idtext.setText("");
			ediciontext.setEditable(true);
			idtext.setEditable(true);
			edicionlabel.setEnabled(true);
			idlabel.setEnabled(true);
			nuevocursobutton.setEnabled(true);
			editarcursobutton.setEnabled(false);
			edicionbutton.setEnabled(false);
			cursolist.clearSelection();
			centrolist.clearSelection();
			directorlist.clearSelection();
			secretariolist.clearSelection();
		}
		if (e.getSource() == editarcursobutton && !secretariolist.isSelectionEmpty() && !directorlist.isSelectionEmpty() && !centrolist.isSelectionEmpty()) {
			gestor.editarPropuestaCurso(idtext.getText(), nombretext.getText(),
					Integer.parseInt(creditostext.getText()), fechainicio.getDate(),
					fechafin.getDate(), Double.parseDouble(importetext.getText()),
					Integer.parseInt(ediciontext.getText()), EstadoCurso.PROPUESTO,TipoCurso.valueOf(tipocombobox.getModel().getElementAt(tipocombobox.getSelectedIndex()).toString()), 
					directorlist.getModel().getElementAt(directorlist.getSelectedIndex()), 
					secretariolist.getModel().getElementAt(secretariolist.getSelectedIndex()), 
					Integer.parseInt(centrolist.getModel().getElementAt(centrolist.getSelectedIndex()).toString()));
		}
		if (e.getSource() == edicionbutton && !secretariolist.isSelectionEmpty() && !directorlist.isSelectionEmpty() && !centrolist.isSelectionEmpty()) {
			String[] idnum = idtext.getText().split("CPR");
			gestor.realizarPropuestaCurso(idtext.getText() + "(1)" /* "CPR" + Integer.parseInt(id[1])+1 */, nombretext.getText(),
					Integer.parseInt(creditostext.getText()), fechainicio.getDate(),
					fechafin.getDate(), Double.parseDouble(importetext.getText()),
					Integer.parseInt(ediciontext.getText())+1, EstadoCurso.PROPUESTO,TipoCurso.valueOf(tipocombobox.getModel().getElementAt(tipocombobox.getSelectedIndex()).toString()), 
					directorlist.getModel().getElementAt(directorlist.getSelectedIndex()), 
					secretariolist.getModel().getElementAt(secretariolist.getSelectedIndex()), 
					Integer.parseInt(centrolist.getModel().getElementAt(centrolist.getSelectedIndex()).toString()));

			modelcurso.addElement(idtext.getText()+ "(1)");
			cursolist.setModel(modelcurso);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2 && e.getSource() == cursolist) {
			
			String selectedItem = cursolist.getSelectedValue();
			CursoPropio curso = gestor.listarCurso(selectedItem);
			
			fechainicio.setDate(curso.getFechaInicio());
			fechafin.setDate(curso.getFechaFin());
			
			nombretext.setText(curso.getNombre());
			creditostext.setText(curso.getECTS()+"");
			importetext.setText(curso.getTasaMatricula()+"");
			
			ediciontext.setText(curso.getEdicion()+"");
			estadotext.setText(curso.getEstado().toString());
			idtext.setText(selectedItem);
			ediciontext.setEditable(false);
			idtext.setEditable(false);
			edicionlabel.setEnabled(false);
			idlabel.setEnabled(false);
			nuevocursobutton.setEnabled(false);
			editarcursobutton.setEnabled(true);
			edicionbutton.setEnabled(true);
			for (int i = 0; i < TipoCurso.values().length; i++) {
				if(tipocombobox.getModel().getElementAt(i).toString().equals(curso.getTipo().toString())) {
					tipocombobox.setSelectedItem(tipocombobox.getModel().getElementAt(i));
				}
			}
			for (int i = 0; i < centrolist.getModel().getSize(); i++) {
				if(centrolist.getModel().getElementAt(i).toString().equals(curso.getIdCentro() +"")) {
					centrolist.setSelectedIndex(i);
				}
			}
			for (int i = 0; i < directorlist.getModel().getSize(); i++) {
				if(directorlist.getModel().getElementAt(i).equals(curso.getIdDirector())) {
					directorlist.setSelectedIndex(i);
				}
			}
			for (int i = 0; i < secretariolist.getModel().getSize(); i++) {
				if(secretariolist.getModel().getElementAt(i).equals(curso.getIdSecretario())) {
					secretariolist.setSelectedIndex(i);
				}
			}
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
   // TODO document why this method is empty
 }

	@Override
	public void mouseReleased(MouseEvent e) {
   // TODO document why this method is empty
 }

	@Override
	public void mouseEntered(MouseEvent e) {
   // TODO document why this method is empty
 }

	@Override
	public void mouseExited(MouseEvent e) {
   // TODO document why this method is empty
 }
}