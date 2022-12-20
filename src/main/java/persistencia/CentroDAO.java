package persistencia;

import java.util.List;

import negocio.entities.*;

public class CentroDAO extends AbstractEntityDAO<Object> {

	private AbstractEntityDAO<Centro> abstractEntityDAO;
	
	public CentroDAO(Class entityClass) {
		super(entityClass);
		this.abstractEntityDAO = new AbstractEntityDAO<Centro>(entityClass) {};
	}

	public void crearNuevoCentro(Centro centro) {
		abstractEntityDAO.save(centro); 
	}
	
	public void eliminarCentro(Centro centro) {
		abstractEntityDAO.delete(centro);
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