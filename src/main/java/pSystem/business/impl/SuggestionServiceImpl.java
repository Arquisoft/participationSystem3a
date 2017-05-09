package pSystem.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pSystem.business.SuggestionService;
import pSystem.model.Suggestion;
import pSystem.model.SuggestionVote;
import pSystem.model.User;
import pSystem.model.types.VoteStatus;
import pSystem.persistence.SuggestionRepository;

@Service
public class SuggestionServiceImpl implements SuggestionService {
	
	@Autowired
	private SuggestionRepository suggestionRepository;

	@Override
	public Suggestion addSuggestion(Suggestion suggestion) {
		return suggestionRepository.save(suggestion);
	}

	@Override
	public void deleteSuggestion(Suggestion suggestion) {
		suggestionRepository.delete(suggestion);
	}

	@Override
	public void updateSuggestion(Suggestion suggestion) {
		suggestionRepository.save(suggestion);
	}

	@Override
	public Suggestion findSuggestion(Long suggestionId) {
		return suggestionRepository.findOne(suggestionId);
	}
	
	@Override
	public void addVote(Suggestion suggestion, User user, VoteStatus vote) {
		new SuggestionVote(suggestion, user, vote);
		suggestionRepository.save(suggestion);		
	}

	@Override
	public void deleteByIdSuggestion(Long suggestionId) {
		suggestionRepository.delete(suggestionId);
	}

	@Override
	public List<Suggestion> findAllSuggestions() {
		return suggestionRepository.findAll();
	}

	@Override
	public Long inFavourVotes(Suggestion suggestion) {
		return suggestionRepository.countInFavourVotes(suggestion.getId());
	}

	@Override
	public int aganistVotes(Suggestion suggestion) {
		// TODO Auto-generated method stub
		return 0;
	}	
}