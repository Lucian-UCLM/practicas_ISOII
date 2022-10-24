package persistencia;

import java.util.Date;
import java.util.List;

import negocio.entities.*;

public class CursoPropioDAO extends AbstractEntityDAO {

	/**
	 * 
	 * @param curso
	 */
	public int crearNuevoCurso(CursoPropio curso) {
		/*boolean res = false;
		String sql = "";
		sql="INSERT INTO APP.CURSOS (CURSOID, FECHA, PRECIO, PLAZAS, TIPO, LOCALIZACION, NOMBRE, CERTIFICACION) VALUES("
				+ "'"+c.getId()+"','"+format.format(c.getFecha())+"','"+c.getPrecio()+"',"
				+ "'"+c.getPlazas()+"','"+c.getTipoCurso()+"','"+c.getLocalizacion()+"',"
				+ "'"+c.getNombreCurso()+"','"+c.getCertificacionMin()+"')";
		if(GestorBD.getAgenteBD().insert(sql)==1) {
			res=true;
		}
		return res;*/
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param curso
	 */
	public CursoPropio seleccionarCurso(CursoPropio curso) {
		/*String sql= "SELECT CURSOID FROM CURSOS WHERE CURSOID = '"+id+"'";
		Curso curso= null;
		ArrayList<Object> aux = null;
		ArrayList<Object> res =GestorBD.getAgenteBD().select(sql);
		if (res.size() == 1){
			curso = new Curso((int) res.get(0), (Date) res.get(1),
					(double) res.get(2), (int) res.get(3), (String) res.get(4),
					(String) res.get(5), (String) res.get(6), (int) res.get(7));
		}
		return curso;*/
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param curso
	 */
	public CursoPropio editarCurso(CursoPropio curso) {
		// TODO - implement CursoPropioDAO.editarCurso
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param estado
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<CursoPropio> listarCursosPorEstado(EstadoCurso estado, Date fechaInicio, Date fechaFin) {
		// TODO - implement CursoPropioDAO.listarCursosPorEstado
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tipo
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public double listarIngresos(TipoCurso tipo, Date fechaInicio, Date fechaFin) {
		// TODO - implement CursoPropioDAO.listarIngresos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public void listarEdicionesCursos(Date fechaInicio, Date fechaFin) {
		// TODO - implement CursoPropioDAO.listarEdicionesCursos
		throw new UnsupportedOperationException();
	}

}