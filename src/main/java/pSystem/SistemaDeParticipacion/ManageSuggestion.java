package pSystem.SistemaDeParticipacion;

import java.util.List;

import pSystem.model.Suggestion;

public interface ManageSuggestion {
	
	public void addSuggestion(Suggestion sugerencia);
	public void updateSuggestion(Suggestion sugerencia);
	public Suggestion getSuggestion(Long id);
	public List<Suggestion> getSuggestions();
}
