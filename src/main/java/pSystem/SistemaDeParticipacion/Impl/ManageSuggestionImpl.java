package pSystem.SistemaDeParticipacion.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pSystem.DBManagement.ManageSuggestionDB;
import pSystem.SistemaDeParticipacion.ManageSuggestion;
import pSystem.model.Category;
import pSystem.model.RestringedWords;
import pSystem.model.Suggestion;

@Service
public class ManageSuggestionImpl implements ManageSuggestion {
	
	@Autowired
	private ManageSuggestionDB manageSuggestionDB;

	@Override
	public Suggestion addSuggestion(Suggestion sugerencia) {
		return manageSuggestionDB.addSuggestion(sugerencia);
	}

	@Override
	public void updateSuggestion(Suggestion sugerencia) {
		manageSuggestionDB.updateSuggestion(sugerencia);
	}

	@Override
	public void deleteSuggestion(Long id) {
		manageSuggestionDB.deleteSuggestion(id);
	}

	@Override
	public Suggestion getSuggestion(Long id) {
		return manageSuggestionDB.getSuggestion(id);
	}

	@Override
	public List<Suggestion> getSuggestions() {
		return manageSuggestionDB.getSuggestions();
	}

	@Override
	public List<Category> findSuggestionCategories() {
		return manageSuggestionDB.findSuggestionCategories();
	}

	@Override
	public List<RestringedWords> findSuggestionRestringedWords() {
		return manageSuggestionDB.findSuggestionRestringedWords();
	}
}
