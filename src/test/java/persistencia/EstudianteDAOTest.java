package persistencia;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import negocio.entities.Estudiante;

public class EstudianteDAOTest {

	private EstudianteDAO estudiante = new EstudianteDAO(Estudiante.class);
	
	public Estudiante crearEstudiante() {
		Estudiante estudianteCreado = new Estudiante("04866899A", "Fernando", "García Ramos", "Bachillerato", "Enseñanza");
		return estudianteCreado;
	}
	
	@Test
	public void testCrearNuevoEstudiante() {
		List<Estudiante> listaEstudianteAntes = estudiante.listarEstudiantes();
		
		Estudiante estudianteCreado = crearEstudiante();
		estudiante.crearNuevoEstudiante(estudianteCreado);
		
		List<Estudiante> listaEstudianteDespues = estudiante.listarEstudiantes();
		
		
		assertFalse(listaEstudianteAntes.contains(estudianteCreado));
		assertTrue(listaEstudianteDespues.contains(estudianteCreado));
		assertTrue(listaEstudianteAntes.size() == (listaEstudianteDespues.size() - 1));
		
		estudiante.eliminarEstudiante(estudianteCreado);
		
	}

}
