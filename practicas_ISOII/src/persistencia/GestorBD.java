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

public class GestorBD {
	
	public static void main(String[]args) {
		System.out.println("HOLA");
		crearBaseDatosSinoExiste();
	}
	
	private static GestorBD instancia;
	protected static Connection mBD;
	public static GestorBD getAgenteBD() throws Exception {
		if (instancia == null) {
			instancia = new GestorBD();
		}
		return instancia;
	}
	
	public static void crearBaseDatosSinoExiste() {
		Connection conn = null;
		PreparedStatement pstmt;
		Statement stmt;
		ResultSet rs = null;
		String createSQL = "create table usuario (login varchar(30) not null, pass varchar(30) not null, constraint primary_key primary key (login))";

		try {
			Driver derbyEmbeddedDriver = new EmbeddedDriver();
			DriverManager.registerDriver(derbyEmbeddedDriver);
			conn = DriverManager.getConnection(BDConstantes.CONNECTION_STRING, BDConstantes.DBUSER, BDConstantes.DBPASS);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.execute(createSQL);

			pstmt = conn.prepareStatement("insert into usuario (login, pass) values(?,?)");
			pstmt.setString(1, "alumno");
			pstmt.setString(2, "alumno");
			pstmt.executeUpdate();

			rs = stmt.executeQuery("select * from usuario");
			while (rs.next()) {
				System.out.printf("%s - pass: %s\n", rs.getString(1), rs.getString(2));
			}

			//stmt.execute("drop table usuario");

			conn.commit();

		} catch (SQLException ex) {
			System.out.println("in connection" + ex);
		}

		try {
			DriverManager.getConnection("jdbc:derby:;shutdown=true");
		} catch (SQLException ex) {
			if (((ex.getErrorCode() == 50000) && ("XJ015".equals(ex.getSQLState())))) {
				System.out.println("Derby shut down normally");
			} else {
				System.err.println("Derby did not shut down normally");
				System.err.println(ex.getMessage());
			}
		}
	}
	
	private GestorBD() throws Exception {
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