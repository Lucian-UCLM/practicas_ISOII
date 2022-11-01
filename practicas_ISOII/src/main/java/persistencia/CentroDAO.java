package persistencia;

import java.util.List;

import negocio.entities.*;

public class CentroDAO extends AbstractEntityDAO {

	private AbstractEntityDAO abstractEntityDAO;
	
	public CentroDAO(Class entityClass) {
		super(entityClass);
		this.abstractEntityDAO = new AbstractEntityDAO(entityClass) {
		};
	}

	public void crearNuevoCentro(Centro centro) {
		abstractEntityDAO.save(centro);
	}

	public List<Centro> listarCentros(){
		return abstractEntityDAO.showAll();
	}
	
	public Centro editarCentro(Centro centro) {
		throw new UnsupportedOperationException();
	}

	public Centro listarCentro(Centro centro) {
		throw new UnsupportedOperationException();
	}

}