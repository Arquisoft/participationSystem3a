package pSystem.DBManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pSystem.model.Comentario;
import pSystem.persistence.CommentRepository;

public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public void addComment(Comentario comentario) {
		commentRepository.save(comentario);
	}

	@Override
	public List<Comentario> getCommentsByDate(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comentario> getCommentsByPopularity(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
