package negocio.controllers;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import negocio.entities.*;
import persistencia.CentroDAO;
import persistencia.EstudianteDAO;

public class GestorMatriculacionTest {
	private GestorMatriculacion gestorMatriculacion = new GestorMatriculacion();

	public Matricula crearMatricula1() {
		Matricula matriculaCreada = gestorMatriculacion.realizarMatriculacion(-15, new Date(1 / 5 / 1978), false,
				ModoPago.TRANSFERENCIA, "76543210D", "CPR01");

		return matriculaCreada;
	}
	
	public Matricula crearMatricula2() {
		Matricula matriculaCreada = gestorMatriculacion.realizarMatriculacion(100, new Date(11 / 3 / 2003), true,
				ModoPago.TRANSFERENCIA, "76543210D", "CPR01");

		return matriculaCreada;
	}
	
	public Matricula crearMatricula3() {
		Matricula matriculaCreada = gestorMatriculacion.realizarMatriculacion(0, new Date(1 / 5 / 1978), true,
				ModoPago.TRANSFERENCIA, "76543210D", "CPR01");

		return matriculaCreada;
	}

	@Test
	public void testRealizarMatriculacion() {
		List<Matricula> listarMatriculasAntes = gestorMatriculacion.listarMatriculas();

		
		////////////////////////////////////////////// CASO DE PRUEBA 1

		Matricula matriculaCreada = crearMatricula1();

		Matricula matriculaEsperada = new Matricula(-15, new Date(1 / 5 / 1978), false, ModoPago.TRANSFERENCIA,
				"76543210D", "CPR01");

		List<Matricula> listaMatriculaDespues = gestorMatriculacion.listarMatriculas();

		assertEquals(matriculaCreada, matriculaEsperada);
		assertEquals(listaMatriculaDespues.size(), (listarMatriculasAntes.size() + 1));
		assertFalse(listarMatriculasAntes.contains(matriculaCreada));
		assertNotNull(matriculaCreada);

		gestorMatriculacion.eliminarMatricula(matriculaCreada);
		
		////////////////////////////////////////////// CASO DE PRUEBA 2
		
		matriculaCreada = crearMatricula2();

		matriculaEsperada = new Matricula(100, new Date(11 / 3 / 2003), true,
				ModoPago.TRANSFERENCIA, "76543210D", "CPR01");

		listaMatriculaDespues = gestorMatriculacion.listarMatriculas();

		assertEquals(matriculaCreada, matriculaEsperada);
		assertEquals(listaMatriculaDespues.size(), (listarMatriculasAntes.size() + 1));
		assertFalse(listarMatriculasAntes.contains(matriculaCreada));
		assertNotNull(matriculaCreada);

		gestorMatriculacion.eliminarMatricula(matriculaCreada);

		
		////////////////////////////////////////////// CASO DE PRUEBA 3
		
		matriculaCreada = crearMatricula3();

		matriculaEsperada = new Matricula(0, new Date(1 / 5 / 1978), true,
				ModoPago.TRANSFERENCIA, "76543210D", "CPR01");

		listaMatriculaDespues = gestorMatriculacion.listarMatriculas();

		assertEquals(matriculaCreada, matriculaEsperada);
		assertEquals(listaMatriculaDespues.size(), (listarMatriculasAntes.size() + 1));
		assertFalse(listarMatriculasAntes.contains(matriculaCreada));
		assertNotNull(matriculaCreada);

		gestorMatriculacion.eliminarMatricula(matriculaCreada);

	}

	@Test
	public void testRealizarPagoMatricula() {
		
		////////////////////////////////////////////// CASO DE PRUEBA 1

		Matricula matriculaCreada = crearMatricula1();

		Matricula matriculaModificada = gestorMatriculacion.realizarPagoMatricula(-15, new Date(1 / 5 / 1978), true, ModoPago.TARJETA_CREDITO,
				"76543210D", "CPR03");
		
		assertTrue(matriculaModificada.isPagado());
		assertNotEquals(matriculaCreada, matriculaModificada);
		
		gestorMatriculacion.eliminarMatricula(matriculaCreada);
		
		////////////////////////////////////////////// CASO DE PRUEBA 2
		matriculaCreada = crearMatricula2();
		matriculaModificada = gestorMatriculacion.realizarPagoMatricula(100, new Date(17 / 3 / 2033), true,
				ModoPago.TARJETA_CREDITO, "76543210D", "CPR06");
		
		assertTrue(matriculaModificada.isPagado());
		assertNotEquals(matriculaCreada, matriculaModificada);
		
		gestorMatriculacion.eliminarMatricula(matriculaCreada);
		
		////////////////////////////////////////////// CASO DE PRUEBA 3
		
		matriculaCreada = crearMatricula3();
		matriculaModificada = gestorMatriculacion.realizarPagoMatricula(1, new Date(1 / 10 / 1999), true,
				ModoPago.TARJETA_CREDITO, "76543210D", "CPR02");
		
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
		
		///////////////////////////////////////////////////////////// CASO DE PRUEBA 1

		Matricula matriculaCreada = crearMatricula1();
		assertFalse(listaMatriculas.contains(matriculaCreada));
		listaMatriculas = gestorMatriculacion.listarMatriculas();
		assertNotNull(listaMatriculas);
		assertTrue(listaMatriculas.contains(matriculaCreada));

		gestorMatriculacion.eliminarMatricula(matriculaCreada);
		listaMatriculas.remove(matriculaCreada);

		///////////////////////////////////////////////////////////// CASO DE PRUEBA 2

		matriculaCreada = crearMatricula2();
		assertFalse(listaMatriculas.contains(matriculaCreada));
		listaMatriculas = gestorMatriculacion.listarMatriculas();
		assertNotNull(listaMatriculas);
		assertTrue(listaMatriculas.contains(matriculaCreada));

		gestorMatriculacion.eliminarMatricula(matriculaCreada);
		listaMatriculas.remove(matriculaCreada);

		///////////////////////////////////////////////////////////// CASO DE PRUEBA 3

		matriculaCreada = crearMatricula3();
		assertFalse(listaMatriculas.contains(matriculaCreada));
		listaMatriculas = gestorMatriculacion.listarMatriculas();
		assertNotNull(listaMatriculas);
		assertTrue(listaMatriculas.contains(matriculaCreada));

		gestorMatriculacion.eliminarMatricula(matriculaCreada);
		listaMatriculas.remove(matriculaCreada);
		
		assertNotNull(listaMatriculas);
	}

	@Test
	public void testListarEstudiante() {
		
		List<Estudiante> listaEstudiantes = gestorMatriculacion.listarEstudiantes();
		EstudianteDAO estudianteDAO = new EstudianteDAO(Estudiante.class);

		///////////////////////////////////////////////////////////// CASO DE PRUEBA 1

		Estudiante estudianteCreado = new Estudiante ("76543210T", "Alejandro", "Franco Obama","Bachillerato", "Ciencias");

		estudianteDAO.crearNuevoEstudiante(estudianteCreado);

		assertFalse(listaEstudiantes.contains(estudianteCreado));
		listaEstudiantes = gestorMatriculacion.listarEstudiantes();
		assertNotNull(listaEstudiantes);
		assertTrue(listaEstudiantes.contains(estudianteCreado));

		estudianteDAO.eliminarEstudiante(estudianteCreado);
		listaEstudiantes.remove(estudianteCreado);
	}

}
