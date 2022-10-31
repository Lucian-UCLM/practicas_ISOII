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
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class PantallaJefeGabineteVicerrectorado extends JFrame{
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaLogin frame = new PantallaLogin ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		}); 
	}
	public PantallaJefeGabineteVicerrectorado () {
		setTitle("Interfaz de jefe de gabinete");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccionar Campos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(29, 26, 125, 14);
		contentPane.add(lblNewLabel);
		
		JCheckBox chckbxNombre = new JCheckBox("Nombre");
		chckbxNombre.setBounds(31, 47, 86, 23);
		contentPane.add(chckbxNombre);
		
		JCheckBox chckbxCentro = new JCheckBox("Centro");
		chckbxCentro.setBounds(31, 73, 97, 23);
		contentPane.add(chckbxCentro);
		
		JCheckBox chckbxCrditos = new JCheckBox("Créditos");
		chckbxCrditos.setBounds(31, 99, 97, 23);
		contentPane.add(chckbxCrditos);
		
		JCheckBox chckbxImporte = new JCheckBox("Importe");
		chckbxImporte.setBounds(31, 125, 97, 23);
		contentPane.add(chckbxImporte);
		
		JCheckBox chckbxEdicin = new JCheckBox("Edición");
		chckbxEdicin.setBounds(31, 151, 97, 23);
		contentPane.add(chckbxEdicin);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Estado", "Propuesto", "Validado", "Rechazado", "En matriculación", "En impartición", "Terminado"}));
		comboBox.setBounds(21, 293, 116, 22);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(31, 206, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(31, 262, 86, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Inicio");
		lblNewLabel_1.setBounds(41, 181, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha Fin");
		lblNewLabel_1_1.setBounds(41, 237, 73, 14);
		contentPane.add(lblNewLabel_1_1);
		
		table = new JTable();
		table.setToolTipText("");
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nombre", "Centro", "Cr\u00E9ditos", "Importe", "Edici\u00F3n", "FechaInicio", "FechaFin", "Estado"},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(161, 51, 478, 112);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(31, 326, 89, 23);
		contentPane.add(btnNewButton);
	}
	public void realizarConsulta() {
		// TODO - implement PantallaJefeGabineteVicerrectorado.realizarConsulta
		throw new UnsupportedOperationException();
	}
}