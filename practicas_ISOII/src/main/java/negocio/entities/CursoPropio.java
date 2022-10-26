package negocio.entities;

import java.util.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CursoPropio")
public class CursoPropio {

	@Id
	@Column(name = "idcursopropio")
	private String id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "ects")
	private int ECTS;

	@Column(name = "fechainicio")
	private Date fechaInicio;

	@Column(name = "fechafin")
	private Date fechaFin;

	@Column(name = "tasamatricula")
	private double tasaMatricula;

	@Column(name = "edicion")
	private int edicion;

	@Column(name = "estado")
	EstadoCurso estado;

	@Column(name = "tipo")
	TipoCurso tipo;

	@Column(name = "centro")
	Centro centro;

	@Column(name = "director")
	ProfesorUCLM director;

	@Column(name = "secretario")
	ProfesorUCLM secretario;

	Collection<Matricula> matriculas;
	Collection<Materia> materias;

	public CursoPropio() {

	}
	
	public CursoPropio(String id, String nombre, int eCTS, Date fechaInicio, Date fechaFin, double tasaMatricula,
			int edicion, EstadoCurso estado, TipoCurso tipo, Centro centro, ProfesorUCLM director,
			ProfesorUCLM secretario) {
		super();
		this.id = id;
		this.nombre = nombre;
		ECTS = eCTS;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tasaMatricula = tasaMatricula;
		this.edicion = edicion;
		this.estado = estado;
		this.tipo = tipo;
		this.centro = centro;
		this.director = director;
		this.secretario = secretario;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getECTS() {
		return ECTS;
	}

	public void setECTS(int eCTS) {
		ECTS = eCTS;
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

	public double getTasaMatricula() {
		return tasaMatricula;
	}

	public void setTasaMatricula(double tasaMatricula) {
		this.tasaMatricula = tasaMatricula;
	}

	public int getEdicion() {
		return edicion;
	}

	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}

	public EstadoCurso getEstado() {
		return estado;
	}

	public void setEstado(EstadoCurso estado) {
		this.estado = estado;
	}

	public TipoCurso getTipo() {
		return tipo;
	}

	public void setTipo(TipoCurso tipo) {
		this.tipo = tipo;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

	public ProfesorUCLM getDirector() {
		return director;
	}

	public void setDirector(ProfesorUCLM director) {
		this.director = director;
	}

	public ProfesorUCLM getSecretario() {
		return secretario;
	}

	public void setSecretario(ProfesorUCLM secretario) {
		this.secretario = secretario;
	}

	public Collection<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Collection<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Collection<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(Collection<Materia> materias) {
		this.materias = materias;
	}

	@Override
	public String toString() {
		return "CursoPropio [id=" + id + ", nombre=" + nombre + ", ECTS=" + ECTS + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", tasaMatricula=" + tasaMatricula + ", edicion=" + edicion + ", estado="
				+ estado + ", tipo=" + tipo + ", centro=" + centro + ", director=" + director + ", secretario="
				+ secretario + ", matriculas=" + matriculas + ", materias=" + materias + "]";
	}
	
}