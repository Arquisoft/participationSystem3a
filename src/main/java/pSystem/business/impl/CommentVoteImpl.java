package pSystem.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pSystem.business.CommentVoteService;
import pSystem.model.Comment;
import pSystem.model.CommentVote;
import pSystem.model.User;
import pSystem.model.types.VoteStatus;
import pSystem.persistence.CommentVoteRepository;

@Service
@Transactional
public class CommentVoteImpl implements CommentVoteService {

	@Autowired
	private CommentVoteRepository commentVoteRepository;
	
	@Autowired
	private JpaContext jpaContext;
	
	@Override
	public CommentVote addComentVote(Comment comment, User user, VoteStatus vote) {
		Comment auxC = jpaContext.getEntityManagerByManagedType(Comment.class).merge(comment);
		User auxU = jpaContext.getEntityManagerByManagedType(User.class).merge(user);
		CommentVote commentVote = new CommentVote(auxC, auxU, vote);
		return commentVoteRepository.save(commentVote);
	}

}