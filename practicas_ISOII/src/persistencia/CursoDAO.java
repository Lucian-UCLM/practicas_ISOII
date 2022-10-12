package persistencia;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Logica.Entidades.*;

public class CursoDAO {
	static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
	/**
	 * 
	 * @param c
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static boolean nuevoCurso(Curso c) throws SQLException, Exception {
		boolean res = false;
		String sql = "";
		sql="INSERT INTO APP.CURSOS (CURSOID, FECHA, PRECIO, PLAZAS, TIPO, LOCALIZACION, NOMBRE, CERTIFICACION) VALUES("
				+ "'"+c.getId()+"','"+format.format(c.getFecha())+"','"+c.getPrecio()+"',"
				+ "'"+c.getPlazas()+"','"+c.getTipoCurso()+"','"+c.getLocalizacion()+"',"
				+ "'"+c.getNombreCurso()+"','"+c.getCertificacionMin()+"')";
		if(AgenteBD.getAgenteBD().insert(sql)==1) {
			res=true;
		}
		return res;
	}

	/**
	 * 
	 * @param id
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static Curso getCurso(int id) throws SQLException, Exception {
		String sql= "SELECT CURSOID FROM CURSOS WHERE CURSOID = '"+id+"'";
		Curso curso= null;
		ArrayList<Object> aux = null;
		ArrayList<Object> res =AgenteBD.getAgenteBD().select(sql);
		if (res.size() == 1){
			curso = new Curso((int) res.get(0), (Date) res.get(1),
					(double) res.get(2), (int) res.get(3), (String) res.get(4),
					(String) res.get(5), (String) res.get(6), (int) res.get(7));
		}
		return curso;
	}
}