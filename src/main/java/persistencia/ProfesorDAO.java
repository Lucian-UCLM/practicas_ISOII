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

	public void crearNuevoProfesor(ProfesorUCLM profesor) {
		abstractEntityDAO.save(profesor);
	}
	public void eliminarProfesor(ProfesorUCLM profesor) {
		abstractEntityDAO.delete(profesor);
	}
	
	public List<Profesor> listarProfesor(){
		return abstractEntityDAO.showAll();
	}

	public List<ProfesorUCLM> listarProfesorUCLM(){
		return abstractEntityDAO.showAll();
	}

}