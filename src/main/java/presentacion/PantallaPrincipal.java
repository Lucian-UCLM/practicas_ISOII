package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.WindowConstants;
import java.awt.Font;

public class PantallaPrincipal extends JFrame implements ActionListener {
	
	private JButton vicerectorado = new JButton("Vicerectorado");
	private JButton direccion = new JButton("Dirección");
	private JButton estudiante = new JButton("Estudiante");
	private JButton jefegabinete = new JButton("Jefe de Gabinete");
	
	public PantallaPrincipal () {
		inicializarElementos();
	}
	public void inicializarElementos() {
		setResizable(false);
		setTitle("Pantalla Principal");
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setBounds(100, 100, 580, 280);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.direccion.addActionListener(this);
		this.direccion.setBounds(116, 85, 136, 23);
		this.add(direccion);
		
		this.vicerectorado.addActionListener(this);
		this.vicerectorado.setBounds(116, 151, 136, 23);
		this.add(vicerectorado);
		
		this.estudiante.addActionListener(this);
		this.estudiante.setBounds(322, 85, 136, 23);
		this.add(estudiante);
		
		
		this.jefegabinete.addActionListener(this);
		this.jefegabinete.setBounds(322, 151, 136, 23);
		this.add(jefegabinete);
		
		JLabel lblNewLabel = new JLabel("Seleccione modo para acceder al sistema");
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 20));
		lblNewLabel.setBounds(91, 21, 396, 38);
		contentPane.add(lblNewLabel);
	}
	public void actionPerformed(ActionEvent e) {
		
        if(e.getSource() == direccion) {
        	PantallaDireccionCursos frame = new PantallaDireccionCursos ();
			frame.setVisible(true);
        }
        if (e.getSource() == vicerectorado) {
        	PantallaEmpleadosVicerrectorado frame = new PantallaEmpleadosVicerrectorado ();
			frame.setVisible(true);
        }
        if (e.getSource() == estudiante) {
        	PantallaMatriculacion frame = new PantallaMatriculacion ();
			frame.setVisible(true);
        }
        if (e.getSource() == jefegabinete) {
        	PantallaJefeGabineteVicerrectorado frame = new PantallaJefeGabineteVicerrectorado ();
			frame.setVisible(true);
        }
    }
}