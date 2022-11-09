package negocio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProfesorExterno")
@PrimaryKeyJoinColumn(name = "dni")
public class ProfesorExterno extends Profesor {

	@Id
	@Column(name = "profesor_dni")
	private String dniProfesor;
	
	@Column(name = "titulacion")
	private String titulacion;

	public ProfesorExterno() {

	}

	public ProfesorExterno(String dniProfesor, String titulacion) {
		super();
		this.dniProfesor = dniProfesor;
		this.titulacion = titulacion;
	}

	public String getDniProfesor() {
		return dniProfesor;
	}

	public void setDniProfesor(String dniProfesor) {
		this.dniProfesor = dniProfesor;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	@Override
	public String toString() {
		return "ProfesorExterno [dniProfesor=" + dniProfesor + ", titulacion=" + titulacion + "]";
	}
	
}