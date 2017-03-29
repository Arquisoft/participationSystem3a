package hello.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="TComentarios")
public class Comentario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String contenido;
	@ManyToOne
	private Sugerencia sugerencia;
	@ManyToOne
	private Usuario usuario;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	Comentario(){}

	public Comentario(String contenido, Sugerencia sugerencia, Usuario usuario) {
		super();
		this.contenido = contenido;
		this.sugerencia = sugerencia;
		this.usuario = usuario;
		this.fecha = new Date();
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Long getId() {
		return id;
	}
	
	public Date getFecha(){
		return fecha;
	}

	public Sugerencia getSugerencia() {
		return sugerencia;
	}
	
	protected void _setSugerencia(Sugerencia sugerencia){
		this.sugerencia = sugerencia;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	protected void _setUsuario(Usuario usuario){
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contenido == null) ? 0 : contenido.hashCode());
		result = prime * result + ((sugerencia == null) ? 0 : sugerencia.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (contenido == null) {
			if (other.contenido != null)
				return false;
		} else if (!contenido.equals(other.contenido))
			return false;
		if (sugerencia == null) {
			if (other.sugerencia != null)
				return false;
		} else if (!sugerencia.equals(other.sugerencia))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", contenido=" + contenido + ", sugerencia=" + sugerencia + ", usuario="
				+ usuario + "]";
	};
}
