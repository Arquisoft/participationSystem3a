package pSystem.DBManagement.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pSystem.DBManagement.CommentService;
import pSystem.model.Comment;
import pSystem.model.Suggestion;
import pSystem.persistence.CommentRepository;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public Comment addComment(Comment comentario) {
		return commentRepository.save(comentario);
	}

	@Override
	public void deleteComment(Comment comentario) {
		commentRepository.delete(comentario);
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
}