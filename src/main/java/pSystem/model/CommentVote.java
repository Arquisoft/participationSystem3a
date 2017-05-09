package pSystem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import pSystem.model.types.VoteStatus;

@Entity
@IdClass(CommentVoteKey.class)
@Table(name="TCommentsVotes")
public class CommentVote implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JsonBackReference(value = "comment-commentvotes")
	private Comment comment;
	
	@Id
	@ManyToOne
	@JsonBackReference(value = "user-commentvotes")
	private User user;
	
	@Enumerated(EnumType.STRING)
	private VoteStatus vote;
	
	CommentVote() {}

	public CommentVote(Comment comment, User user,  VoteStatus vote) {		
		super();
		Association.VotarComentario.link(comment, this, user);
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

	public VoteStatus getVote() {
		return vote;
	}

	public void setVote(VoteStatus vote) {
		this.vote = vote;
	}
	
}