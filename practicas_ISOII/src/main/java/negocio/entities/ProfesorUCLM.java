package negocio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "ProfesorUCLM")
@PrimaryKeyJoinColumn(name = "dni")
public class ProfesorUCLM extends Profesor {

	@Id
	@Column(name = "dni")
	private String dniProfesor;
	
	@Column(name = "categoria")
	CategoriaProfesor categoria;
	
	@Transient
	Centro centroAdscripcion;
	
	@Column(name = "centroadscripcion")
	int idCentroAdscripcion;

	public ProfesorUCLM() {

	}

	public ProfesorUCLM(String dniProfesor, CategoriaProfesor categoria, Centro centroAdscripcion) {
		super();
		this.dniProfesor = dniProfesor;
		this.categoria = categoria;
		this.centroAdscripcion = centroAdscripcion;
		this.idCentroAdscripcion= centroAdscripcion.getIdCentro();
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

	public int getIdCentroAdscripcion() {
		return idCentroAdscripcion;
	}

	public void setIdCentroAdscripcion(int idCentroAdscripcion) {
		this.idCentroAdscripcion = idCentroAdscripcion;
	}

	@Override
	public String toString() {
		return "ProfesorUCLM [dniProfesor=" + dniProfesor + ", categoria=" + categoria + ", centroAdscripcion="
				+ centroAdscripcion + ", idCentroAdscripcion=" + idCentroAdscripcion + "]";
	}
	
}