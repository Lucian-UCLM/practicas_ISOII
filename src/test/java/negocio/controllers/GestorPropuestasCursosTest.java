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
	public void testRealizarPropuestaCurso() {
		List<CursoPropio> listaCursosAntes = gestorPropuestasCursos.listarCursos();

		CursoPropio cursoCreado = crearCurso();

		CursoPropio cursoEsperado = new CursoPropio("1000", "CursoTest", 12, new Date(2020 / 12 / 10),
				new Date(2021 / 12 / 10), 120.0, 10, EstadoCurso.VALIDADO, TipoCurso.MASTER, new Centro(7, "", ""),
				new ProfesorUCLM("01234567B", CategoriaProfesor.ASOCIADO, new Centro(7, "", "")),
				new ProfesorUCLM("01234567D", CategoriaProfesor.ASOCIADO, new Centro(7, "", "")));

		List<CursoPropio> listaCursosDespues = gestorPropuestasCursos.listarCursos();

		assertEquals(cursoCreado, cursoEsperado);
		assertEquals(listaCursosDespues.size(), (listaCursosAntes.size() + 1));
		assertFalse(listaCursosAntes.contains(cursoCreado));
		assertTrue(listaCursosDespues.contains(cursoEsperado));

		gestorPropuestasCursos.darBajaCurso(cursoCreado);

		assertNull(gestorPropuestasCursos.listarCurso(cursoCreado.getId()));

	}

	@Test
	public void testEditarPropuestaCurso() {
		CursoPropio cursoCreado = crearCurso();

		CursoPropio CursoNoModificado = cursoCreado;
		CursoPropio CursoSiModificado = gestorPropuestasCursos.editarPropuestaCurso("1000", "CursoTestModificado", 12,
				new Date(2020 / 12 / 10), new Date(2021 / 12 / 10), 120.0, 10, EstadoCurso.VALIDADO, TipoCurso.MASTER,
				"01234567B", "01234567D", 7);

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

		assertNotNull(listaCursos);
	}

	@Test
	public void testListarCurso() {
		CursoPropio cursoCreado = crearCurso();

		assertEquals(gestorPropuestasCursos.listarCurso(cursoCreado.getId()), cursoCreado);
		assertNotNull(gestorPropuestasCursos.listarCurso(cursoCreado.getId()));

		gestorPropuestasCursos.darBajaCurso(cursoCreado);
	}

	@Test
	public void testListarProfesoresUCLM() {

		List<ProfesorUCLM> listaProfesoresUclm = gestorPropuestasCursos.listarProfesoresUCLM();

		for (int i = 0; i < listaProfesoresUclm.size(); i++) {
			assertNotNull(listaProfesoresUclm.get(i).getCategoria());
		}

	}

	@Test
	public void testListarCentros() {

		List<Centro> listaCentros = gestorPropuestasCursos.listarCentros();

		assertNotNull(listaCentros);

	}

	@Test
	public void testDarBajaCurso() {

		List<CursoPropio> listaCursosAntes = gestorPropuestasCursos.listarCursos();

		CursoPropio cursoAniadido = crearCurso();
		gestorPropuestasCursos.darBajaCurso(cursoAniadido);

		List<CursoPropio> listaCursosDespues = gestorPropuestasCursos.listarCursos();

		assertEquals(listaCursosDespues.size(), listaCursosAntes.size());
		assertFalse(listaCursosDespues.contains(cursoAniadido) && listaCursosAntes.contains(cursoAniadido));
		assertFalse(listaCursosDespues.size() > listaCursosAntes.size());
	}
}
