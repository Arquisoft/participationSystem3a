package pSystem.SistemaDeParticipacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pSystem.DBManagement.SuggestionService;
import pSystem.model.Sugerencia;

public class MSuggestion implements ManageSuggestion {
	
	@Autowired
	private SuggestionService suggestionService;

	
	@Override
	public void addSuggestion(Sugerencia sugerencia) {
		suggestionService.addSuggestion(sugerencia);
	}

	@Override
	public void updateSuggestion(Sugerencia sugerencia) {
		suggestionService.updateSuggestion(sugerencia);
	}

	@Override
	public Sugerencia getSuggestion(Long id) {
		return null;
	}

	@Override
	public List<Sugerencia> getSuggestions() {
		return null;
	}

}
