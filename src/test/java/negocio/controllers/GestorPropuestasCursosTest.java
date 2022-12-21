package negocio.controllers;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import negocio.entities.CategoriaProfesor;
import negocio.entities.Centro;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.ProfesorUCLM;
import negocio.entities.TipoCurso;
import persistencia.CentroDAO;
import persistencia.ProfesorDAO;

import org.hibernate.loader.entity.CacheEntityLoaderHelper;
import org.junit.Test;

public class GestorPropuestasCursosTest {

	private GestorPropuestasCursos gestorPropuestasCursos = new GestorPropuestasCursos();

	public CursoPropio crearCurso1() {
		CursoPropio cursoCreado = gestorPropuestasCursos.realizarPropuestaCurso("CPR09", "CursoTesting", (-10),
				new Date(1 / 5 / 1978), new Date(20 / 12 / 1985), (-750.50), (-500), EstadoCurso.PROPUESTO,
				TipoCurso.ESPECIALISTA, "01234567D", "01234567A", -1);
		return cursoCreado;
	}

	public CursoPropio crearCurso2() {
		CursoPropio cursoCreado = gestorPropuestasCursos.realizarPropuestaCurso("CPR09", "CursoTesting", 6,
				new Date(11 / 3 / 2003), new Date(22 / 9 / 2057), 600.25, 11, EstadoCurso.PROPUESTO,
				TipoCurso.ESPECIALISTA, "01234567D", "01234567A", 7);
		return cursoCreado;
	}

	public CursoPropio crearCurso3() {
		CursoPropio cursoCreado = gestorPropuestasCursos.realizarPropuestaCurso("CPR09", "CursoTesting", 0,
				new Date(1 / 5 / 1978), new Date(20 / 12 / 1985), 0.0, 0, EstadoCurso.PROPUESTO, TipoCurso.ESPECIALISTA,
				"01234567D", "01234567A", 0);
		return cursoCreado;
	}

	@Test
	public void testRealizarPropuestaCurso() {

		List<CursoPropio> listaCursosAntes = gestorPropuestasCursos.listarCursos();

		////////////////////////////////////////////// CASO DE PRUEBA 1

		CursoPropio cursoCreado = crearCurso1();

		CursoPropio cursoEsperado = new CursoPropio("CPR09", "CursoTesting", -10, new Date(1 / 5 / 1978),
				new Date(20 / 12 / 1985), (-750.50), (-500), EstadoCurso.PROPUESTO, TipoCurso.ESPECIALISTA,
				new Centro(-1, "", ""),
				new ProfesorUCLM("01234567B", CategoriaProfesor.ASOCIADO, new Centro(-1, "", "")),
				new ProfesorUCLM("01234567A", CategoriaProfesor.ASOCIADO, new Centro(-1, "", "")));

		List<CursoPropio> listaCursosDespues = gestorPropuestasCursos.listarCursos();

		assertEquals(cursoCreado, cursoEsperado);
		assertEquals(listaCursosDespues.size(), (listaCursosAntes.size() + 1));
		assertFalse(listaCursosAntes.contains(cursoCreado));
		assertTrue(listaCursosDespues.contains(cursoEsperado));

		gestorPropuestasCursos.darBajaCurso(cursoCreado);

		assertNull(gestorPropuestasCursos.listarCurso(cursoCreado.getId()));

		////////////////////////////////////////////// CASO DE PRUEBA 2
		cursoCreado = crearCurso2();

		cursoEsperado = new CursoPropio("CPR09", "CursoTesting", 6, new Date(11 / 3 / 2003), new Date(22 / 9 / 2057),
				600.25, 11, EstadoCurso.PROPUESTO, TipoCurso.ESPECIALISTA, new Centro(7, "", ""),
				new ProfesorUCLM("01234567B", CategoriaProfesor.ASOCIADO, new Centro(7, "", "")),
				new ProfesorUCLM("01234567A", CategoriaProfesor.ASOCIADO, new Centro(7, "", "")));

		listaCursosDespues = gestorPropuestasCursos.listarCursos();

		assertEquals(cursoCreado, cursoEsperado);
		assertEquals(listaCursosDespues.size(), (listaCursosAntes.size() + 1));
		assertFalse(listaCursosAntes.contains(cursoCreado));
		assertTrue(listaCursosDespues.contains(cursoEsperado));

		gestorPropuestasCursos.darBajaCurso(cursoCreado);

		assertNull(gestorPropuestasCursos.listarCurso(cursoCreado.getId()));

		////////////////////////////////////////////// CASO DE PRUEBA 3

		cursoCreado = crearCurso3();

		cursoEsperado = new CursoPropio("CPR09", "CursoTesting", -10, new Date(1 / 5 / 1978), new Date(20 / 12 / 1985),
				0.0, 0, EstadoCurso.PROPUESTO, TipoCurso.ESPECIALISTA, new Centro(0, "", ""),
				new ProfesorUCLM("01234567B", CategoriaProfesor.ASOCIADO, new Centro(0, "", "")),
				new ProfesorUCLM("01234567A", CategoriaProfesor.ASOCIADO, new Centro(0, "", "")));

		listaCursosDespues = gestorPropuestasCursos.listarCursos();

		assertEquals(cursoCreado, cursoEsperado);
		assertEquals(listaCursosDespues.size(), (listaCursosAntes.size() + 1));
		assertFalse(listaCursosAntes.contains(cursoCreado));
		assertTrue(listaCursosDespues.contains(cursoEsperado));

		gestorPropuestasCursos.darBajaCurso(cursoCreado);

		assertNull(gestorPropuestasCursos.listarCurso(cursoCreado.getId()));

	}

