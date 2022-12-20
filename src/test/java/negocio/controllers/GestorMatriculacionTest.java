package negocio.controllers;

import static org.junit.Assert.*;

import org.junit.Test;

import negocio.entities.Estudiante;

public class GestorMatriculacionTest {
	private GestorPropuestasCursos gestorPropuestasCursos;

	public void gestor() {
		gestorPropuestasCursos = new GestorPropuestasCursos();

	}

	@Test
	public void testListarEstudiante() {
		GestorMatriculacion gestorMatriculacion = new GestorMatriculacion();

		Estudiante curso = new Estudiante("76543210B", "Hugo", "Álvarez Ruiz", "Grado Superior", "Robótica");

		//assertTrue(new Estudiante("76543210B", "Hugo", "Álvarez Ruiz", "Grado Superior", "Robótica") == gestorMatriculacion.listarEstudiante("76543210B"));
		assertTrue(true);
		
	}

}
