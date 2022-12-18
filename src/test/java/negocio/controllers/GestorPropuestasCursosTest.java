package negocio.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import negocio.controllers.GestorPropuestasCursos;
import negocio.entities.CategoriaProfesor;
import negocio.entities.Centro;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.ProfesorUCLM;
import negocio.entities.TipoCurso;
import persistencia.CursoPropioDAO;

import org.junit.Test;

public class GestorPropuestasCursosTest {

	private GestorPropuestasCursos gestorPropuestasCursos;
	private CursoPropioDAO cursoPropioDAO;
	
	
	public void gestor() {
		gestorPropuestasCursos = new GestorPropuestasCursos();

	}
	
	public void cursoDAO() {
		cursoPropioDAO = new CursoPropioDAO();

	}
	

	@Test
	public void realizarPropuestaCurso() {
		gestor();
		assertTrue(gestorPropuestasCursos.realizarPropuestaCurso("1000", "CursoTest", 12, new Date(2020/12/10), new Date(2021/12/10), 120.0, 10, EstadoCurso.VALIDADO,
				TipoCurso.MASTER, "01234567B", "01234567D", 7) == new CursoPropio("1000", "CursoTest", 12, new Date(2020/12/10), new Date(2021/12/10), 120.0, 10, EstadoCurso.VALIDADO,
						TipoCurso.MASTER, new Centro(7,"",""),  new ProfesorUCLM("01234567B", CategoriaProfesor.ASOCIADO,new Centro(7,"","")), new ProfesorUCLM("01234567D", CategoriaProfesor.ASOCIADO,new Centro(7,"",""))));
		
		;
	}
}
