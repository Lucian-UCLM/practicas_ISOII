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

import javax.swing.border.LineBorder;
import javax.swing.plaf.synth.ColorType;

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
	private DefaultListModel model_curso = new DefaultListModel();
	GestorPropuestasCursos gestor = new GestorPropuestasCursos();

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
		inicializarComponentes();
		setTitle("Interfaz de jefe de gabinete");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 180, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Seleccione Campos");
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
		
		botonConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						int numColumnas = 0;
						int numFilas = 0;
						List<CursoPropio> listacurso = new ArrayList<>();
						listacurso = gestor.listarCursos();
						String aux[] = new String[8];
						
						for (int j = 0; j < listacurso.size(); j++) {
							model_curso.addElement(listacurso.get(numColumnas).getId());
							numFilas++;
							
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
						if (!campoFechaInicio.getText().equals("")) {
							aux[numColumnas] = campoFechaInicio.getText();
							numColumnas++;
							
						}
						if (!campoFechaFin.getText().equals("")) {
							aux[numColumnas] = campoFechaFin.getText();
							numColumnas++;
							
						}
						if (!comboBox.getSelectedItem().toString().equals("Estado")) {
							aux[numColumnas] = comboBox.getSelectedItem().toString();
							numColumnas++;
							
						}
						Object matriz[][] = new Object[numFilas][numColumnas];

						String campos[] = new String[numColumnas];
						System.out.println(numColumnas);
						if (numColumnas == 0) {
							lblNewLabel.setText("SELECCIONE CAMPOS");
						} else {

							for (int k = 0; k < campos.length; k++) {
								campos[k] = aux[k];
								System.out.println(campos[k]);
							}

							for (int i = 0; i < listacurso.size(); i++) {
								matriz[i][0] = listacurso.get(i).getNombre();
								System.out.println(matriz[i][0]);
							}

							for (int j = 0; j < campos.length; j++) {

								if (campos[j].equals("Centro")) {
									for (int i = 0; i < listacurso.size(); i++) {
										matriz[i][j] = listacurso.get(i).getIdCentro();
										System.out.println(matriz[i][j]);
									}
								}if (campos[j].equals("Créditos")) {
									for (int i = 0; i < listacurso.size(); i++) {
										matriz[i][j] = listacurso.get(i).getECTS();
										System.out.println(matriz[i][j]);
									}
								}if (campos[j].equals("Importe")) {
									for (int i = 0; i < listacurso.size(); i++) {
										matriz[i][j] = listacurso.get(i).getTasaMatricula();
										System.out.println(matriz[i][j]);
									}
								}if (campos[j].equals("Edición")) {
									for (int i = 0; i < listacurso.size(); i++) {
										matriz[i][j] = listacurso.get(i).getEdicion();
										System.out.println(matriz[i][j]);
									}
								}if (campos[j].equals("Estado")) {
									for (int i = 0; i < listacurso.size(); i++) {
										matriz[i][j] = listacurso.get(i).getEstado();
										System.out.println(matriz[i][j]);
									}
								}if (campos[j].equals("Validado")) {

								}if (campos[j].equals("")) {

								}if (campos[j].equals("")) {

								}if (campos[j].equals("")) {

								}if (campos[j].equals("")) {

								}
							}

							rellenarMatriz(matriz);
							realizarConsulta(matriz, campos);
							setBounds(100, 100, 900, 400);
							table.removeEditor();
						}

					}
				});
			}
		});

	}

	public void realizarConsulta(Object[][] matrizInfo, String campos[]) {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(159, 47, 700, 277);
		contentPane.add(scrollPane);

		table = new JTable(matrizInfo, campos);

		table.setToolTipText("");
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
	}

	private void inicializarComponentes() {

	}
	public Object[][] rellenarMatriz(Object[][] matriz) {

		for (int columnas = 0; columnas < matriz.length; columnas++) {
			for (int filas = 0; filas < matriz[columnas].length; filas++) {

				System.out.println("c" + matriz[columnas][filas]);

			}
		}

		return matriz;
	}
}