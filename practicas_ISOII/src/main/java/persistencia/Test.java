package persistencia;

import java.util.Date;

import negocio.entities.*;

public class Test {
	public static void main(String[] args) {
		Centro centro = new Centro(1,"ew","w");
		ProfesorUCLM profe1=new ProfesorUCLM("01234567A",CategoriaProfesor.ASOCIADO,centro);
		ProfesorUCLM profe2=new ProfesorUCLM("01234567B",CategoriaProfesor.ASOCIADO,centro);
		CursoPropio curso = new CursoPropio("ww","dd", 1, new Date(200,4,5), new Date(210,4,5),2.3,2,EstadoCurso.VALIDADO,TipoCurso.EXPERTO,centro, profe1,profe2);
		System.out.println(curso.toString());
		CursoPropioDAO dao= new CursoPropioDAO(CursoPropio.class);
		dao.crearNuevoCurso(curso);
	}
}
