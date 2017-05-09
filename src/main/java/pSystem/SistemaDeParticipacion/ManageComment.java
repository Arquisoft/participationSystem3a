package pSystem.SistemaDeParticipacion;

import java.util.List;

import pSystem.model.Comment;
import pSystem.model.Suggestion;

public interface ManageComment {
	
	public Comment addComment(Comment comentario);
	public void deleteComment(Long id);
	public List<Comment> getCommentsByDate(Suggestion suggestion);
	public List<Comment> getCommentsByPopularity(Suggestion suggestion);
}
