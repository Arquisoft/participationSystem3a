package pSystem.business;

import java.util.List;

import pSystem.model.Comment;
import pSystem.model.Suggestion;

public interface CommentService {
	
	Comment addComment(Comment comentario);
	void deleteComment(Long id);	
	List<Comment> getCommentsByPopularity(Long id);
	List<Comment> findBySugerenciaOrderByFechaDesc(Suggestion sugerencia);
	List<Comment> findBySugerenciaOrderByFechaAsc(Suggestion sugerencia);
}
