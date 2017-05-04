package pSystem.model;

import java.io.Serializable;

public class SuggestionVoteKey implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	Long user;
	Long suggestion;
	
	SuggestionVoteKey() {}
	
	public SuggestionVoteKey(Long user, Long suggestion) {
		this.user = user;
		this.suggestion = suggestion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((suggestion == null) ? 0 : suggestion.hashCode());
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
		SuggestionVoteKey other = (SuggestionVoteKey) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (suggestion == null) {
			if (other.suggestion != null)
				return false;
		} else if (!suggestion.equals(other.suggestion))
			return false;
		return true;
	}	
}