package pSystem.SistemaDeParticipacion.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pSystem.DBManagement.ManageSuggestionDB;
import pSystem.SistemaDeParticipacion.ManageSuggestion;
import pSystem.model.Category;
import pSystem.model.RestringedWords;
import pSystem.model.Suggestion;
import pSystem.model.SuggestionVote;
import pSystem.model.User;
import pSystem.model.types.VoteStatus;

@Service
public class ManageSuggestionImpl implements ManageSuggestion {
	
	@Autowired
	private ManageSuggestionDB manageSuggestionDB;

	@Override
	public Suggestion addSuggestion(Suggestion sugerencia) {
		List<RestringedWords> prohibidas = findSuggestionRestringedWords();
		boolean contiene=false;
		for(RestringedWords r: prohibidas){
			if(sugerencia.getContents().toUpperCase().contains(r.getWord().toUpperCase())){
				contiene=true;
				break;
			}
		}
		if(!contiene){
			return manageSuggestionDB.addSuggestion(sugerencia);
		}
		return null;
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

	@Override
	public SuggestionVote voteSuggestion(Suggestion suggestion, User user, VoteStatus status) {
		return manageSuggestionDB.voteSuggestion(suggestion, user, status);
	}

	@Override
	public Long inFavourVotes(Suggestion suggestion) {
		return manageSuggestionDB.inFavourVotes(suggestion);
	}

	@Override
	public RestringedWords addRestringedWord(RestringedWords word) {
		return manageSuggestionDB.addRestringedWord(word);
	}
}
