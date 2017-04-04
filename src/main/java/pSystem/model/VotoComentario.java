package pSystem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(VotoComentarioKey.class)
@Table(name="TVotosComentarios")
public class VotoComentario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	private Comment comment;
	
	@Id
	@ManyToOne
	private User user;
	
	private boolean votoAFavor;
	
	VotoComentario() {}

	public VotoComentario(Comment comment, User user, boolean votoAFavor) {		
		this.comment = comment;
		this.user = user;
		this.votoAFavor = votoAFavor;
	}

	public Comment getComment() {
		return comment;
	}

	protected void _setComment(Comment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	protected void _setUser(User user) {
		this.user = user;
	}

	public boolean isVotoAFavor() {
		return votoAFavor;
	}

	public void setVotoAFavor(boolean voto) {
		this.votoAFavor = voto;
	}
}
