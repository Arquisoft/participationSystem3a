package pSystem.SistemaDeParticipacion;

import java.util.List;

import pSystem.model.Category;
import pSystem.model.RestringedWords;
import pSystem.model.Suggestion;

public interface ManageSuggestion {
	
	public Suggestion addSuggestion(Suggestion sugerencia);
	public void updateSuggestion(Suggestion sugerencia);
	public void deleteSuggestion(Long id);
	public Suggestion getSuggestion(Long id);
	public List<Suggestion> getSuggestions();
	public List<Category> findSuggestionCategories();
	public List<RestringedWords> findSuggestionRestringedWords();
}
