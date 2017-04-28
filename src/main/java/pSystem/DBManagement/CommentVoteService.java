package pSystem.DBManagement;

import pSystem.model.Comment;
import pSystem.model.CommentVote;
import pSystem.model.User;

public interface CommentVoteService {

	CommentVote vote(Comment c, User u, boolean f);
	
}
