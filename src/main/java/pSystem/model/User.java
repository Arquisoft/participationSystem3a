package pSystem.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TUsers")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username; 
	private String password;
	private boolean isAdmin;

	@OneToOne
	@JoinColumn(name = "CITIZEN_ID")
	@JsonIgnore
	private Citizen citizen;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.PERSIST)
	@JsonManagedReference(value = "user-suggestions")
	private Set<Suggestion> suggestions = new HashSet<>();
	
	@OneToMany(mappedBy="user")
	@JsonManagedReference(value = "user-comments")
	private Set<Comment> comments = new HashSet<>();
	
	@OneToMany(mappedBy="user") 
	@JsonManagedReference(value = "user-commentvotes")
	private Set<CommentVote> commentsVotes = new HashSet<>();
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	@JsonManagedReference(value = "user-suggestionvotes")
	private Set<SuggestionVote> suggestionsVotes = new HashSet<>();

	User() {}

	public User(String username, Citizen citizen) {
		this.username = username;
		this.citizen = citizen;
	}

	public User(String username, String password, Citizen citizen) {
		this(username, citizen);
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	protected void _setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	
	public Set<Suggestion> getSuggestions() {
		return new HashSet<>(suggestions);
	}
	
	protected Set<Suggestion> _getSuggestions() {
		return suggestions;
	}
	
	public Set<Comment> getCommments() {
		return new HashSet<>(comments);
	}
	
	protected Set<Comment> _getComments(){
		return comments;
	}
	
	public Set<CommentVote> getCommentsVotes() {
		return commentsVotes;
	}
	
	protected Set<CommentVote> _getCommentsVotes() {
		return new HashSet<>(commentsVotes);
	}
	
	public Set<SuggestionVote> getSuggestionsVotes() {
		return new HashSet<>(suggestionsVotes);
	}
	
	protected Set<SuggestionVote> _getSuggestionsVotes() {
		return suggestionsVotes;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citizen == null) ? 0 : citizen.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		if (citizen == null) {
			if (other.citizen != null)
				return false;
		} else if (!citizen.equals(other.citizen))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}	
	
}