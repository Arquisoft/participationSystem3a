package pSystem.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import pSystem.model.types.SuggestionStatus;

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
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Category category;	
	
	@OneToMany(mappedBy="suggestion")
	private Set<Comment> comments = new HashSet<>();
	
	@OneToMany(mappedBy="suggestion")
	private Set<SuggestionVote> votes = new HashSet<>();
	
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
		return new HashSet<>(comments);
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
		return new HashSet<>(votes);
	}

	protected Set<SuggestionVote> _getVotes() {
		return votes;
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

	@Override
	public String toString() {
		return "Sugerencia [id=" + id + ", contenido=" + contents + ", usuario=" + user + ", categoria=" + category
				+ "]";
	}
}