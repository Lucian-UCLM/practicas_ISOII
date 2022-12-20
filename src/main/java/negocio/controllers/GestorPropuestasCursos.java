package negocio.controllers;

import java.util.*;

import negocio.entities.*;
import persistencia.CentroDAO;
import persistencia.CursoPropioDAO;
import persistencia.ProfesorDAO;

public class GestorPropuestasCursos {
	CursoPropioDAO cursodao = new CursoPropioDAO(CursoPropio.class);
	ProfesorDAO profesoruclmdao = new ProfesorDAO(ProfesorUCLM.class);
	CentroDAO centrodao = new CentroDAO(Centro.class);

	public CursoPropio realizarPropuestaCurso(String id, String nombre, int ECTS, Date fechaInicio, Date fechaFinal,
			double tasaMatricula, int edicion, EstadoCurso estado, TipoCurso tipo, String director, String secretario,
			int centro) {
		Centro centronew = new Centro(centro, "", "");
		ProfesorUCLM directornew = new ProfesorUCLM(director, CategoriaProfesor.ASOCIADO, centronew);
		ProfesorUCLM secretarionew = new ProfesorUCLM(secretario, CategoriaProfesor.ASOCIADO, centronew);
		CursoPropio curso = new CursoPropio(id, nombre, ECTS, fechaInicio, fechaFinal, tasaMatricula, edicion, estado,
				tipo, centronew, directornew, secretarionew);
		cursodao.crearNuevoCurso(curso);
		return curso;
	}

	public CursoPropio editarPropuestaCurso(String id, String nombre, int ECTS, Date fechaInicio, Date fechaFinal,
			double tasaMatricula, int edicion, EstadoCurso estado, TipoCurso tipo, String director, String secretario,
			int centro) {
		Centro centronew = new Centro(centro, "", "");
		ProfesorUCLM directornew = new ProfesorUCLM(director, CategoriaProfesor.ASOCIADO, centronew);
		ProfesorUCLM secretarionew = new ProfesorUCLM(secretario, CategoriaProfesor.ASOCIADO, centronew);
		CursoPropio curso = new CursoPropio(id, nombre, ECTS, fechaInicio, fechaFinal, tasaMatricula, edicion, estado,
				tipo, centronew, directornew, secretarionew);
		cursodao.editarCurso(curso);
		return curso;
	}

	public List<CursoPropio> listarCursosWhere(EstadoCurso estado) {
		return cursodao.listarCursosWhere(estado);
	}

	public List<CursoPropio> listarCursosWhere(TipoCurso tipo) {
		return cursodao.listarCursosWhere(tipo);
	}

	public EstadoCurso evaluarPropuesta(CursoPropio curso) {
		throw new UnsupportedOperationException();
	}

	public List<CursoPropio> listarCursos() {
		return cursodao.listarCursos();
	}

	public CursoPropio listarCurso(String idCurso) {
		CursoPropio curso = new CursoPropio();
		curso.setId(idCurso);
		return cursodao.listarCurso(curso);
	}

	public List<ProfesorUCLM> listarProfesoresUCLM() {
		return profesoruclmdao.listarProfesorUCLM();
	}

	public List<Centro> listarCentros() {
		return centrodao.listarCentros();
	}

	public void altaCursoAprobado(CursoPropio curso) {
		throw new UnsupportedOperationException();
	}
	public void darBajaCurso(CursoPropio curso) {
		cursodao.eliminarCurso(curso);
	}

}