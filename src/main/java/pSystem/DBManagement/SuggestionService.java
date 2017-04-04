package pSystem.DBManagement;

import java.util.List;

import pSystem.model.Sugerencia;

public interface SuggestionService {
	
	public void addSuggestion(Sugerencia sugerencia);
	public void updateSuggestion(Sugerencia sugerencia);
	public List<Sugerencia> getSuggestions();
	public Sugerencia getSuggestion(Long id);
}
