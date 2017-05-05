package pSystem.SistemaDeParticipacion;

import java.util.List;

import pSystem.model.Comment;

public interface ManageComment {
	
	public Comment addComment(Comment comentario);
	public void deleteComment(Long id);
	public List<Comment> getCommentsByDate(Long id);
	public List<Comment> getCommentsByPopularity(Long id);
}
