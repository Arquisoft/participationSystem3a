package pSystem.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pSystem.business.SuggestionService;
import pSystem.model.Suggestion;
import pSystem.persistence.SuggestionRepository;

@Service
public class SuggestionVoteImpl implements SuggestionService {

	@Autowired
	private SuggestionRepository sRepository;
	
	@Override
	public Suggestion addSuggestion(Suggestion sugerencia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSuggestion(Suggestion sugerencia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Suggestion> getSuggestions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suggestion getSuggestion(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSuggestion(Long id) {
		// TODO Auto-generated method stub
		
	}

}
