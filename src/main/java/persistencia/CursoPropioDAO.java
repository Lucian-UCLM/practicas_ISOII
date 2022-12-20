package persistencia;

import java.util.List;

import negocio.entities.*;

public class CursoPropioDAO extends AbstractEntityDAO<Object> {

	private AbstractEntityDAO<CursoPropio> abstractEntityDAO;

	public CursoPropioDAO(Class entityClass) {
		super(entityClass);
		this.abstractEntityDAO = new AbstractEntityDAO<CursoPropio>(entityClass) {
		};
	}

	public void crearNuevoCurso(CursoPropio curso) {
		abstractEntityDAO.save(curso);
	}

	public void eliminarCurso(CursoPropio curso) {
		abstractEntityDAO.delete(curso);
	}

	public List<CursoPropio> listarCursos() {
		return abstractEntityDAO.showAll();
	}

	public List<CursoPropio> listarCursosWhere(EstadoCurso estado) {
		return abstractEntityDAO.showAllWhere("estado = " + estado.ordinal());
	}

	public List<CursoPropio> listarCursosWhere(TipoCurso tipo) {
		return abstractEntityDAO.showAllWhere("tipo = " + tipo.ordinal());
	}

	public CursoPropio listarCurso(CursoPropio curso) {
		return (CursoPropio) abstractEntityDAO.show(curso.getId());
	}

	public void editarCurso(CursoPropio curso) {
		abstractEntityDAO.update(curso);
	}

}