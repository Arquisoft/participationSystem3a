package pSystem.model;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import pSystem.model.types.SuggestionStatus;

@SuppressWarnings("serial")
@Entity
@Table(name = "TSugerencias")
public class Suggestion implements Serializable {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String contenido;
	
	@Enumerated(EnumType.STRING)
	private SuggestionStatus estado;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Category categoria;
	
	private int votosPositivos;
	private int votosNegativos;
	
	@OneToMany(mappedBy="sugerencia")
	private Set<Comment> comentarios = new HashSet<>();
	
	Suggestion(){}

	public Suggestion(String contenido, Category categoria, User user) {
		super();
		this.contenido = contenido;
		this.fecha = new Date();
		this.user = user;
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
	
	protected void _setUser(User user){
		this.user = user;
	}

	public User getUsuario() {
		return user;
	}

	public Category getCategoria() {
		return categoria;
	}
	
	public int getVotosPositivos() {
		return votosPositivos;
	}
	
	public int getVotosNegativos() {
		return votosNegativos;
	}
	
	protected Set<Comment> _getComentarios() {
		return comentarios;
	}
	
	public Set<Comment> getComentarios() {
		return new HashSet<>(comentarios);
	}

	public void setComentarios(Set<Comment> comentarios) {
		this.comentarios = comentarios;
	}
	
	public void addComentario(Comment comentario){
		comentarios.add(comentario);
	}
	
	public void addVotoPositivo(){
		this.votosPositivos++;
	}
	
	public void addVotoNegativo() {
		this.votosNegativos++;
	}

	public SuggestionStatus getEstado() {
		return estado;
	}

	public void setEstado(SuggestionStatus estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((contenido == null) ? 0 : contenido.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Suggestion other = (Suggestion) obj;
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sugerencia [id=" + id + ", contenido=" + contenido + ", usuario=" + user + ", categoria=" + categoria
				+ "]";
	}
}