package pSystem.SistemaDeParticipacion.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pSystem.DBManagement.ManageCommentDB;
import pSystem.SistemaDeParticipacion.ManageComment;
import pSystem.model.Comment;
import pSystem.model.Suggestion;

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
	public List<Comment> getCommentsByDate(Suggestion suggestion) {
		return manageCommentDB.getCommentsByDate(suggestion);
	}

	@Override
	public List<Comment> getCommentsByPopularity(Suggestion suggestion) {
		return manageCommentDB.getCommentsByPopularity(suggestion);
	}
}