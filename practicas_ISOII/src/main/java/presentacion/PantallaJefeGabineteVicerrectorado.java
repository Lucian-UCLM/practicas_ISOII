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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;

public class PantallaJefeGabineteVicerrectorado extends JFrame {
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	private JTextField campoFechaInicio;
	private JTextField campoFechaFin;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaLogin frame = new PantallaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PantallaJefeGabineteVicerrectorado() {
		setTitle("Interfaz de jefe de gabinete");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Seleccionar Campos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(29, 26, 125, 14);
		contentPane.add(lblNewLabel);

		JCheckBox chckbxNombre = new JCheckBox("Nombre");
		chckbxNombre.setBounds(31, 47, 97, 23);
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Estado", "Propuesto", "Validado", "Rechazado",
				"En matriculación", "En impartición", "Terminado" }));
		comboBox.setBounds(21, 293, 116, 22);
		contentPane.add(comboBox);

		campoFechaInicio = new JTextField();
		campoFechaInicio.setBounds(31, 206, 86, 20);
		contentPane.add(campoFechaInicio);
		campoFechaInicio.setColumns(10);

		campoFechaFin = new JTextField();
		campoFechaFin.setColumns(10);
		campoFechaFin.setBounds(31, 262, 86, 20);
		contentPane.add(campoFechaFin);

		JLabel fechaInicio = new JLabel("Fecha Inicio");
		fechaInicio.setBounds(41, 181, 73, 14);
		contentPane.add(fechaInicio);

		JLabel fechaFin = new JLabel("Fecha Fin");
		fechaFin.setBounds(41, 237, 73, 14);
		contentPane.add(fechaFin);

		JButton botonConsulta = new JButton("Consultar");
		botonConsulta.setBounds(31, 326, 89, 23);
		contentPane.add(botonConsulta);
		
		JLabel lblNingunCampoSelected = new JLabel("");
		lblNingunCampoSelected.setBounds(304, 125, 329, 69);
		contentPane.add(lblNingunCampoSelected);
		botonConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						int i = 0;
						
						String aux[] = new String[8];

						if (chckbxNombre.isSelected()) {
							aux[i] = chckbxNombre.getText();
							i++;
							
						}
						if (chckbxCentro.isSelected()) {
							aux[i] = chckbxCentro.getText();
							i++;
							
						}
						if (chckbxCrditos.isSelected()) {
							aux[i] = chckbxCrditos.getText();
							i++;
						
						}
						if (chckbxImporte.isSelected()) {
							aux[i] = chckbxImporte.getText();
							i++;
							
						}
						if (chckbxEdicin.isSelected()) {
							aux[i] = chckbxEdicin.getText();
							i++;
							
						}
						if (!campoFechaInicio.getText().equals("")) {
							aux[i] = campoFechaInicio.getText();
							i++;
							
						}
						if (!campoFechaFin.getText().equals("")) {
							aux[i] = campoFechaFin.getText();
							i++;
							
						}
						if(!comboBox.getSelectedItem().toString().equals("Estado")) {
							aux[i] = comboBox.getSelectedItem().toString();
							i++;
						}
							

						String campos[] = new String[i];
						if(i==0) {
							lblNingunCampoSelected.setText("SELECCIONE ALMENOS UN CAMPO");
						}

						 
							for (int k = 0; k < campos.length; k++) {
								campos[k] = aux[k];
								//System.out.println(campos[k]);
							}
					
						
						realizarConsulta(campos);
					}
				});
			}
		});

	}

	public void realizarConsulta(/*Object[][] matrizInfo,*/ String campos[]) {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(159, 47, 515, 277);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(/*new object se remplazará por la matriz resultado de la consulta sql*/new Object[][] { { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, }, campos));
		table.setToolTipText("");
		scrollPane.setViewportView(table);
	}
}