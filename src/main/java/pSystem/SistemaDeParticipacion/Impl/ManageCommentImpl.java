package pSystem.SistemaDeParticipacion.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pSystem.DBManagement.ManageCommentDB;
import pSystem.SistemaDeParticipacion.ManageComment;
import pSystem.model.Comment;

@Service
public class ManageCommentImpl implements ManageComment {
	
	@Autowired
	private ManageCommentDB manageCommentDB;

	@Override
	public Comment addComment(Comment comentario) {
		return manageCommentDB.addComment(comentario);
	}

	@Override
	public void deleteComment(Long id) {
		manageCommentDB.deleteComment(id);
	}

	@Override
	public List<Comment> getCommentsByDate(Long id) {
		return manageCommentDB.getCommentsByDate(id);
	}

	@Override
	public List<Comment> getCommentsByPopularity(Long id) {
		return manageCommentDB.getCommentsByPopularity(id);
	}
}