package persistencia;

import java.util.List;

import negocio.entities.*;

public class EstudianteDAO extends AbstractEntityDAO {
	
	private AbstractEntityDAO abstractEntityDAO;
	
	public EstudianteDAO(Class entityClass) {
		super(entityClass);
		System.out.println(entityClass);
		this.abstractEntityDAO = new AbstractEntityDAO(entityClass) {
		};
	}

	public void crearNuevoEstudiante(Estudiante estudiante){
		abstractEntityDAO.save(estudiante);
	}
	
	public List<Estudiante> listarEstudiantes(){
		return abstractEntityDAO.showAll();
	}
	
	public Estudiante listarEstudiante(Estudiante estudiante){
		return (Estudiante) abstractEntityDAO.show(estudiante.getDni());
	}
	
	public Estudiante seleccionarEstudiante(Estudiante estudiante) {
		throw new UnsupportedOperationException();
	}

	public Estudiante editarEstudiante(Estudiante estudiante) {
		throw new UnsupportedOperationException();
	}

}