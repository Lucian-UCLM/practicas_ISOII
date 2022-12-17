package negocio.controllers;

import java.util.List;

import negocio.entities.*;
import persistencia.EstudianteDAO;

public class GestorMatriculacion {
	EstudianteDAO estudiantedao = new EstudianteDAO(Estudiante.class);
	public void realizarMatriculacion(CursoPropio curso, Estudiante estudiante) {
		throw new UnsupportedOperationException();
	}

	public void realizarPagoMatricula(CursoPropio curso, Estudiante estudiante) {
		throw new UnsupportedOperationException();
	}

	private void realizarPagoTarjeta(CursoPropio curso, Estudiante estudiante) {
		throw new UnsupportedOperationException();
	}

	private void realizarPagoTransferencia(CursoPropio curso, Estudiante estudiante) {
		throw new UnsupportedOperationException();
	}

	private void operation() {
		throw new UnsupportedOperationException();
	}
	
	public List<Estudiante> listarEstudiantes() {
		return estudiantedao.listarEstudiantes();
	}
	
	public Estudiante listarEstudiante(String idEstudiante) {
		Estudiante estudiante = new Estudiante();
		estudiante.setDni(idEstudiante);
		return estudiantedao.listarEstudiante(estudiante);
	}
}