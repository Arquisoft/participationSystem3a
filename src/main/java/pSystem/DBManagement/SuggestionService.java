package pSystem.DBManagement;

import java.util.List;

import pSystem.model.Suggestion;

public interface SuggestionService {
	
	public void addSuggestion(Suggestion sugerencia);
	public void updateSuggestion(Suggestion sugerencia);
	public List<Suggestion> getSuggestions();
	public Suggestion getSuggestion(Long id);
	
}