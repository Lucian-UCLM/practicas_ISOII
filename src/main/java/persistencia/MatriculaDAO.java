package persistencia;

import java.util.List;

import negocio.entities.*;

public class MatriculaDAO extends AbstractEntityDAO<Object> {

	private AbstractEntityDAO<Matricula> abstractEntityDAO;

	public MatriculaDAO(Class entityClass) {
		super(entityClass);
		this.abstractEntityDAO = new AbstractEntityDAO<Matricula>(entityClass) {
		};
	}
	
	public List<Matricula> listarMatriculas(){
		return abstractEntityDAO.showAll();
	}
	
	public void crearNuevaMatricula(Matricula matricula) {
		abstractEntityDAO.save(matricula);
	}

	public Matricula seleccionarMatricula(Matricula matricula) {
		throw new UnsupportedOperationException();
	}

	public void editarMatricula(Matricula matricula) {
		abstractEntityDAO.update(matricula);
	}

}