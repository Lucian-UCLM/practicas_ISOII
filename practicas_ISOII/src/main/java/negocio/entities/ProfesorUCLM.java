package negocio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProfesorUCLM")
public class ProfesorUCLM extends Profesor {

	@Id
	@Column(name = "profesor_dni")
	private String dniProfesor;
	
	@Column(name = "categoria")
	CategoriaProfesor categoria;
	
	@Column(name = "centroadscripcion")
	Centro centroAdscripcion;

	public ProfesorUCLM() {

	}

	public ProfesorUCLM(String dniProfesor, CategoriaProfesor categoria, Centro centroAdscripcion) {
		super();
		this.dniProfesor = dniProfesor;
		this.categoria = categoria;
		this.centroAdscripcion = centroAdscripcion;
	}

	public String getDniProfesor() {
		return dniProfesor;
	}

	public void setDniProfesor(String dniProfesor) {
		this.dniProfesor = dniProfesor;
	}

	public CategoriaProfesor getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProfesor categoria) {
		this.categoria = categoria;
	}

	public Centro getCentroAdscripcion() {
		return centroAdscripcion;
	}

	public void setCentroAdscripcion(Centro centroAdscripcion) {
		this.centroAdscripcion = centroAdscripcion;
	}

	@Override
	public String toString() {
		return "ProfesorUCLM [dniProfesor=" + dniProfesor + ", categoria=" + categoria + ", centroAdscripcion="
				+ centroAdscripcion + "]";
	}
	
}