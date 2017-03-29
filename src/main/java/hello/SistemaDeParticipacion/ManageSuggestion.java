package hello.SistemaDeParticipacion;

import java.util.List;

import hello.model.Sugerencia;

public interface ManageSuggestion {
	
	public void addSuggestion(Sugerencia sugerencia);
	public void updateSuggestion(Sugerencia sugerencia);
	public List<Sugerencia> getSuggestion(Long id);
}
