package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet.ColorAttribute;

import negocio.controllers.GestorPropuestasCursos;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.TipoCurso;

import javax.swing.border.LineBorder;
import javax.swing.plaf.synth.ColorType;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.toedter.calendar.JDateChooser;

public class PantallaJefeGabineteVicerrectorado extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	private JTable table;
	
	private JLabel not_selected_label = new JLabel("Seleccione Campos");
	private JLabel ingresos_cantidad_label = new JLabel("");
	
	private JComboBox<String> comboBox = new JComboBox<>();
	private JCheckBox chckbxNombre = new JCheckBox("Nombre");
	private JCheckBox chckbxCentro = new JCheckBox("Centro");
	private JCheckBox chckbxCrditos = new JCheckBox("Créditos");
	private JCheckBox chckbxImporte = new JCheckBox("Importe");
	private JCheckBox chckbxEdicin = new JCheckBox("Edición");
	
	private JDateChooser campoFechaInicio = new JDateChooser();
	private JDateChooser campoFechaFin = new JDateChooser();
	
	private JButton botonConsulta = new JButton("Consultar");
	
	private DefaultListModel<String> model_curso = new DefaultListModel<>();
	private GestorPropuestasCursos gestor = new GestorPropuestasCursos();
	
	//variables globales para las consultas
	private int numFilas = 0;
	private double ingresos = 0.0;
	private List<CursoPropio> listacurso = gestor.listarCursos();
	private List<CursoPropio> listaConsulta = new ArrayList<>();
	
	public PantallaJefeGabineteVicerrectorado() {
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setTitle("Interfaz de jefe de gabinete");
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setBounds(100, 100, 180, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String font = "Tahoma";
		
		not_selected_label.setHorizontalAlignment(SwingConstants.LEFT);
		not_selected_label.setFont(new Font(font, Font.BOLD, 11));
		not_selected_label.setBounds(29, 26, 157, 14);
		contentPane.add(not_selected_label);
		
		chckbxNombre.setBounds(31, 47, 97, 23);
		contentPane.add(chckbxNombre);
		
		chckbxCentro.setBounds(31, 73, 97, 23);
		contentPane.add(chckbxCentro);
		
		chckbxCrditos.setBounds(31, 99, 97, 23);
		contentPane.add(chckbxCrditos);
		
		chckbxImporte.setBounds(31, 125, 97, 23);
		contentPane.add(chckbxImporte);
		
		chckbxEdicin.setBounds(31, 151, 97, 23);
		contentPane.add(chckbxEdicin);

		comboBox.setMaximumRowCount(9);
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Ninguno seleccionado", "MASTER", "EXPERTO", "ESPECIALISTA", 
				"FORMACION_AVANZADA", "FORMACION_CONTINUA", "MICROCREDENCIALES", "CORTA_DURACION", "CURSOS_DE_VERANO", "FORMACION_DE_MAYORES"}));
		comboBox.setBounds(29, 292, 125, 22);
		contentPane.add(comboBox);

		JLabel fechaInicio = new JLabel("Fecha Inicio");
		fechaInicio.setBounds(29, 190, 73, 14);
		contentPane.add(fechaInicio);

		JLabel fechaFin = new JLabel("Fecha Fin");
		fechaFin.setBounds(29, 249, 73, 14);
		contentPane.add(fechaFin);

		botonConsulta.setBounds(31, 326, 89, 23);
		contentPane.add(botonConsulta);
		
		JLabel Ingresos_label = new JLabel("Ingresos");
		Ingresos_label.setFont(new Font(font, Font.BOLD, 13));
		Ingresos_label.setBounds(290, 330, 97, 13);
		contentPane.add(Ingresos_label);
		
		ingresos_cantidad_label.setFont(new Font(font, Font.BOLD | Font.ITALIC, 15));
		ingresos_cantidad_label.setBounds(398, 331, 216, 13);
		contentPane.add(ingresos_cantidad_label);
		
		campoFechaInicio.setBounds(29, 204, 146, 23);
		contentPane.add(campoFechaInicio);
		
		campoFechaFin.setBounds(29, 263, 146, 19);
		contentPane.add(campoFechaFin);
		setBounds(100, 100, 900, 400);
		
		botonConsulta.addActionListener(this);
	}
	public void rellenarMatriz(int numColumnas, String[] arrayToCopy) {
		
		Object[][] matriz = new Object[numFilas][numColumnas];
		String[] campos = new String [numColumnas];
		System.arraycopy(arrayToCopy, 0, campos, 0, numColumnas);
		
		ingresos_cantidad_label.setText(String.valueOf(ingresos) + " €");
		ingresos_cantidad_label.setForeground(Color.BLUE);
		
		for (int i = 0; i < listaConsulta.size(); i++) {
			matriz[i][0] = listaConsulta.get(i).getNombre();
		}

		for (int j = 0; j < campos.length; j++) {

			if (campos[j].equals("Centro")) {
				for (int i = 0; i < listaConsulta.size(); i++) {
					matriz[i][j] = listaConsulta.get(i).getIdCentro();
				}
			}else if (campos[j].equals("Créditos")) {
				for (int i = 0; i < listaConsulta.size(); i++) {
					matriz[i][j] = listaConsulta.get(i).getECTS();
				}
			}else if (campos[j].equals("Importe")) {
				for (int i = 0; i < listaConsulta.size(); i++) {
					matriz[i][j] = listaConsulta.get(i).getTasaMatricula();
				}
			}else if (campos[j].equals("Edición")) {
				for (int i = 0; i < listaConsulta.size(); i++) {
					matriz[i][j] = listaConsulta.get(i).getEdicion();
				}
			}else if (campos[j].equals("Estado")) {
				for (int i = 0; i < listaConsulta.size(); i++) {
					matriz[i][j] = listaConsulta.get(i).getEstado();
				}
			}
		}
		mostrarConsulta(matriz, campos);
	}
	
	public void mostrarConsulta(Object[][] matrizInfo, String[] campos) {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(159, 47, 700, 277);
		contentPane.add(scrollPane);
		
		table = new JTable(matrizInfo, campos);
		
		table.setToolTipText("");
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
	}
	
	public void realizarConsulta() {
		for (int j = 0; j < listacurso.size(); j++) {
			
			if(campoFechaInicio.getDate() != null && campoFechaFin.getDate() !=null) {
				if (campoFechaInicio.getDate().compareTo(listacurso.get(j).getFechaInicio())<=0 && campoFechaFin.getDate().compareTo(listacurso.get(j).getFechaFin())>=0){
					model_curso.addElement(listacurso.get(j).getId());
					listaConsulta.add(listacurso.get(j));
					ingresos += listacurso.get(j).getTasaMatricula(); //*listacurso.get(j).getNumeroDeMatriculas
					numFilas++;
				}
			}else {
				model_curso.addElement(listacurso.get(j).getId());
				listaConsulta.add(listacurso.get(j));
				ingresos += listacurso.get(j).getTasaMatricula(); //*listacurso.get(j).getNumeroDeMatriculas
				numFilas++;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonConsulta) { 
			int numColumnas = 0;
			numFilas = 0;
			ingresos = 0.0;
			
			listacurso = gestor.listarCursos();
			listaConsulta = new ArrayList<>();
			String[] aux = new String[8];
			
			if (!comboBox.getModel().getSelectedItem().equals("Ninguno seleccionado")) {
				listacurso = gestor.listarCursosWhere(TipoCurso.valueOf(comboBox.getModel().getElementAt(comboBox.getSelectedIndex())));
			}
			
			if (chckbxNombre.isSelected()) {
				aux[numColumnas] = chckbxNombre.getText();
				numColumnas++;
			}
			if (chckbxCentro.isSelected()) {
				aux[numColumnas] = chckbxCentro.getText();
				numColumnas++;
			}
			if (chckbxCrditos.isSelected()) {
				aux[numColumnas] = chckbxCrditos.getText();
				numColumnas++;
			}
			if (chckbxImporte.isSelected()) {
				aux[numColumnas] = chckbxImporte.getText();
				numColumnas++;
			}
			if (chckbxEdicin.isSelected()) {
				aux[numColumnas] = chckbxEdicin.getText();
				numColumnas++;
			}
			
			if (numColumnas == 0) {
				not_selected_label.setText("SELECCIONE CAMPOS");
				not_selected_label.setForeground(Color.RED);
				ingresos_cantidad_label.setText("");
				return;
			}
			realizarConsulta();
			rellenarMatriz(numColumnas, aux);
		}
		
	}
}