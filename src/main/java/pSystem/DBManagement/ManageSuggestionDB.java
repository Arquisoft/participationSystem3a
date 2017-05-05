package pSystem.DBManagement;

import java.util.List;

import pSystem.model.Category;
import pSystem.model.RestringedWords;
import pSystem.model.Suggestion;

public interface ManageSuggestionDB {
	
	public Suggestion addSuggestion(Suggestion suggestion);
	public void updateSuggestion(Suggestion sugerencia);
	public void deleteSuggestion(Long id);
	public Suggestion getSuggestion(Long id);
	public List<Suggestion> getSuggestions();
	public List<Category> findSuggestionCategories();
	public List<RestringedWords> findSuggestionRestringedWords();
}
