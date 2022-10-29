package persistencia;

import negocio.entities.*;

public class MateriaDAO extends AbstractEntityDAO {
	
	private AbstractEntityDAO abstractEntityDAO;

	public MateriaDAO(Class entityClass) {
		super(entityClass);
		this.abstractEntityDAO = new AbstractEntityDAO(entityClass) {
		};
	}

	public void crearNuevaMateria(Materia materia) {
		abstractEntityDAO.save(materia);
	}

	public Materia listarMateria(Materia materia) {
		throw new UnsupportedOperationException();
	}

	public Materia editarMateria(Materia materia) {
		throw new UnsupportedOperationException();
	}

}