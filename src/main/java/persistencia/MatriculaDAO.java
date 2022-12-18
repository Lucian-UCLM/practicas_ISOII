package persistencia;

import java.util.List;

import negocio.entities.*;

public class MatriculaDAO extends AbstractEntityDAO<Object> {

	private AbstractEntityDAO<Matricula> abstractEntityDAO;

	public MatriculaDAO(Class entityClass) {
		super(entityClass);
		this.abstractEntityDAO = new AbstractEntityDAO(entityClass) {
		};
	}
	
	public List<Matricula> listarMatriculasWhereEstudiante(Estudiante estudiante){
		return abstractEntityDAO.showAllWhere("'estudiante' = '"+estudiante.getDni()+"'");
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