package persistencia;

import java.util.List;

import negocio.entities.*;

public class ProfesorDAO extends AbstractEntityDAO<Object> {

	private AbstractEntityDAO abstractEntityDAO;

	public ProfesorDAO(Class entityClass) {
		super(entityClass);
		this.abstractEntityDAO = new AbstractEntityDAO(entityClass) {
		};
	}

	public void crearNuevoProfesor(Profesor profesor) {
		abstractEntityDAO.save(profesor);
	}
	public void eliminarProfesor(Profesor profesor) {
		abstractEntityDAO.delete(profesor);
	}

	public List<ProfesorUCLM> listarProfesorUCLM(){
		return abstractEntityDAO.showAll();
	}
	
	public Profesor listarProfesor(Profesor profesor) {
		throw new UnsupportedOperationException();
	}

	public Profesor editarProfesor(Profesor profesor) {
		throw new UnsupportedOperationException();
	}

}