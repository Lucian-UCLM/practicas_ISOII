package persistencia;

import java.util.Date;
import java.util.List;

import negocio.entities.*;

public class CursoPropioDAO extends AbstractEntityDAO {

	private AbstractEntityDAO abstractEntityDAO;
	
	public CursoPropioDAO(Class entityClass) {
		super(entityClass);
		this.abstractEntityDAO = new AbstractEntityDAO(entityClass) {
		};
	}

	public void crearNuevoCurso(CursoPropio curso) {
		abstractEntityDAO.save(curso);
	}

	public CursoPropio seleccionarCurso(CursoPropio curso) {
		throw new UnsupportedOperationException();
	}
	
	public List<CursoPropio> listarCursos(){
		return abstractEntityDAO.showAll();
	}
	
	public List<CursoPropio> listarCursosWhere(EstadoCurso estado){
		return abstractEntityDAO.showAllWhere("estado = "+estado.ordinal());
	}
	
	public CursoPropio listarCurso(CursoPropio curso){
		return (CursoPropio) abstractEntityDAO.show(curso.getId());
	}

	public void editarCurso(CursoPropio curso) {
		abstractEntityDAO.update(curso);
	}

	public List<CursoPropio> listarCursosPorEstado(EstadoCurso estado, Date fechaInicio, Date fechaFin) {
		throw new UnsupportedOperationException();
	}

	public double listarIngresos(TipoCurso tipo, Date fechaInicio, Date fechaFin) {
		throw new UnsupportedOperationException();
	}
	
	public void listarEdicionesCursos(Date fechaInicio, Date fechaFin) {
		throw new UnsupportedOperationException();
	}

}