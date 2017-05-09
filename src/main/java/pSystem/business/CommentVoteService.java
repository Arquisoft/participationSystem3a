package pSystem.business;

import pSystem.model.Comment;
import pSystem.model.CommentVote;
import pSystem.model.User;
import pSystem.model.types.VoteStatus;

public interface CommentVoteService {

	//CRUD
	public CommentVote addComentVote (Comment comment, User user, VoteStatus vote);
	
	//Otros
	
}