package negocio.controllers;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import negocio.entities.*;

public class GestorMatriculacionTest {
	private GestorMatriculacion gestorMatriculacion = new GestorMatriculacion();

	public Matricula crearMatricula() {
		Matricula matriculaCreada = gestorMatriculacion.realizarMatriculacion(200, new Date(2020 / 12 / 10), false,
				ModoPago.TRANSFERENCIA, "76543210A", "CPR03");

		return matriculaCreada;
	}

	@Test
	public void testRealizarMatriculacion() {
		List<Matricula> listarMatriculasAntes = gestorMatriculacion.listarMatriculas();

		Matricula matriculaCreada = crearMatricula();

		Matricula matriculaEsperada = new Matricula(200, new Date(2020 / 12 / 10), false, ModoPago.TRANSFERENCIA,
				"76543210A", "CPR03");

		List<Matricula> listaMatriculaDespues = gestorMatriculacion.listarMatriculas();

		assertEquals(matriculaCreada, matriculaEsperada);
		assertEquals(listaMatriculaDespues.size(), (listarMatriculasAntes.size() + 1));
		assertFalse(listarMatriculasAntes.contains(matriculaCreada));
		assertNotNull(matriculaCreada);

		gestorMatriculacion.eliminarMatricula(matriculaCreada);
	}

	@Test
	public void testRealizarPagoMatricula() {
		Matricula matriculaCreada = crearMatricula();

		Matricula matriculaModificada = gestorMatriculacion.realizarPagoMatricula(200, new Date(2020 / 12 / 10), true, ModoPago.TRANSFERENCIA,
				"76543210A", "CPR03");
		
		assertTrue(matriculaModificada.isPagado());
		assertNotEquals(matriculaCreada, matriculaModificada);
		
		gestorMatriculacion.eliminarMatricula(matriculaCreada);
	}

	@Test
	public void testListarEstudiantes() {
		List<Estudiante> listaEstudiantes = gestorMatriculacion.listarEstudiantes();

		assertNotNull(listaEstudiantes);
	}

	@Test
	public void testListarMatriculas() {
		List<Matricula> listaMatriculas= gestorMatriculacion.listarMatriculas();
		
		assertNotNull(listaMatriculas);
	}

	@Test
	public void testListarEstudiante() {
		Estudiante estudiante = new Estudiante("76543210B", "Hugo", "Álvarez Ruiz", "Grado Superior", "Robótica");

		assertEquals(estudiante, gestorMatriculacion.listarEstudiante("76543210B"));
		
	}

}
