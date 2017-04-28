package pSystem.SistemaDeParticipacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pSystem.DBManagement.CommentService;
import pSystem.model.Comment;

public class MComment implements ManageComment {
	
	@Autowired
	private CommentService commentService;

	@Override
	public void addComment(Comment comentario) {
		commentService.addComment(comentario);
	}

	@Override
	public List<Comment> getCommentsByDate(Long id) {
//		return commentService.getCommentsByDate(id);
		return null;
	}

	@Override
	public List<Comment> getCommentsByPopularity(Long id) {
		return commentService.getCommentsByPopularity(id);
	}

}
