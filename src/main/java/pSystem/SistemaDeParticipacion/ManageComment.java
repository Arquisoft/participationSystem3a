package pSystem.SistemaDeParticipacion;

import java.util.List;

import pSystem.model.Comment;

public interface ManageComment {
	
	public void addComment(Comment comentario);
	public List<Comment> getCommentsByDate(Long id);
	public List<Comment> getCommentsByPopularity(Long id);
}
