package pSystem.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import pSystem.model.types.SuggestionStatus;
import pSystem.model.types.VoteStatus;

@Entity
@Table(name = "TSuggestions")
public class Suggestion implements Serializable {	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String contents;
	
	@Enumerated(EnumType.STRING)
	private SuggestionStatus status;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@Temporal(TemporalType.DATE)
	private Date finalizationDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference(value = "user-suggestions")
	private User user;
	
	@ManyToOne
	@JsonBackReference(value = "category-suggestions")
	private Category category;	
	
	@OneToMany(mappedBy="suggestion", fetch = FetchType.EAGER)
	@JsonManagedReference(value = "suggestion-comments")
	private Set<Comment> comments = new HashSet<Comment>();
	
	@OneToMany(mappedBy="suggestion", fetch = FetchType.EAGER)
	@JsonManagedReference(value = "suggestion-suggestionvotes")
	private Set<SuggestionVote> votes = new HashSet<SuggestionVote>();
	
	@Transient
	private double rating;
	
	@Transient
	private int positiveVotes;
	
	@Transient
	private int negativeVotes;
	
	@Transient
	private int totalVotes;
	
	@Transient
	private int numComments;
	
	Suggestion() {}

	public Suggestion(String contents, Category category, User user) {		
		this.contents = contents;
		this.creationDate = new Date();
		this.user = user;
		this.category = category;	
		this.status = SuggestionStatus.OPEN;
	}
	
	public Long getId() {
		return id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Date getFinalizationDate() {
		return finalizationDate;
	}
	
	public void setFinalizationDatee(Date finalizationDate) {
		this.finalizationDate = finalizationDate;
	}
	
	public User getUser() {
		return user;
	}
	
	protected void _setUser(User user){
		this.user = user;
	}	

	public Category getCategory() {
		return category;
	}
	
	protected void _setCategory(Category category){
		this.category = category;
	}	
	
	public Set<Comment> getComments() {
		return new HashSet<Comment>(comments);
	}
	
	protected Set<Comment> _getComments() {
		return comments;
	}	

	public SuggestionStatus getStatus() {
		return status;
	}

	public void setStatus(SuggestionStatus status) {
		this.status = status;
	}
	
	public Set<SuggestionVote> getVotes() {
		return new HashSet<SuggestionVote>(votes);
	}

	protected Set<SuggestionVote> _getVotes() {
		return votes;
	}
	
	public double getRating() {
		int positiveVotes = getPositiveVotes();
		int votes = positiveVotes + getNegativeVotes();
		if(votes == 0)
			rating = 0;
		else
			rating = positiveVotes/(double)votes;
		return rating;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public int getPositiveVotes() {
		positiveVotes = (int) votes.stream().filter(v -> v.getVote() == VoteStatus.IN_FAVOUR).count();
		return positiveVotes;
	}
	
	public void setPositiveVotes(int positiveVotes) {
		this.positiveVotes = positiveVotes;
	}
	
	public int getNegativeVotes() {
		negativeVotes = (int) votes.stream().filter(v -> v.getVote() == VoteStatus.AGAINST).count();
		return negativeVotes;
	}
	
	public void setNegativeVotes(int negativeVotes) {
		this.negativeVotes = negativeVotes;
	}
	
	public int getTotalVotes() {
		totalVotes = getPositiveVotes() + getNegativeVotes();
		return totalVotes;
	}
	
	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
	}
	
	public int getNumComments() {
		numComments = comments.size();
		return numComments;
	}
	
	public void setNumComments(int numComments) {
		this.numComments = numComments;
	}

	@Override
	public String toString() {
		return "Suggestion [id=" + id + ", contents=" + contents + ", user=" + user + ", category=" + category
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
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
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
}