package pSystem.DBManagement;

import java.util.List;

import pSystem.model.Comentario;

public interface CommentService {
	
	public void addComment(Comentario comentario);
	public List<Comentario> getCommentsByDate(Long id);
	public List<Comentario> getCommentsByPopularity(Long id);
}
