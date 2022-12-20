package presentacion;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import javax.swing.WindowConstants;
import java.awt.Color;

public class PantallaEmpleadosVicerrectorado extends JFrame implements ActionListener{
	private JPanel contentPane;
	private DefaultListModel<String> modelCurso = new DefaultListModel<>();
	private DefaultListModel<String> modelCursoAprobado = new DefaultListModel<>();
	
	private JButton darAltaButon = new JButton("Dar de Alta");
	private JButton aplicarButon = new JButton("Aplicar");
	
	private GestorPropuestasCursos gestor = new GestorPropuestasCursos();
	
	private JList<String> cursoList = new JList<>();
	private JList<String> cursoAprobadoList = new JList<>();
	private JComboBox<Object> estadoCombobox = new JComboBox<>();

	public PantallaEmpleadosVicerrectorado() {
		setTitle("Interfaz de login");
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setBounds(100, 100, 650, 347);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cursoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cursoList.setBounds(47, 69, 147, 202);
		contentPane.add(cursoList);

		
		List<CursoPropio> lista = new ArrayList<>();
		lista = gestor.listarCursosWhere(EstadoCurso.PROPUESTO);
		
		for (int i = 0; i<lista.size(); i++) {
			modelCurso.addElement(lista.get(i).getId());
		}

		cursoList.setModel(modelCurso);

		JLabel cursoLabel = new JLabel("Cursos");
		cursoLabel.setBounds(47, 50, 41, 14);
		contentPane.add(cursoLabel);

		estadoCombobox.setModel(new DefaultComboBoxModel<>(
				new EstadoCurso[] { EstadoCurso.PROPUESTO, EstadoCurso.VALIDADO, EstadoCurso.PROPUESTA_RECHAZADA }));
		estadoCombobox.setToolTipText("-Cursos-\r\n");
		estadoCombobox.setBounds(204, 192, 146, 22);
		contentPane.add(estadoCombobox);

		
		cursoAprobadoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cursoAprobadoList.setBounds(360, 69, 147, 202);
		contentPane.add(cursoAprobadoList);

		lista = gestor.listarCursosWhere(EstadoCurso.VALIDADO);
		
		for (int i =0; i<lista.size(); i++) {
			modelCursoAprobado.addElement(lista.get(i).getId());
		}

		cursoAprobadoList.setModel(modelCursoAprobado);


		aplicarButon.addActionListener(this);
		
		aplicarButon.setBounds(204, 248, 89, 23);
		contentPane.add(aplicarButon);

		JLabel cursoAprobadosLabel = new JLabel("Cursos Aprobados \"Validados\"");
		cursoAprobadosLabel.setBounds(360, 50, 187, 14);
		contentPane.add(cursoAprobadosLabel);

		
		darAltaButon.addActionListener(this);
		darAltaButon.setBounds(517, 248, 109, 23);
		contentPane.add(darAltaButon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == darAltaButon && !cursoAprobadoList.isSelectionEmpty()) {
			String selectedItem = cursoAprobadoList.getSelectedValue();
			CursoPropio curso = gestor.listarCurso(selectedItem);
			gestor.editarPropuestaCurso(curso.getId(), curso.getNombre(), curso.getECTS(),
					curso.getFechaInicio(), curso.getFechaFin(), curso.getTasaMatricula(), curso.getEdicion(),
					EstadoCurso.EN_MATRICULACION, curso.getTipo(), curso.getIdDirector(),
					curso.getIdSecretario(), curso.getIdCentro());
			modelCursoAprobado.removeElementAt(cursoAprobadoList.getSelectedIndex());
		}else if (e.getSource() == aplicarButon && !cursoList.isSelectionEmpty() && !estadoCombobox.getModel()
				.getElementAt(estadoCombobox.getSelectedIndex()).toString().equals("PROPUESTO")) {
			String selectedItem = cursoList.getSelectedValue();
			CursoPropio curso = gestor.listarCurso(selectedItem);
			gestor.editarPropuestaCurso(curso.getId(), curso.getNombre(), curso.getECTS(),
					curso.getFechaInicio(), curso.getFechaFin(), curso.getTasaMatricula(), curso.getEdicion(),
					EstadoCurso.valueOf(estadoCombobox.getModel()
							.getElementAt(estadoCombobox.getSelectedIndex()).toString()),
					curso.getTipo(), curso.getIdDirector(), curso.getIdSecretario(), curso.getIdCentro());
			if (estadoCombobox.getModel().getElementAt(estadoCombobox.getSelectedIndex()).toString().equals("VALIDADO")) {
				modelCursoAprobado.addElement(curso.getId());
			}
			modelCurso.removeElementAt(cursoList.getSelectedIndex());
		}
		
	}
	
}