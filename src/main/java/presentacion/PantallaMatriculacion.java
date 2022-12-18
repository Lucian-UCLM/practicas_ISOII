package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import negocio.controllers.GestorMatriculacion;
import negocio.controllers.GestorPropuestasCursos;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.Estudiante;
import negocio.entities.Matricula;

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
import java.util.List;
import java.awt.Color;

public class PantallaMatriculacion extends JFrame implements ActionListener{
	
	private DefaultListModel<String> modelCurso = new DefaultListModel<>();
	private DefaultListModel<String> modelEstudiantes = new DefaultListModel<>();
	
	JButton btnRealizarMatricula = new JButton("Realizar Matricula");
	
	private JList<String> listCursos = new JList<>();
	private JList<String> listEstudiantes = new JList<>();
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
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String font = "Tahoma";
		
		listCursos.setBounds(517, 74, 188, 278);
		contentPane.add(listCursos);
		
		JLabel lblUsuario = new JLabel("Estudiante:");
		lblUsuario.setBounds(33, 36, 67, 14);
		contentPane.add(lblUsuario);
		
		btnRealizarMatricula.addActionListener(this);
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
		lblFormaPago.setFont(new Font(font, Font.ITALIC, 11));
		lblFormaPago.setBounds(274, 282, 145, 14);
		contentPane.add(lblFormaPago);
		
		JLabel lblResumenMatricula = new JLabel("Resumen Matrícula");
		lblResumenMatricula.setFont(new Font(font, Font.BOLD, 11));
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
		lblEstudianteMatricula.setFont(new Font(font, Font.ITALIC, 11));
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
		
		listEstudiantes.setBounds(33, 89, 173, 297);
		contentPane.add(listEstudiantes);
		
		List<Estudiante> listasDeEstudiantesAux = gestor2.listarEstudiantes();
		for (int j =0; j<listasDeEstudiantesAux.size(); j++) {
			modelEstudiantes.addElement(listasDeEstudiantesAux.get(j).getDni());}
		listEstudiantes.setModel(modelEstudiantes);
		
		MouseListener mouseListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == listEstudiantes) {
					modelCurso.clear();
					listCursos.setModel(modelCurso);
					String selectedItem = listEstudiantes.getSelectedValue();
					Estudiante estudiante = gestor2.listarEstudiante(selectedItem);
					
					lblNombreReply.setText(estudiante.getNombre());
					lblApellidosReply.setText(estudiante.getApellidos());
					lblDNIReply.setText(estudiante.getDni());
					lblTitulacionReply.setText(estudiante.getTitulacion());
					lblCualificacionReply.setText(estudiante.getCualificacion());
					
					GestorPropuestasCursos gestor = new GestorPropuestasCursos();
					List<CursoPropio> listaCursosMatriculacion = gestor.listarCursosWhere(EstadoCurso.EN_MATRICULACION);
					List<Matricula> listaMatriculas = gestor2.listarMatriculasWhereEstudiante(estudiante);
					List<String> listaCursosEstaMatriculado = new ArrayList<String>();
					
					System.out.println(listaMatriculas.isEmpty());
					
					for (int i = 0; i<listaMatriculas.size(); i++) {
						listaCursosEstaMatriculado.add(listaMatriculas.get(i).getTitulo().getId());
					}
					
					System.out.println(listaCursosEstaMatriculado);
					
					for (int i = 0; i<listaCursosMatriculacion.size(); i++) {
						if (!listaCursosEstaMatriculado.contains(listaCursosMatriculacion.get(i))) {
							modelCurso.addElement(listaCursosMatriculacion.get(i).getId());
						}
					}
					listCursos.setModel(modelCurso);
				}else if (e.getSource() == listCursos) {
					
				}
			}
		};
		
		listEstudiantes.addMouseListener(mouseListener);
		listCursos.addMouseListener(mouseListener); 
	}
	@Override 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRealizarMatricula) {
			
		}
		
	}
}