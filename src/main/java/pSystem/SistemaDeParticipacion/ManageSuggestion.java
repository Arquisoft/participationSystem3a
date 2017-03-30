package pSystem.SistemaDeParticipacion;

import java.util.List;

import pSystem.model.Sugerencia;

public interface ManageSuggestion {
	
	public void addSuggestion(Sugerencia sugerencia);
	public void updateSuggestion(Sugerencia sugerencia);
	public List<Sugerencia> getSuggestion(Long id);
}
