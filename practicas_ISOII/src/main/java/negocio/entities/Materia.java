package negocio.entities;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Materia")
public class Materia {

	@Id
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "horas")
	private double horas;

	@Column(name = "fechainicio")
	private Date fechaInicio;

	@Column(name = "fechafin")
	private Date fechaFin;

	@Transient
	Profesor responsable;

	@Column(name = "responsable")
	String idResponsable;

	@Transient
	CursoPropio curso;

	@Column(name = "curso")
	String idCurso;

	public Materia() {

	}

	public Materia(String nombre, double horas, Date fechaInicio, Date fechaFin, Profesor responsable,
			CursoPropio curso) {
		super();
		this.nombre = nombre;
		this.horas = horas;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.responsable = responsable;
		this.curso = curso;
		this.idResponsable = responsable.getDni();
		this.idCurso = curso.getId();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Profesor getResponsable() {
		return responsable;
	}

	public void setResponsable(Profesor responsable) {
		this.responsable = responsable;
	}

	public CursoPropio getCurso() {
		return curso;
	}

	public void setCurso(CursoPropio curso) {
		this.curso = curso;
	}

	public String getIdResponsable() {
		return idResponsable;
	}

	public void setIdResponsable(String idResponsable) {
		this.idResponsable = idResponsable;
	}

	public String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", horas=" + horas + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", responsable=" + responsable + ", idResponsable=" + idResponsable + ", curso=" + curso
				+ ", idCurso=" + idCurso + "]";
	}

}