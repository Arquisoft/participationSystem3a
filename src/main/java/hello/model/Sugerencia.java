package hello.model;
import java.util.HashSet;
import java.util.Set;

public class Sugerencia {
	
	private Long id;
	private String contenido;
	private Usuario usuario;
	private Categoria categoria;
	
	private Set<Comentario> comentarios = new HashSet<>();
	
	Sugerencia(){}

	public Sugerencia(String contenido, Categoria categoria, Usuario usuario) {
		super();
		this.contenido = contenido;
		this.usuario = usuario;
		this.categoria = categoria;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	protected Set<Comentario> _getComentarios() {
		return comentarios;
	}
	
	public Set<Comentario> getComentarios() {
		return new HashSet<>(comentarios);
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((contenido == null) ? 0 : contenido.hashCode());
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
		Sugerencia other = (Sugerencia) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (contenido == null) {
			if (other.contenido != null)
				return false;
		} else if (!contenido.equals(other.contenido))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sugerencia [id=" + id + ", contenido=" + contenido + ", usuario=" + usuario + ", categoria=" + categoria
				+ "]";
	}
}