package pSystem.SistemaDeParticipacion;

import java.util.List;

import pSystem.model.Sugerencia;

public interface ManageSuggestion {
	
	public void addSuggestion(Sugerencia sugerencia);
	public void updateSuggestion(Sugerencia sugerencia);
	public Sugerencia getSuggestion(Long id);
	public List<Sugerencia> getSuggestions();
}
