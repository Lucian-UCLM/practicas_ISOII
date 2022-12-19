package negocio.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import negocio.controllers.GestorPropuestasCursos;
import negocio.entities.CategoriaProfesor;
import negocio.entities.Centro;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.ProfesorUCLM;
import negocio.entities.TipoCurso;
import persistencia.CursoPropioDAO;

import org.junit.Test;

public class GestorPropuestasCursosTest {

	private GestorPropuestasCursos gestorPropuestasCursos = new GestorPropuestasCursos();

	
	public CursoPropio crearCurso() {
		CursoPropio cursoCreado = gestorPropuestasCursos.realizarPropuestaCurso("1000", "CursoTest", 12,
				new Date(2020 / 12 / 10), new Date(2021 / 12 / 10), 120.0, 10, EstadoCurso.VALIDADO, TipoCurso.MASTER,
				"01234567B", "01234567D", 7);
		return cursoCreado;
	}
	@Test
	public void testCrearNuevoCurso() {

		List<CursoPropio> listaCursosAntes = gestorPropuestasCursos.listarCursos();

		CursoPropio cursoCreado = crearCurso();

		CursoPropio cursoEsperado = new CursoPropio("1000", "CursoTest", 12, new Date(2020 / 12 / 10),
				new Date(2021 / 12 / 10), 120.0, 10, EstadoCurso.VALIDADO, TipoCurso.MASTER, new Centro(7, "", ""),
				new ProfesorUCLM("01234567B", CategoriaProfesor.ASOCIADO, new Centro(7, "", "")),
				new ProfesorUCLM("01234567D", CategoriaProfesor.ASOCIADO, new Centro(7, "", "")));

		List<CursoPropio> listaCursosDespues = gestorPropuestasCursos.listarCursos();

		assertEquals(cursoCreado, cursoEsperado);
		assertTrue(listaCursosDespues.size() == (listaCursosAntes.size() + 1));
		assertFalse(listaCursosAntes.contains(cursoCreado));
		assertTrue(listaCursosDespues.contains(cursoEsperado));

		gestorPropuestasCursos.darBajaCurso(cursoCreado);

		assertTrue(gestorPropuestasCursos.listarCurso(cursoCreado.getId()) == null);

	}

	@Test
	public void testDarBajaCurso() {

		List<CursoPropio> listaCursosAntes = gestorPropuestasCursos.listarCursos();

		CursoPropio cursoAniadido = crearCurso();
		gestorPropuestasCursos.darBajaCurso(cursoAniadido);

		List<CursoPropio> listaCursosDespues = gestorPropuestasCursos.listarCursos();

		assertTrue(listaCursosDespues.size() == listaCursosAntes.size());
		assertFalse(listaCursosDespues.contains(cursoAniadido) && listaCursosAntes.contains(cursoAniadido));
		assertFalse(listaCursosDespues.size() > listaCursosAntes.size());
	}

	@Test
	public void testEditarPropuestaCurso() {
		
		CursoPropio cursoCreado = crearCurso();
		
		CursoPropio CursoNoModificado = cursoCreado;
		CursoPropio CursoSiModificado = gestorPropuestasCursos.editarPropuestaCurso("1000", "CursoTestModificado", 12,new Date(2020 / 12 / 10), new Date(2021 / 12 / 10), 120.0, 10, EstadoCurso.VALIDADO, TipoCurso.MASTER,
				"01234567B", "01234567D", 7);
		
		assertNotEquals(CursoNoModificado, CursoSiModificado);
		assertEquals(CursoNoModificado.getId(), CursoSiModificado.getId());
		assertNotEquals(CursoNoModificado.getNombre(), CursoSiModificado.getNombre());
		
		gestorPropuestasCursos.darBajaCurso(CursoSiModificado);
	}

}
