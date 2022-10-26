package negocio.entities;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
	
	@Column(name = "estudiante")
	Estudiante estudiante;
	
	@Column(name = "titulo")
	CursoPropio titulo;

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

	@Override
	public String toString() {
		return "Matricula [idMatricula=" + idMatricula + ", fecha=" + fecha + ", pagado=" + pagado + ", tipoPago="
				+ tipoPago + ", estudiante=" + estudiante + ", titulo=" + titulo + "]";
	}
	
}