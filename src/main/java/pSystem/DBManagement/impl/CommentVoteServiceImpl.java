package pSystem.DBManagement.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pSystem.DBManagement.CommentService;
import pSystem.DBManagement.CommentVoteService;
import pSystem.model.Comment;
import pSystem.model.CommentVote;
import pSystem.model.Suggestion;
import pSystem.model.User;
import pSystem.persistence.VotoComentarioRepository;

@Service
@Transactional
public class CommentVoteServiceImpl implements CommentVoteService {

	@Autowired
	private VotoComentarioRepository re;

	@Override
	public CommentVote vote(Comment c, User u, boolean f) {
		CommentVote votoComentario = new CommentVote(c,u,true);
		return re.save(votoComentario);
	}
	
	

	

}
