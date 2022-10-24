package persistencia;

import java.sql.SQLException;

import negocio.entities.*;

public class EstudianteDAO extends AbstractEntityDAO {
	private AbstractEntityDAO<Estudiante> entidad = new AbstractEntityDAO<Estudiante>() {
	};
	/**
	 * 
	 * @param estudiante
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public void crearNuevoEstudiante(Estudiante estudiante) throws SQLException, Exception {
		entidad.insert(estudiante);
	}

	/**
	 * 
	 * @param estudiante
	 */
	public Estudiante seleccionarEstudiante(Estudiante estudiante) {
		// TODO - implement EstudianteDAO.seleccionarEstudiante
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param estudiante
	 */
	public Estudiante editarEstudiante(Estudiante estudiante) {
		// TODO - implement EstudianteDAO.editarEstudiante
		throw new UnsupportedOperationException();
	}

}