	@Test
	public void testEditarPropuestaCurso() {

		///////////////////////////////////////////////////////////// CASO DE PRUEBA 1
		CursoPropio cursoCreado = crearCurso1();

		CursoPropio CursoNoModificado = cursoCreado;
		CursoPropio CursoSiModificado = gestorPropuestasCursos.editarPropuestaCurso("CPR09", "CursoTestingModificado",
				12, new Date(2020 / 12 / 10), new Date(2021 / 12 / 10), 150.0, 10, EstadoCurso.VALIDADO,
				TipoCurso.MASTER, "01234567B", "01234567D", 7);

		assertNotEquals(CursoNoModificado, CursoSiModificado);
		assertEquals(CursoNoModificado.getId(), CursoSiModificado.getId());
		assertNotEquals(CursoNoModificado.getNombre(), CursoSiModificado.getNombre());

		gestorPropuestasCursos.darBajaCurso(CursoSiModificado);

		///////////////////////////////////////////////////////////// CASO DE PRUEBA 2

		cursoCreado = crearCurso2();

		CursoNoModificado = cursoCreado;
		CursoSiModificado = gestorPropuestasCursos.editarPropuestaCurso("CPR09", "CursoTestingModificado", 6,
				new Date(2000 / 1 / 5), new Date(2011 / 2 / 11), 120.0, 5, EstadoCurso.PROPUESTA_RECHAZADA,
				TipoCurso.ESPECIALISTA, "01234567B", "01234567A", 0);

		assertNotEquals(CursoNoModificado, CursoSiModificado);
		assertEquals(CursoNoModificado.getId(), CursoSiModificado.getId());
		assertNotEquals(CursoNoModificado.getNombre(), CursoSiModificado.getNombre());

		gestorPropuestasCursos.darBajaCurso(CursoSiModificado);

		///////////////////////////////////////////////////////////// CASO DE PRUEBA 3

		cursoCreado = crearCurso3();

		CursoNoModificado = cursoCreado;
		CursoSiModificado = gestorPropuestasCursos.editarPropuestaCurso("CPR09", "CursoTestingModificado", 4,
				new Date(2010 / 9 / 10), new Date(1971 / 10 / 10), 200.0, 10, EstadoCurso.TERMINADO,
				TipoCurso.CURSOS_DE_VERANO, "01234567B", "01234567D", 7);

		assertNotEquals(CursoNoModificado, CursoSiModificado);
		assertEquals(CursoNoModificado.getId(), CursoSiModificado.getId());
		assertNotEquals(CursoNoModificado.getNombre(), CursoSiModificado.getNombre());

		gestorPropuestasCursos.darBajaCurso(CursoSiModificado);

	}

