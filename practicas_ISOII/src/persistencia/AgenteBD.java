package persistencia;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.derby.jdbc.EmbeddedDriver;


public class AgenteBD {
	private static AgenteBD instancia;
	protected static Connection mBD;
	public static AgenteBD getAgenteBD() throws Exception {
		if (instancia == null) {
			instancia = new AgenteBD();
		}
		return instancia;
	}

	private AgenteBD() throws Exception {
		conect();
	}
	private void conect() throws SQLException, Exception {
		Driver derbyEmbeddedDriver = new EmbeddedDriver();
		DriverManager.registerDriver(derbyEmbeddedDriver);
		mBD = DriverManager.getConnection(BDConstantes.CONNECTION_STRING, BDConstantes.DBUSER, BDConstantes.DBPASS);
	}
	public void disconnect() throws SQLException {
		mBD.close();
	}

	/**
	 * 
	 * @param sql
	 */
	public int insert(String sql) throws SQLException, Exception {
		// TODO - implement AgenteBD.insert
		conect();
		PreparedStatement stmt = mBD.prepareStatement(sql);
		int res = stmt.executeUpdate();
		stmt.close();
		disconnect();
		return res;
	}

	/**
	 * 
	 * @param sql
	 */
	public int delete(String sql) throws SQLException, Exception {
		conect();
		PreparedStatement stmt = mBD.prepareStatement(sql);
		int res = stmt.executeUpdate();
		stmt.close();
		disconnect();
		return res;
	}

	/**
	 * 
	 * @param sql
	 */
	public int update(String sql) throws SQLException, Exception {
		conect();
		PreparedStatement stmt = mBD.prepareStatement(sql);
		int res = stmt.executeUpdate();
		stmt.close();
		disconnect();
		return res;
	}

	/**
	 * 
	 * @param sql
	 */
	public ArrayList<Object> select(String sql) throws SQLException, Exception{
		// TODO - implement AgenteBD.select
		ArrayList<Object> dataListRes = new ArrayList<Object>();
		conect();
		Statement stmt = mBD.createStatement();
		ResultSet res = stmt.executeQuery(sql);
		while (res.next()) {
			ArrayList<Object> aux = new ArrayList<Object>();
			aux.add(res.getObject(1));
			aux.add(res.getObject(2));
			dataListRes.add(aux);
		}
		stmt.close();
		disconnect();
		return dataListRes;
	}

}