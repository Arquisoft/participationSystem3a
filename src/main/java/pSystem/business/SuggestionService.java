package pSystem.business;

import java.util.List;

import pSystem.model.Suggestion;

public interface SuggestionService {
	
	public Suggestion addSuggestion(Suggestion sugerencia);
	public void updateSuggestion(Suggestion sugerencia);
	public List<Suggestion> getSuggestions();
	public Suggestion getSuggestion(Long id);
	public void deleteSuggestion(Long id);
	
}