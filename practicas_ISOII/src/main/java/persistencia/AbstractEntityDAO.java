package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public abstract class AbstractEntityDAO<E> {

	private String id;
	private Date fechaCreacion;
	private Date fechaActualizacion;

	/**
	 * 
	 * @param id
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public ArrayList<Object> get(String sql) throws SQLException, Exception {
		// TODO - implement AbstractEntityDAO.get
		return GestorBD.getAgenteBD().select(sql);
	}

	/**
	 * 
	 * @param entity
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public int insert(E entity) throws SQLException, Exception {
		String sql;
		sql="INSERT INTO ";
		return GestorBD.getAgenteBD().insert(sql);
	}

	/**
	 * 
	 * @param entity
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public E update(E entity) throws SQLException, Exception {
		// TODO - implement AbstractEntityDAO.update
		GestorBD.getAgenteBD().update(id);
		return entity;
	}

	/**
	 * 
	 * @param entity
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public int delete(E entity) throws SQLException, Exception {
		return GestorBD.getAgenteBD().delete(id);
	}

	public void operation() {
		// TODO - implement AbstractEntityDAO.operation
		throw new UnsupportedOperationException();
	}

}