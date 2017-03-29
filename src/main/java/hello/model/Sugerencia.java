package hello.model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "TSugerencias")
public class Sugerencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String contenido;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Categoria categoria;
	private int votosPositivos;
	private int votosNegativos;
	
	@OneToMany(mappedBy="sugerencia")
	private Set<Comentario> comentarios = new HashSet<>();
	
	Sugerencia(){}

	public Sugerencia(String contenido, Categoria categoria, Usuario usuario) {
		super();
		this.contenido = contenido;
		this.fecha = new Date();
		this.usuario = usuario;
		this.categoria = categoria;
		this.votosPositivos = 0;
		this.votosNegativos = 0;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public Long getId() {
		return id;
	}
	
	protected void _setUsuario(Usuario usuario){
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public int getVotosPositivos() {
		return votosPositivos;
	}
	
	public int getVotosNegativos() {
		return votosNegativos;
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
	
	protected void _addComentario(Comentario comentario){
		comentarios.add(comentario);
	}
	
	public void addVotoPositivo(){
		this.votosPositivos++;
	}
	
	public void addVotoNegativo() {
		this.votosNegativos++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((contenido == null) ? 0 : contenido.hashCode());
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
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sugerencia [id=" + id + ", contenido=" + contenido + ", usuario=" + usuario + ", categoria=" + categoria
				+ "]";
	}
}