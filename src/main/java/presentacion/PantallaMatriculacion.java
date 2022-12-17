package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import negocio.controllers.GestorMatriculacion;
import negocio.controllers.GestorPropuestasCursos;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.Estudiante;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.Color;

public class PantallaMatriculacion extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	private DefaultListModel model_curso = new DefaultListModel();
	private DefaultListModel model_estudiantes = new DefaultListModel();
	private JList listCursos = new JList();
	private JList list_estudiantes = new JList();
	private GestorMatriculacion gestor2 = new GestorMatriculacion();
	
	public PantallaMatriculacion () {
		inicializarElementos();
	}
	public void realizarMatriculacion() {
		// TODO - implement PantallaMatriculaci�n.realizarMatriculacion
		throw new UnsupportedOperationException();
	}
	public void inicializarElementos() {
		setTitle("Interfaz de Matriculacion");
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setBounds(100, 100, 759, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		listCursos.setBounds(517, 74, 188, 278);
		contentPane.add(listCursos);
		
		list_estudiantes.setBounds(33, 89, 173, 297);
		contentPane.add(list_estudiantes);
		
		List<Estudiante> lista2 = new ArrayList<>();
		lista2 = gestor2.listarEstudiantes();
		int j = 0;
		for (Iterator iterator = lista2.iterator(); iterator.hasNext();) {
			model_estudiantes.addElement(lista2.get(j).getDni());
			iterator.next();
			j++;
		}
		
		list_estudiantes.setModel(model_estudiantes);
		
		JLabel lblUsuario = new JLabel("Estudiante:");
		lblUsuario.setBounds(33, 36, 67, 14);
		contentPane.add(lblUsuario);
		
		JButton btnRealizarMatricula = new JButton("Realizar Matricula");
		btnRealizarMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRealizarMatricula.setBounds(221, 363, 124, 23);
		contentPane.add(btnRealizarMatricula);
		
		JLabel lblUsuarioReply = new JLabel("Usuario Login");
		lblUsuarioReply.setBounds(95, 36, 81, 14);
		contentPane.add(lblUsuarioReply);
		
		
		JLabel lblListaCursos = new JLabel("ListaCursos");
		lblListaCursos.setBounds(517, 49, 81, 14);
		contentPane.add(lblListaCursos);
		
		JCheckBox chckbxPagoTransferencia = new JCheckBox("Pago con Transferencia");
		chckbxPagoTransferencia.setBounds(274, 329, 145, 23);
		contentPane.add(chckbxPagoTransferencia);
		
		JCheckBox chckbxPagoConTarjeta = new JCheckBox("Pago con Tarjeta");
		chckbxPagoConTarjeta.setBounds(274, 303, 145, 23);
		contentPane.add(chckbxPagoConTarjeta);
		
		JButton btnRealizarPago = new JButton("Realizar Pago");
		btnRealizarPago.setBounds(355, 363, 124, 23);
		contentPane.add(btnRealizarPago);
		
		JLabel lblFormaPago = new JLabel("Seleccionar forma de pago");
		lblFormaPago.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblFormaPago.setBounds(274, 282, 145, 14);
		contentPane.add(lblFormaPago);
		
		JLabel lblResumenMatricula = new JLabel("Resumen Matrícula");
		lblResumenMatricula.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResumenMatricula.setBounds(274, 36, 124, 14);
		contentPane.add(lblResumenMatricula);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(274, 90, 67, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(274, 115, 46, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(274, 140, 46, 14);
		contentPane.add(lblDNI);
		
		JLabel lblTitulacion = new JLabel("Titulación:");
		lblTitulacion.setBounds(274, 165, 67, 14);
		contentPane.add(lblTitulacion);
		
		JLabel lblCualificacion = new JLabel("Cualificación:");
		lblCualificacion.setBounds(274, 190, 101, 14);
		contentPane.add(lblCualificacion);
		
		JLabel lblEstudianteMatricula = new JLabel("Estudiante");
		lblEstudianteMatricula.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblEstudianteMatricula.setBounds(274, 64, 67, 14);
		contentPane.add(lblEstudianteMatricula);
		
		JLabel lblNombreReply = new JLabel("");
		lblNombreReply.setBounds(386, 90, 145, 14);
		contentPane.add(lblNombreReply);
		
		JLabel lblApellidosReply = new JLabel("");
		lblApellidosReply.setBounds(386, 115, 145, 14);
		contentPane.add(lblApellidosReply);
		
		JLabel lblDNIReply = new JLabel("");
		lblDNIReply.setBounds(386, 140, 145, 14);
		contentPane.add(lblDNIReply);
		
		JLabel lblTitulacionReply = new JLabel("");
		lblTitulacionReply.setBounds(386, 165, 145, 14);
		contentPane.add(lblTitulacionReply);
		
		JLabel lblCualificacionReply = new JLabel("");
		lblCualificacionReply.setBounds(386, 190, 145, 14);
		contentPane.add(lblCualificacionReply);
		
		JLabel lbListaEstudiantes = new JLabel("ListaEstudiantes");
		lbListaEstudiantes.setBounds(33, 64, 81, 14);
		contentPane.add(lbListaEstudiantes);
		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == list_estudiantes) {
					model_curso.clear();
					listCursos.setModel(model_curso);
					String selectedItem = (String) list_estudiantes.getSelectedValue();
					Estudiante estudiante = gestor2.listarEstudiante(selectedItem);
					lblNombreReply.setText(estudiante.getNombre());
					lblApellidosReply.setText(estudiante.getApellidos());
					lblDNIReply.setText(estudiante.getDni());
					lblTitulacionReply.setText(estudiante.getTitulacion());
					lblCualificacionReply.setText(estudiante.getCualificacion());
					GestorPropuestasCursos gestor = new GestorPropuestasCursos();
					List<CursoPropio> lista = new ArrayList<>();
					lista = gestor.listarCursosWhere(EstadoCurso.EN_MATRICULACION);
					int i = 0;
					for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
						model_curso.addElement(lista.get(i).getId());
						iterator.next();
						i++;
					}

					listCursos.setModel(model_curso);
				}else if (e.getSource() == listCursos) {
					
				}
			}
		};
		list_estudiantes.addMouseListener(mouseListener);
		listCursos.addMouseListener(mouseListener);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}