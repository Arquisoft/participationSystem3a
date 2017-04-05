package pSystem.DBManagement;

import java.util.List;

import pSystem.model.Comment;
import pSystem.model.Suggestion;

public interface CommentService {
	
	Comment addComment(Comment comentario);
	List<Comment> getCommentsByDate(Long id);
	List<Comment> getCommentsByPopularity(Long id);
	List<Comment> findBySugerenciaOrderByFechaDesc(Suggestion sugerencia);
	List<Comment> findBySugerenciaOrderByFechaAsc(Suggestion sugerencia);
}
