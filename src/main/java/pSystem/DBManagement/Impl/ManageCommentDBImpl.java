package pSystem.DBManagement.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pSystem.DBManagement.ManageCommentDB;
import pSystem.Mensajeria.KafkaProducer;
import pSystem.business.CommentService;
import pSystem.model.Comment;
import pSystem.model.Suggestion;

@Service
public class ManageCommentDBImpl implements ManageCommentDB {
	
	@Autowired
	private KafkaProducer producer;
	
	@Autowired
	private CommentService commentService;

	@Override
	public Comment addComment(Comment comentario) {
		Comment comment = commentService.addComment(comentario);
		producer.sendComentario(comment);
		return comment;
	}

	@Override
	public void deleteComment(Long id) {
		commentService.deleteByIdComment(id);
	}

	@Override
	public List<Comment> getCommentsByDate(Suggestion suggestion) {
		return commentService.findBySuggestionOrderByCreationDateDesc(suggestion);
	}

	@Override
	public List<Comment> getCommentsByPopularity(Suggestion suggestion) {
		return commentService.orderByPopularity();
	}

}
