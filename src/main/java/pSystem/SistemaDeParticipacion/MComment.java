package pSystem.SistemaDeParticipacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pSystem.DBManagement.CommentService;
import pSystem.model.Comentario;

public class MComment implements ManageComment {
	
	@Autowired
	private CommentService commentService;

	@Override
	public void addComment(Comentario comentario) {
		commentService.addComment(comentario);
	}

	@Override
	public List<Comentario> getCommentsByDate(Long id) {
		return commentService.getCommentsByDate(id);
	}

	@Override
	public List<Comentario> getCommentsByPopularity(Long id) {
		return commentService.getCommentsByPopularity(id);
	}

}
