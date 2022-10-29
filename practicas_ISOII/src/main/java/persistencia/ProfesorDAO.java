package persistencia;

import negocio.entities.*;

public class ProfesorDAO extends AbstractEntityDAO {

	private AbstractEntityDAO abstractEntityDAO;

	public ProfesorDAO(Class entityClass) {
		super(entityClass);
		this.abstractEntityDAO = new AbstractEntityDAO(entityClass) {
		};
	}

	public void crearNuevoProfesor(Profesor profesor) {
		abstractEntityDAO.save(profesor);
	}

	public Profesor listarProfesor(Profesor profesor) {
		throw new UnsupportedOperationException();
	}

	public Profesor editarProfesor(Profesor profesor) {
		throw new UnsupportedOperationException();
	}

}