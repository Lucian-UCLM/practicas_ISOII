package negocio.controllers;

import java.util.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
		Centro centro_ = new Centro(centro, "", "");
		ProfesorUCLM director_ = new ProfesorUCLM(director, CategoriaProfesor.ASOCIADO, centro_);
		ProfesorUCLM secretario_ = new ProfesorUCLM(secretario, CategoriaProfesor.ASOCIADO, centro_);
		CursoPropio curso = new CursoPropio(id, nombre, ECTS, fechaInicio, fechaFinal, tasaMatricula, edicion, estado,
				tipo, centro_, director_, secretario_);
		cursodao.crearNuevoCurso(curso);
		return curso;
	}

	public void editarPropuestaCurso(CursoPropio curso) {
		throw new UnsupportedOperationException();
	}

	public EstadoCurso evaluarPropuesta(CursoPropio curso) {
		throw new UnsupportedOperationException();
	}

	public List<CursoPropio> listarCursos() {
		return cursodao.listarCursos();
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

}