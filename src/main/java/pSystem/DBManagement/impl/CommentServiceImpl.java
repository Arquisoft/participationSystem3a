package pSystem.DBManagement.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pSystem.DBManagement.CommentService;
import pSystem.model.Comment;
import pSystem.model.Suggestion;
import pSystem.persistence.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public void addComment(Comment comentario) {
		commentRepository.save(comentario);
	}

	@Override
	public List<Comment> getCommentsByPopularity(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findBySugerenciaOrderByFechaDesc(Suggestion sugerencia) {
		return commentRepository.findBySugerenciaOrderByFechaDesc(sugerencia);
	}

	@Override
	public List<Comment> findBySugerenciaOrderByFechaAsc(Suggestion sugerencia) {
		return commentRepository.findBySugerenciaOrderByFechaAsc(sugerencia);
	}

	@Override
	public List<Comment> getCommentsByDate(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}