	@Test
	public void testListarCursosWhereEstadoCurso() {
		List<CursoPropio> listaCursosWhereEstadoMatriculacion = gestorPropuestasCursos
				.listarCursosWhere(EstadoCurso.EN_MATRICULACION);
		List<CursoPropio> listaCursosWhereEstadoPropuesto = gestorPropuestasCursos
				.listarCursosWhere(EstadoCurso.PROPUESTO);
		List<CursoPropio> listaCursosWhereEstadoValidado = gestorPropuestasCursos
				.listarCursosWhere(EstadoCurso.VALIDADO);

		for (int i = 0; i < listaCursosWhereEstadoMatriculacion.size(); i++) {
			assertEquals(listaCursosWhereEstadoMatriculacion.get(i).getEstado(), EstadoCurso.EN_MATRICULACION);
		}

		for (int i = 0; i < listaCursosWhereEstadoPropuesto.size(); i++) {
			assertEquals(listaCursosWhereEstadoPropuesto.get(i).getEstado(), EstadoCurso.PROPUESTO);
		}
		for (int i = 0; i < listaCursosWhereEstadoValidado.size(); i++) {
			assertEquals(listaCursosWhereEstadoValidado.get(i).getEstado(), EstadoCurso.VALIDADO);
		}

	}

	@Test
	public void testListarCursosWhereTipoCurso() {
		List<CursoPropio> listaCursosWhereTipoCursosVerano = gestorPropuestasCursos
				.listarCursosWhere(TipoCurso.CURSOS_DE_VERANO);
		List<CursoPropio> listaCursosWhereTipoEspecialista = gestorPropuestasCursos
				.listarCursosWhere(TipoCurso.ESPECIALISTA);
		List<CursoPropio> listaCursosWhereTipoExperto = gestorPropuestasCursos.listarCursosWhere(TipoCurso.EXPERTO);
		List<CursoPropio> listaCursosWhereTipoFormacionAvanzada = gestorPropuestasCursos
				.listarCursosWhere(TipoCurso.FORMACION_AVANZADA);
		List<CursoPropio> listaCursosWhereTipoMaster = gestorPropuestasCursos.listarCursosWhere(TipoCurso.MASTER);

		for (int i = 0; i < listaCursosWhereTipoCursosVerano.size(); i++) {
			assertEquals(listaCursosWhereTipoCursosVerano.get(i).getTipo(), TipoCurso.CURSOS_DE_VERANO);
		}
		for (int i = 0; i < listaCursosWhereTipoEspecialista.size(); i++) {
			assertEquals(listaCursosWhereTipoEspecialista.get(i).getTipo(), TipoCurso.ESPECIALISTA);
		}
		for (int i = 0; i < listaCursosWhereTipoExperto.size(); i++) {
			assertEquals(listaCursosWhereTipoExperto.get(i).getTipo(), TipoCurso.EXPERTO);
		}
		for (int i = 0; i < listaCursosWhereTipoFormacionAvanzada.size(); i++) {
			assertEquals(listaCursosWhereTipoFormacionAvanzada.get(i).getTipo(), TipoCurso.FORMACION_AVANZADA);
		}

		for (int i = 0; i < listaCursosWhereTipoMaster.size(); i++) {
			assertEquals(listaCursosWhereTipoMaster.get(i).getTipo(), TipoCurso.MASTER);
		}

	}

	@Test
	public void testListarCursos() {

		List<CursoPropio> listaCursos = gestorPropuestasCursos.listarCursos();

		///////////////////////////////////////////////////////////// CASO DE PRUEBA 1

		CursoPropio cursoCreado = crearCurso1();
		assertFalse(listaCursos.contains(cursoCreado));
		listaCursos = gestorPropuestasCursos.listarCursos();
		assertNotNull(listaCursos);
		assertTrue(listaCursos.contains(cursoCreado));

		gestorPropuestasCursos.darBajaCurso(cursoCreado);
		listaCursos.remove(cursoCreado);

		///////////////////////////////////////////////////////////// CASO DE PRUEBA 2

		cursoCreado = crearCurso2();
		assertFalse(listaCursos.contains(cursoCreado));
		listaCursos = gestorPropuestasCursos.listarCursos();
		assertNotNull(listaCursos);
		assertTrue(listaCursos.contains(cursoCreado));

		gestorPropuestasCursos.darBajaCurso(cursoCreado);
		listaCursos.remove(cursoCreado);

		///////////////////////////////////////////////////////////// CASO DE PRUEBA 3

		cursoCreado = crearCurso3();
		assertFalse(listaCursos.contains(cursoCreado));
		listaCursos = gestorPropuestasCursos.listarCursos();
		assertNotNull(listaCursos);
		assertTrue(listaCursos.contains(cursoCreado));

		gestorPropuestasCursos.darBajaCurso(cursoCreado);
		listaCursos.remove(cursoCreado);

	}

