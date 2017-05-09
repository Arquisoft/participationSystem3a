package pSystem.business;

import pSystem.model.Suggestion;
import pSystem.model.SuggestionVote;
import pSystem.model.User;
import pSystem.model.types.VoteStatus;

public interface SuggestionVoteService {

	//CRUD
	public SuggestionVote addSuggestionVote (Suggestion suggestion, User user, VoteStatus vote);
	
	//Otros	

}