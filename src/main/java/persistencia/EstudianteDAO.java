package persistencia;

import negocio.entities.*;

public class EstudianteDAO extends AbstractEntityDAO {
	
	private AbstractEntityDAO abstractEntityDAO;
	
	public EstudianteDAO(Class entityClass) {
		super(entityClass);
		this.abstractEntityDAO = new AbstractEntityDAO(entityClass) {
		};
	}

	public void crearNuevoEstudiante(Estudiante estudiante){
		abstractEntityDAO.save(estudiante);
	}

	public Estudiante seleccionarEstudiante(Estudiante estudiante) {
		throw new UnsupportedOperationException();
	}

	public Estudiante editarEstudiante(Estudiante estudiante) {
		throw new UnsupportedOperationException();
	}

}