	@Test
	public void testListarCurso() {
		CursoPropio cursoCreado = crearCurso1();

		assertEquals(gestorPropuestasCursos.listarCurso(cursoCreado.getId()), cursoCreado);
		assertNotNull(gestorPropuestasCursos.listarCurso(cursoCreado.getId()));

		gestorPropuestasCursos.darBajaCurso(cursoCreado);
	}

	@Test
	public void testListarProfesoresUCLM() {

		List<ProfesorUCLM> listaProfesoresUclm = gestorPropuestasCursos.listarProfesoresUCLM();

		ProfesorDAO profesorDAO = new ProfesorDAO(ProfesorUCLM.class);

		///////////////////////////////////////////////////////////// CASO DE PRUEBA 1

		ProfesorUCLM profesorUCLMcreado = new ProfesorUCLM("01234567I", CategoriaProfesor.ASOCIADO,
				new Centro(7, "Facultad de Derecho", "Albacete"));

		profesorDAO.crearNuevoProfesor(profesorUCLMcreado);

		listaProfesoresUclm = gestorPropuestasCursos.listarProfesoresUCLM();
		assertNotNull(listaProfesoresUclm);
		assertTrue(listaProfesoresUclm.contains(profesorUCLMcreado));

		profesorDAO.eliminarProfesor(profesorUCLMcreado);
		listaProfesoresUclm.remove(profesorUCLMcreado);

		///////////////////////////////////////////////////////////// CASO DE PRUEBA 2

		profesorUCLMcreado = new ProfesorUCLM("01234567I", CategoriaProfesor.ASOCIADO,
				new Centro(-1, "Facultad de Testing", "DiscordWeb"));

		profesorDAO.crearNuevoProfesor(profesorUCLMcreado);

		listaProfesoresUclm = gestorPropuestasCursos.listarProfesoresUCLM();
		assertNotNull(listaProfesoresUclm);
		assertTrue(listaProfesoresUclm.contains(profesorUCLMcreado));

		profesorDAO.eliminarProfesor(profesorUCLMcreado);
		listaProfesoresUclm.remove(profesorUCLMcreado);

	}

	@Test
	public void testListarCentros() {

		List<Centro> listaCentros = gestorPropuestasCursos.listarCentros();
		CentroDAO centroDAO = new CentroDAO(Centro.class);

		///////////////////////////////////////////////////////////// CASO DE PRUEBA 1

		Centro centroCreado = new Centro(100, "Facultad de Testing 3.0", "DiscordWeb");

		centroDAO.crearNuevoCentro(centroCreado);

		assertFalse(listaCentros.contains(centroCreado));
		listaCentros = gestorPropuestasCursos.listarCentros();
		assertNotNull(listaCentros);
		assertTrue(listaCentros.contains(centroCreado));

		centroDAO.eliminarCentro(centroCreado);
		listaCentros.remove(centroCreado);

		///////////////////////////////////////////////////////////// CASO DE PRUEBA 2

		centroCreado = new Centro(-20, "Facultad de Testing 3.0", "DiscordWeb");
		centroDAO.crearNuevoCentro(centroCreado);

		assertFalse(listaCentros.contains(centroCreado));
		listaCentros = gestorPropuestasCursos.listarCentros();
		assertNotNull(listaCentros);
		assertTrue(listaCentros.contains(centroCreado));

		centroDAO.eliminarCentro(centroCreado);
		listaCentros.remove(centroCreado);

	}

	@Test
	public void testDarBajaCurso() {

		List<CursoPropio> listaCursosAntes = gestorPropuestasCursos.listarCursos();

		CursoPropio cursoAniadido = crearCurso1();
		gestorPropuestasCursos.darBajaCurso(cursoAniadido);

		List<CursoPropio> listaCursosDespues = gestorPropuestasCursos.listarCursos();

		assertEquals(listaCursosDespues.size(), listaCursosAntes.size());
		assertFalse(listaCursosDespues.contains(cursoAniadido) && listaCursosAntes.contains(cursoAniadido));
		assertFalse(listaCursosDespues.size() > listaCursosAntes.size());
	}
}
