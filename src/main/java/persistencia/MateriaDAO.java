package persistencia;

import negocio.entities.*;

public class MateriaDAO extends AbstractEntityDAO<Object> {
	
	private AbstractEntityDAO<Materia> abstractEntityDAO;

	public MateriaDAO(Class entityClass) {
		super(entityClass);
		this.abstractEntityDAO = new AbstractEntityDAO<Materia>(entityClass) {
		};
	}

	public void crearNuevaMateria(Materia materia) {
		abstractEntityDAO.save(materia);
	}

	public void editarMateria(Materia materia) {
		abstractEntityDAO.update(materia);
	}

}