package pSystem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@IdClass(CommentVoteKey.class)
@Table(name="TVotosComentarios")
public class CommentVote implements Serializable {

	@Id
	@ManyToOne
	private Comment comment;
	
	@Id
	@ManyToOne
	private User user;
	
	private boolean votoAFavor;
	
	CommentVote() {}

	public CommentVote(Comment comment, User user, boolean votoAFavor) {		
		this.comment = comment;
		this.user = user;
		this.votoAFavor = votoAFavor;
		Association.VotarComentario.link(comment, this, user);
	}

	public Comment getComment() {
		return comment;
	}

	public void _setComment(Comment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void _setUser(User user) {
		this.user = user;
	}

	public boolean isVotoAFavor() {
		return votoAFavor;
	}

	public void setVotoAFavor(boolean voto) {
		this.votoAFavor = voto;
	}
}
