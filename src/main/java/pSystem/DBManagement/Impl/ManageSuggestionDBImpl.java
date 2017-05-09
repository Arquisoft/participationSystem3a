package pSystem.DBManagement.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pSystem.DBManagement.ManageSuggestionDB;
import pSystem.Mensajeria.KafkaProducer;
import pSystem.business.CategoryService;
import pSystem.business.RestringedWordsService;
import pSystem.business.SuggestionService;
import pSystem.business.SuggestionVoteService;
import pSystem.model.Category;
import pSystem.model.RestringedWords;
import pSystem.model.Suggestion;
import pSystem.model.SuggestionVote;
import pSystem.model.User;
import pSystem.model.types.VoteStatus;

@Service
public class ManageSuggestionDBImpl implements ManageSuggestionDB {
	
	@Autowired
	private KafkaProducer producer;
	
	@Autowired
	private SuggestionService suggestionService;
	
	@Autowired
	private SuggestionVoteService voteService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private RestringedWordsService wordService;

	@Override
	public Suggestion addSuggestion(Suggestion suggestion) {
		Suggestion sugerencia = suggestionService.addSuggestion(suggestion);
		producer.sendSugerencia(sugerencia);
		return sugerencia;
	}

	@Override
	public void updateSuggestion(Suggestion sugerencia) {
		suggestionService.updateSuggestion(sugerencia);
	}

	@Override
	public void deleteSuggestion(Long id) {
		suggestionService.deleteByIdSuggestion(id);
	}

	@Override
	public Suggestion getSuggestion(Long id) {
		return suggestionService.findSuggestion(id);
	}

	@Override
	public List<Suggestion> getSuggestions() {
		return suggestionService.findAllSuggestions();
	}

	@Override
	public List<Category> findSuggestionCategories() {
		return categoryService.findAllCategories();
	}

	@Override
	public List<RestringedWords> findSuggestionRestringedWords() {
		return wordService.findAllWords();
	}

	@Override
	public SuggestionVote voteSuggestion(Suggestion suggestion, User user, VoteStatus vote) {
		System.out.println(vote);
		return voteService.addSuggestionVote(suggestion, user, vote);
	}

	@Override
	public Long inFavourVotes(Suggestion suggestion) {
		return suggestionService.inFavourVotes(suggestion);
	}

	@Override
	public RestringedWords addRestringedWord(RestringedWords word) {
		return wordService.addRestringedWord(word);
	}
}
