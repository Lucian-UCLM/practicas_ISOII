package presentacion;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import Presentacion.IU_Administrador;
//import Presentacion.IU_InscribirSocio;

import javax.swing.JLabel;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;

public class PantallaPrincipal extends JFrame {
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		}); 
	}
	public PantallaPrincipal () {
		setResizable(false);
		setTitle("Pantalla Princiapl");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton direccion = new JButton("Dirección");
		direccion.setBounds(110, 145, 89, 23);
		contentPane.add(direccion);
		
		JButton vicerectorado = new JButton("Vicerectorado");
		vicerectorado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		vicerectorado.setBounds(110, 320, 114, 23);
		contentPane.add(vicerectorado);
		
		JButton estudiante = new JButton("Estudiante");
		estudiante.setBounds(454, 145, 89, 23);
		contentPane.add(estudiante);
		
		JButton jefegabinete = new JButton("Jefe de Gabinete");
		jefegabinete.setBounds(454, 320, 114, 23);
		contentPane.add(jefegabinete);
		
		JLabel lblNewLabel = new JLabel("Seleccione modo para acceder al sistema");
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 20));
		lblNewLabel.setBounds(147, 33, 396, 38);
		contentPane.add(lblNewLabel);
	}
	
}