package pSystem.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "TUsuarios")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String usuario; // Clave primaria
	private String contraseña;
	private boolean isAdmin;

	@OneToOne
	@JoinColumn(name = "CIUDADANO_ID")
	private Citizen ciudadano;
	
	@OneToMany(mappedBy="user")
	private Set<Suggestion> sugerencias = new HashSet<>();
	
	@OneToMany(mappedBy="user")
	private Set<Comment> comentarios = new HashSet<>();
	
	@OneToMany(mappedBy="user") 
	private Set<CommentVote> votosComentarios = new HashSet<>();

	User() {}

	public User(String usuario) {
		this.usuario = usuario;
	}

	public User(String usuario, String contraseña, Citizen ciudadano) {
		this(usuario);
		this.contraseña = contraseña;
		this.ciudadano = ciudadano;
	}

	public Long getId() {
		return id;
	}

	public String getUsuario() {
		return usuario;
	}

	// No hay de usuario

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Citizen getCiudadano() {
		return ciudadano;
	}

	protected void _setCiudadano(Citizen ciudadano) {
		this.ciudadano = ciudadano;
	}
	
	public Set<Suggestion> getSugerencias() {
		return new HashSet<>(sugerencias);
	}
	
	protected Set<Suggestion> _getSugerencias() {
		return sugerencias;
	}

	public void setSugerencias(Set<Suggestion> sugerencias) {
		this.sugerencias = sugerencias;
	}
	
	public Set<Comment> getComentarios() {
		return new HashSet<>(comentarios);
	}
	
	protected Set<Comment> _getComentarios(){
		return comentarios;
	}

	public void setComentarios(Set<Comment> comentarios) {
		this.comentarios = comentarios;
	}

	protected void _addSugerencia(Suggestion sugerencia){
		sugerencias.add(sugerencia);
	}
	
	protected void _removeSugerencia(Suggestion sugerencia){
		sugerencias.remove(sugerencia);
	}
	
	protected void _addComentario(Comment comentario) {
		comentarios.add(comentario);
	}
	
	protected void _removeComentario(Comment comentario) {
		comentarios.remove(comentario);
	}
	
	
	public Set<CommentVote> getVotosComentarios() {
		return votosComentarios;
	}

	public void setVotosComentarios(Set<CommentVote> votosComentarios) {
		this.votosComentarios = votosComentarios;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", contraseña=" + contraseña + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		User other = (User) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}