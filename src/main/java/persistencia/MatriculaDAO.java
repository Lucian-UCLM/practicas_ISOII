package persistencia;

import negocio.entities.*;

public class MatriculaDAO extends AbstractEntityDAO<Object> {

	private AbstractEntityDAO<Matricula> abstractEntityDAO;

	public MatriculaDAO(Class entityClass) {
		super(entityClass);
		this.abstractEntityDAO = new AbstractEntityDAO(entityClass) {
		};
	}

	public void crearNuevaMatricula(Matricula matricula) {
		abstractEntityDAO.save(matricula);
	}

	public Matricula seleccionarMatricula(Matricula matricula) {
		throw new UnsupportedOperationException();
	}

	public Matricula editarMatricula(Matricula matricula) {
		throw new UnsupportedOperationException();
	}

}