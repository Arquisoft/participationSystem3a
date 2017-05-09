package pSystem.business;

import java.util.List;

import pSystem.model.Suggestion;
import pSystem.model.User;
import pSystem.model.types.VoteStatus;


public interface SuggestionService {
	
	//CRUD
	public Suggestion addSuggestion (Suggestion suggestion);	
	public void deleteSuggestion (Suggestion suggestion);
	public void updateSuggestion (Suggestion suggestion);
	public Suggestion findSuggestion (Long suggestionId);
	
	//Otros
	public void addVote (Suggestion suggestion, User user, VoteStatus vote);
	public void deleteByIdSuggestion (Long suggestionId);
	public List<Suggestion> findAllSuggestions();
	public Long inFavourVotes(Suggestion suggestion);
	public int aganistVotes(Suggestion suggestion);
}