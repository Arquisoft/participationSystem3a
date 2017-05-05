package pSystem.DBManagement.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pSystem.DBManagement.ManageSuggestionDB;
import pSystem.business.SuggestionService;
import pSystem.model.Category;
import pSystem.model.RestringedWords;
import pSystem.model.Suggestion;

@Service
public class ManageSuggestionDBImpl implements ManageSuggestionDB {
	
	@Autowired
	private SuggestionService suggestionService;

	@Override
	public Suggestion addSuggestion(Suggestion suggestion) {
		return suggestionService.addSuggestion(suggestion);
	}

	@Override
	public void updateSuggestion(Suggestion sugerencia) {
		suggestionService.updateSuggestion(sugerencia);
	}

	@Override
	public void deleteSuggestion(Long id) {
		suggestionService.deleteSuggestion(id);
	}

	@Override
	public Suggestion getSuggestion(Long id) {
		return suggestionService.getSuggestion(id);
	}

	@Override
	public List<Suggestion> getSuggestions() {
		return suggestionService.getSuggestions();
	}

	@Override
	public List<Category> findSuggestionCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestringedWords> findSuggestionRestringedWords() {
		// TODO Auto-generated method stub
		return null;
	}

}
