package pSystem.DBManagement;

import java.util.List;

import pSystem.model.Category;
import pSystem.model.RestringedWords;
import pSystem.model.Suggestion;
import pSystem.model.SuggestionVote;
import pSystem.model.User;
import pSystem.model.types.VoteStatus;

public interface ManageSuggestionDB {
	
	public Suggestion addSuggestion(Suggestion suggestion);
	public void updateSuggestion(Suggestion sugerencia);
	public void deleteSuggestion(Long id);
	public Suggestion getSuggestion(Long id);
	public List<Suggestion> getSuggestions();
	public List<Category> findSuggestionCategories();
	public List<RestringedWords> findSuggestionRestringedWords();
	public SuggestionVote voteSuggestion(Suggestion suggestion, User user, VoteStatus vote);
	public Long inFavourVotes(Suggestion suggestion);
	public RestringedWords addRestringedWord(RestringedWords word);
}
