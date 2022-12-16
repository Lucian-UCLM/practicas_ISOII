package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class PantallaMatriculacion extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	private JList listCursos = new JList();
	
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
		setBounds(100, 100, 594, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		listCursos.setBounds(33, 89, 183, 263);
		contentPane.add(listCursos);
		
		JLabel lblUsuario = new JLabel("Estudiante:");
		lblUsuario.setBounds(33, 36, 67, 14);
		contentPane.add(lblUsuario);
		
		JButton btnRealizarMatricula = new JButton("Realizar Matricula");
		btnRealizarMatricula.setBounds(62, 363, 124, 23);
		contentPane.add(btnRealizarMatricula);
		
		JLabel lblUsuarioReply = new JLabel("Usuario Login");
		lblUsuarioReply.setBounds(95, 36, 81, 14);
		contentPane.add(lblUsuarioReply);
		
		JLabel lblListaCursos = new JLabel("ListaCursos");
		lblListaCursos.setBounds(33, 64, 81, 14);
		contentPane.add(lblListaCursos);
		
		JCheckBox chckbxPagoTransferencia = new JCheckBox("Pago con Transferencia");
		chckbxPagoTransferencia.setBounds(274, 329, 145, 23);
		contentPane.add(chckbxPagoTransferencia);
		
		JCheckBox chckbxPagoConTarjeta = new JCheckBox("Pago con Tarjeta");
		chckbxPagoConTarjeta.setBounds(274, 303, 145, 23);
		contentPane.add(chckbxPagoConTarjeta);
		
		JButton btnRealizarPago = new JButton("Realizar Pago");
		btnRealizarPago.setBounds(274, 363, 124, 23);
		contentPane.add(btnRealizarPago);
		
		JLabel lblFormaPago = new JLabel("Seleccionar forma de pago");
		lblFormaPago.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblFormaPago.setBounds(274, 282, 145, 14);
		contentPane.add(lblFormaPago);
		
		JLabel lblResumenMatricula = new JLabel("Resumen Matrícula");
		lblResumenMatricula.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResumenMatricula.setBounds(274, 36, 124, 14);
		contentPane.add(lblResumenMatricula);
		
		JLabel lblCursoTituloResumen = new JLabel("Curso");
		lblCursoTituloResumen.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCursoTituloResumen.setBounds(274, 215, 46, 14);
		contentPane.add(lblCursoTituloResumen);
		
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
		
		JLabel lblCursoMatriculado = new JLabel("Curso Matriculado:");
		lblCursoMatriculado.setBounds(274, 240, 124, 14);
		contentPane.add(lblCursoMatriculado);
		
		JLabel lblNombreReply = new JLabel("Lucian");
		lblNombreReply.setBounds(386, 90, 145, 14);
		contentPane.add(lblNombreReply);
		
		JLabel lblApellidosReply = new JLabel("Gómez Palmeiro");
		lblApellidosReply.setBounds(386, 115, 145, 14);
		contentPane.add(lblApellidosReply);
		
		JLabel lblDNIReply = new JLabel("04867390H");
		lblDNIReply.setBounds(386, 140, 145, 14);
		contentPane.add(lblDNIReply);
		
		JLabel lblTitulacionReply = new JLabel("Ingeniero Informático");
		lblTitulacionReply.setBounds(386, 165, 145, 14);
		contentPane.add(lblTitulacionReply);
		
		JLabel lblCualificacionReply = new JLabel("7,6");
		lblCualificacionReply.setBounds(386, 190, 145, 14);
		contentPane.add(lblCualificacionReply);
		
		JLabel lblCursoMatriculadoReply = new JLabel("Programación Cuántica");
		lblCursoMatriculadoReply.setBounds(386, 240, 145, 14);
		contentPane.add(lblCursoMatriculadoReply);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}