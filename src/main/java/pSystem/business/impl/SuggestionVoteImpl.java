package pSystem.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pSystem.business.SuggestionVoteService;
import pSystem.model.Suggestion;
import pSystem.model.SuggestionVote;
import pSystem.model.User;
import pSystem.model.types.VoteStatus;
import pSystem.persistence.SuggestionVoteRepository;

@Service
@Transactional
public class SuggestionVoteImpl implements SuggestionVoteService {

	@Autowired
	private SuggestionVoteRepository suggestionVoteRepository;
	
	@Autowired
	private JpaContext jpaContext;
	
	@Override
	public SuggestionVote addSuggestionVote(Suggestion suggestion, User user, VoteStatus vote) {
		Suggestion auxS = jpaContext.getEntityManagerByManagedType(Suggestion.class).merge(suggestion);
		User auxU = jpaContext.getEntityManagerByManagedType(User.class).merge(user);
		SuggestionVote suggestionVote = new SuggestionVote(auxS, auxU, vote);
		return suggestionVoteRepository.save(suggestionVote);
	}
	
}