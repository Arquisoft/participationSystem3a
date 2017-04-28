package pSystem.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="TComentarios")
public class Comment implements Serializable {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String contenido;
	
	@ManyToOne
	private Suggestion sugerencia;
	
	@ManyToOne
	private User user;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@OneToMany(mappedBy="comment")
	private Set<CommentVote> votos = new HashSet<>();
	
	Comment(){}

	public Comment(String contenido, Suggestion sugerencia, User user) {
		super();
		this.contenido = contenido;
		this.sugerencia = sugerencia;
		this.user = user;
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

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Suggestion getSugerencia() {
		return sugerencia;
	}
	
	protected void _setSugerencia(Suggestion sugerencia){
		this.sugerencia = sugerencia;
	}

	public User getUser() {
		return user;
	}
	
	protected void _setUser(User user){
		this.user = user;
	}

	public Set<CommentVote> getVotos() {
		return new HashSet<>(votos);
	}

	protected void _setVotos(Set<CommentVote> votos) {
		this.votos = votos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contenido == null) ? 0 : contenido.hashCode());
		result = prime * result + ((sugerencia == null) ? 0 : sugerencia.hashCode());
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
		Comment other = (Comment) obj;
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", contenido=" + contenido + ", sugerencia=" + sugerencia + ", usuario="
				+ user + "]";
	};
}
