package negocio.controllers;

import java.util.Date;
import java.util.List;

import negocio.entities.*;
import persistencia.EstudianteDAO;
import persistencia.MatriculaDAO;

public class GestorMatriculacion {
	EstudianteDAO estudiantedao = new EstudianteDAO(Estudiante.class);
	MatriculaDAO matriculadao = new MatriculaDAO(Matricula.class);
	public Matricula realizarMatriculacion(int idMatricula, Date fecha, boolean pagado, ModoPago tipoPago, String estudiante, String titulo) {
		Matricula matricula = new Matricula(idMatricula, fecha, pagado, tipoPago, estudiante, titulo);
		matriculadao.crearNuevaMatricula(matricula);
		return matricula;
	}

	public Matricula realizarPagoMatricula(int idMatricula, Date fecha, boolean pagado, ModoPago tipoPago, String estudiante, String titulo) {
		Matricula matricula = new Matricula(idMatricula, fecha, pagado, tipoPago, estudiante, titulo);
		matriculadao.editarMatricula(matricula);
		return matricula;
	}
	
	public List<Estudiante> listarEstudiantes() {
		return estudiantedao.listarEstudiantes();
	}
	
	public List<Matricula> listarMatriculas() {
		return matriculadao.listarMatriculas();
	}
	
	public void eliminarMatricula(Matricula matricula) {
		matriculadao.eliminarMatricula(matricula);
	}
	public Estudiante listarEstudiante(String idEstudiante) {
		Estudiante estudiante = new Estudiante();
		estudiante.setDni(idEstudiante);
		return estudiantedao.listarEstudiante(estudiante);
	}
}