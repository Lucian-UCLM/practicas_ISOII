package negocio.entities;

import java.util.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Centro")
public class Centro {

	@Id
	@Column(name = "idcentro")
	private int idCentro;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "localizacion")
	private String localizacion;

	@Transient
	Collection<CursoPropio> cursoPropios;
	
	@Transient
	Collection<ProfesorUCLM> plantilla;

	public Centro() {

	}

	public Centro(int idCentro, String nombre, String localizacion) {
		super();
		this.idCentro = idCentro;
		this.nombre = nombre;
		this.localizacion = localizacion;
	}

	public int getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(int idCentro) {
		this.idCentro = idCentro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public Collection<CursoPropio> getCursoPropios() {
		return cursoPropios;
	}

	public void setCursoPropios(Collection<CursoPropio> cursoPropios) {
		this.cursoPropios = cursoPropios;
	}

	public Collection<ProfesorUCLM> getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(Collection<ProfesorUCLM> plantilla) {
		this.plantilla = plantilla;
	}

	@Override
	public String toString() {
		return "Centro [idCentro=" + idCentro + ", nombre=" + nombre + ", localizacion=" + localizacion
				+ ", cursoPropios=" + cursoPropios + ", plantilla=" + plantilla + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCentro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Centro other = (Centro) obj;
		return idCentro == other.idCentro;
	}

}