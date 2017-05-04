package pSystem.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="TComments")
public class Comment implements Serializable {	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String contents;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@ManyToOne
	private Suggestion suggestion;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="comment")
	private Set<CommentVote> votes = new HashSet<>();
	
	Comment() {}

	public Comment(String contents, Suggestion suggestion, User user) {
		this.contents = contents;
		this.suggestion = suggestion;
		this.user = user;
		this.creationDate = new Date();
	}

	public Long getId() {
		return id;
	}
	
	public String getContents() {
		return contents;
	}
	
	public Date getCreationDate(){
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Suggestion getSuggestion() {
		return suggestion;
	}
	
	protected void _setSuggestion(Suggestion suggestion){
		this.suggestion = suggestion;
	}
	
	public User getUser() {
		return user;
	}
	
	protected void _setUser(User user){
		this.user = user;
	}	

	public Set<CommentVote> getVotes() {
		return new HashSet<>(votes);
	}

	protected Set<CommentVote> _getVotes() {
		return votes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + ((suggestion == null) ? 0 : suggestion.hashCode());
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
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		if (suggestion == null) {
			if (other.suggestion != null)
				return false;
		} else if (!suggestion.equals(other.suggestion))
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
		return "Comentario [id=" + id + ", contenido=" + contents + ", sugerencia=" + suggestion + ", usuario="
				+ user + "]";
	};
}
