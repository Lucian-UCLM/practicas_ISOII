package negocio.entities;

import java.util.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "CursoPropio")
public class CursoPropio {

	@Id
	@Column(name = "idcursopropio")
	private String id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "ects")
	private int ects;

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

	@Transient
	Centro centro;

	@Column(name = "centro")
	int idCentro;

	@Transient
	ProfesorUCLM director;

	@Column(name = "director")
	String idDirector;

	@Transient
	ProfesorUCLM secretario;

	@Column(name = "secretario")
	String idSecretario;

	@Transient
	Collection<Matricula> matriculas;

	@Transient
	Collection<Materia> materias;

	public CursoPropio() {

	}

	public CursoPropio(String id, String nombre, int ects, Date fechaInicio, Date fechaFin, double tasaMatricula,
			int edicion, EstadoCurso estado, TipoCurso tipo, Centro centro, ProfesorUCLM director,
			ProfesorUCLM secretario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ects = ects;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tasaMatricula = tasaMatricula;
		this.edicion = edicion;
		this.estado = estado;
		this.tipo = tipo;
		this.centro = centro;
		this.director = director;
		this.secretario = secretario;
		this.idCentro = centro.getIdCentro();
		this.idDirector = director.getDniProfesor();
		this.idSecretario = secretario.getDniProfesor();
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
		return ects;
	}

	public void setECTS(int eCTS) {
		ects = eCTS;
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

	public int getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(int idCentro) {
		this.idCentro = idCentro;
	}

	public String getIdDirector() {
		return idDirector;
	}

	public void setIdDirector(String idDirector) {
		this.idDirector = idDirector;
	}

	public String getIdSecretario() {
		return idSecretario;
	}

	public void setIdSecretario(String idSecretario) {
		this.idSecretario = idSecretario;
	}

	public void setMaterias(Collection<Materia> materias) {
		this.materias = materias;
	}

	@Override
	public String toString() {
		return "CursoPropio [id=" + id + ", nombre=" + nombre + ", ECTS=" + ects + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", tasaMatricula=" + tasaMatricula + ", edicion=" + edicion + ", estado="
				+ estado + ", tipo=" + tipo + ", centro=" + centro + ", idCentro=" + idCentro + ", director=" + director
				+ ", idDirector=" + idDirector + ", secretario=" + secretario + ", idSecretario=" + idSecretario
				+ ", matriculas=" + matriculas + ", materias=" + materias + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoPropio other = (CursoPropio) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

	

}