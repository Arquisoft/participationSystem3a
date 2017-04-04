package pSystem.model;

import java.io.Serializable;

public class VotoComentarioKey implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	Long user;
	Long comment;
	
	VotoComentarioKey() {}
	
	public VotoComentarioKey(Long user, Long comment) {
		this.user = user;
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
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
		VotoComentarioKey other = (VotoComentarioKey) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		return true;
	}	
}