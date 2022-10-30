package persistencia;

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

	public Centro editarCentro(Centro centro) {
		throw new UnsupportedOperationException();
	}

	public Centro listarCentro(Centro centro) {
		throw new UnsupportedOperationException();
	}

}