package pSystem.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@IdClass(SuggestionVoteKey.class)
@Table(name="TSuggestionsVotes")
public class SuggestionVote implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JsonBackReference(value = "suggestion-suggestionvotes")
	private Suggestion suggestion;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JsonBackReference(value = "user-suggestionvotes")
	private User user;
	
	@Enumerated(EnumType.STRING)
	private VoteStatus vote;
	
	SuggestionVote() {}

	public SuggestionVote(Suggestion suggestion, User user, VoteStatus vote) {		
		super();
		Association.VotarSugerencia.link(suggestion, this, user);
	}

	public Suggestion getSuggestion() {
		return suggestion;
	}

	protected void _setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
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