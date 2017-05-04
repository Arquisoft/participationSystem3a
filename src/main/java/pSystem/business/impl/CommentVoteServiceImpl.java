package pSystem.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pSystem.business.CommentService;
import pSystem.business.CommentVoteService;
import pSystem.model.Comment;
import pSystem.model.CommentVote;
import pSystem.model.Suggestion;
import pSystem.model.User;
import pSystem.persistence.CommentVoteRepository;

@Service
public class CommentVoteServiceImpl implements CommentVoteService {

	@Autowired
	private CommentVoteRepository re;

	@Override
	public CommentVote vote(Comment c, User u, boolean f) {
		CommentVote votoComentario = new CommentVote(c,u,null);
		return re.save(votoComentario);
	}
}