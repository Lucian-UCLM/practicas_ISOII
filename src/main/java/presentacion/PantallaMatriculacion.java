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
import negocio.entities.Generated;
import negocio.entities.Matricula;
import negocio.entities.ModoPago;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Color;
@Generated
public class PantallaMatriculacion extends JFrame implements ActionListener{
	
	private DefaultListModel<String> modelCurso = new DefaultListModel<>();
	private DefaultListModel<String> modelEstudiantes = new DefaultListModel<>();
	
	private JList<String> listCursos = new JList<>();
	private JList<String> listEstudiantes = new JList<>();
	private GestorMatriculacion gestorMatriculas = new GestorMatriculacion();
	
	private JLabel lblFormaPago = new JLabel("Seleccionar forma de pago");
	
	private JButton btnRealizarPago = new JButton("Realizar Pago");
	private JButton btnRealizarMatricula = new JButton("Realizar Matricula");
	
	private JCheckBox chckbxPagoConTarjeta = new JCheckBox("Pago con Tarjeta");
	private JCheckBox chckbxPagoTransferencia = new JCheckBox("Pago con Transferencia");
	
	public PantallaMatriculacion () {
		inicializarElementos();
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
		
		chckbxPagoTransferencia.setBounds(274, 329, 145, 23);
		contentPane.add(chckbxPagoTransferencia);
		
		chckbxPagoConTarjeta.setBounds(274, 303, 145, 23);
		contentPane.add(chckbxPagoConTarjeta);
		
		btnRealizarPago.setBounds(355, 363, 124, 23);
		contentPane.add(btnRealizarPago);
		
		lblFormaPago.setFont(new Font(font, Font.ITALIC, 11));
		lblFormaPago.setBounds(274, 273, 173, 23);
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
		
		btnRealizarPago.setEnabled(false);
		btnRealizarMatricula.setEnabled(false);
		
		List<Estudiante> listasDeEstudiantesAux = gestorMatriculas.listarEstudiantes();
		for (int j =0; j<listasDeEstudiantesAux.size(); j++) {
			modelEstudiantes.addElement(listasDeEstudiantesAux.get(j).getDni());}
		listEstudiantes.setModel(modelEstudiantes);
		
		MouseListener mouseListener = new MouseAdapter() {
			@Override @Generated
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == listEstudiantes) {
					modelCurso.clear();
					listCursos.setModel(modelCurso);
					String selectedItem = listEstudiantes.getSelectedValue();
					Estudiante estudiante = gestorMatriculas.listarEstudiante(selectedItem);
					
					lblNombreReply.setText(estudiante.getNombre());
					lblApellidosReply.setText(estudiante.getApellidos());
					lblDNIReply.setText(estudiante.getDni());
					lblTitulacionReply.setText(estudiante.getTitulacion());
					lblCualificacionReply.setText(estudiante.getCualificacion());
					
					GestorPropuestasCursos gestorCursos = new GestorPropuestasCursos();
					List<CursoPropio> listaCursosMatriculacion = gestorCursos.listarCursosWhere(EstadoCurso.EN_MATRICULACION);
					List<Matricula> listaMatriculas = gestorMatriculas.listarMatriculas();
					List<String> listaCursosEstaMatriculado = new ArrayList<>();
					
					for (int i = 0; i<listaMatriculas.size(); i++) {
						if(listaMatriculas.get(i).getIdEstudiante().equals(estudiante.getDni()) && listaMatriculas.get(i).isPagado()) {
							listaCursosEstaMatriculado.add(listaMatriculas.get(i).getIdTitulo());
						}
					}
					
					for (int i = 0; i<listaCursosMatriculacion.size(); i++) {
						if (!listaCursosEstaMatriculado.contains(listaCursosMatriculacion.get(i).getId())) {
							modelCurso.addElement(listaCursosMatriculacion.get(i).getId());
						}
					}
					listCursos.setModel(modelCurso);
				}else if (e.getSource() == listCursos) {
					boolean existeMatricula = false;
					String selectedItemEstudiante = listEstudiantes.getSelectedValue();
					String selectedItemCurso = listCursos.getSelectedValue();
					List<Matricula> listaMatriculas = gestorMatriculas.listarMatriculas();
					
					for (int i = 0; i<listaMatriculas.size(); i++) {
						if(listaMatriculas.get(i).getIdEstudiante().equals(selectedItemEstudiante)&&listaMatriculas.get(i).getIdTitulo().equals(selectedItemCurso)) {
							existeMatricula=true;
						}
					}
					
					if(existeMatricula) {
						btnRealizarPago.setEnabled(true);
						btnRealizarMatricula.setEnabled(false);
					}else {
						btnRealizarPago.setEnabled(false);
						btnRealizarMatricula.setEnabled(true);
					}
				}
			}
		};
		
		btnRealizarMatricula.addActionListener(this);
		btnRealizarPago.addActionListener(this);
		
		listEstudiantes.addMouseListener(mouseListener);
		listCursos.addMouseListener(mouseListener); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRealizarMatricula) {
			String selectedItemEstudiante = listEstudiantes.getSelectedValue();
			String selectedItemCurso = listCursos.getSelectedValue();
			List<Matricula> listaMatriculas = gestorMatriculas.listarMatriculas();
			int idMatricula = listaMatriculas.get(listaMatriculas.size()-1).getIdMatricula() + 1;
			gestorMatriculas.realizarMatriculacion(idMatricula, new Date(), false, ModoPago.TARJETA_CREDITO, selectedItemEstudiante, selectedItemCurso);
			btnRealizarMatricula.setEnabled(false);
			btnRealizarPago.setEnabled(true);
			
		}else if (e.getSource() == btnRealizarPago) {
			String selectedItemEstudiante = listEstudiantes.getSelectedValue();
			String selectedItemCurso = listCursos.getSelectedValue();
			List<Matricula> listaMatriculas = gestorMatriculas.listarMatriculas();
			Matricula matricula = listaMatriculas.get(0);
			ModoPago modopago = null;
			if ((chckbxPagoConTarjeta.isSelected() && chckbxPagoTransferencia.isSelected()) || (!chckbxPagoConTarjeta.isSelected() && !chckbxPagoTransferencia.isSelected())) {
				lblFormaPago.setText("Seleccione solo una forma de pago");
				lblFormaPago.setForeground(Color.RED);
				return;
			} else if (chckbxPagoConTarjeta.isSelected()) {
				modopago = ModoPago.TARJETA_CREDITO;
			} else {
				modopago = ModoPago.TRANSFERENCIA;
			}
			for (int i = 0; i<listaMatriculas.size(); i++) {
				if(listaMatriculas.get(i).getIdEstudiante().equals(selectedItemEstudiante) && listaMatriculas.get(i).getIdTitulo().equals(selectedItemCurso)) {
					matricula = listaMatriculas.get(i);
					break;
				}
			}
			lblFormaPago.setForeground(Color.BLACK);
			lblFormaPago.setText("Seleccionar forma de pago");
			
			btnRealizarMatricula.setEnabled(false);
			btnRealizarPago.setEnabled(false);
			
			modelCurso.remove(listCursos.getSelectedIndex());
			listCursos.setModel(modelCurso);
			gestorMatriculas.realizarPagoMatricula(matricula.getIdMatricula(), matricula.getFecha(), true, modopago, matricula.getIdEstudiante(), matricula.getIdTitulo());
		}
		
	}	
}