package pSystem.DBManagement.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pSystem.DBManagement.ManageCommentDB;
import pSystem.business.CommentService;
import pSystem.model.Comment;

@Service
public class ManageCommentDBImpl implements ManageCommentDB {
	
	@Autowired
	private CommentService commentService;

	@Override
	public Comment addComment(Comment comentario) {
		return commentService.addComment(comentario);
	}

	@Override
	public void deleteComment(Long id) {
		commentService.deleteByIdComment(id);
	}

	@Override
	public List<Comment> getCommentsByDate(Long id) {
		return null;
	}

	@Override
	public List<Comment> getCommentsByPopularity(Long id) {
		return commentService.orderByPopularity();
	}

}
