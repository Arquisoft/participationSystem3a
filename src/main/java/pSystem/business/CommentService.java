package pSystem.business;

import java.util.List;

import pSystem.model.Comment;
import pSystem.model.Suggestion;

public interface CommentService {
	
	//CRUD
	public Comment addComment (Comment comment);
	public void deleteComment (Comment comment);
	public void updateComment (Comment comment);
	public Comment findComment (Long commentId);
	
	//Otros
	public void deleteByIdComment (Long commentId);
	public List<Comment> orderByPopularity();
	public List<Comment> findBySuggestionOrderByCreationDateDesc(Suggestion suggestion);
	public List<Comment> findBySuggestionOrderByCreationDateAsc(Suggestion suggestion);
	
}