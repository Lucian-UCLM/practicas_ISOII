package negocio.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Matricula")
public class Matricula {

	@Id
	@Column(name = "idmatricula")
	private int idMatricula;

	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "pagado")
	private boolean pagado;

	@Column(name = "tipopago")
	ModoPago tipoPago;

	@Transient
	Estudiante estudiante;

	@Column(name = "estudiante")
	String idEstudiante;

	@Transient
	CursoPropio titulo;

	@Column(name = "titulo")
	String idTitulo;

	public Matricula() {

	}

	public Matricula(int idMatricula, Date fecha, boolean pagado, ModoPago tipoPago, Estudiante estudiante,
			CursoPropio titulo) {
		super();
		this.idMatricula = idMatricula;
		this.fecha = fecha;
		this.pagado = pagado;
		this.tipoPago = tipoPago;
		this.estudiante = estudiante;
		this.titulo = titulo;
		this.idEstudiante = estudiante.getDni();
		this.idTitulo = titulo.getId();
	}

	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public ModoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(ModoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public CursoPropio getTitulo() {
		return titulo;
	}

	public void setTitulo(CursoPropio titulo) {
		this.titulo = titulo;
	}

	public String getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(String idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getIdTitulo() {
		return idTitulo;
	}

	public void setIdTitulo(String idTitulo) {
		this.idTitulo = idTitulo;
	}

	@Override
	public String toString() {
		return "Matricula [idMatricula=" + idMatricula + ", fecha=" + fecha + ", pagado=" + pagado + ", tipoPago="
				+ tipoPago + ", estudiante=" + estudiante + ", idEstudiante=" + idEstudiante + ", titulo=" + titulo
				+ ", idTitulo=" + idTitulo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMatricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		return idMatricula == other.idMatricula;
	}

}