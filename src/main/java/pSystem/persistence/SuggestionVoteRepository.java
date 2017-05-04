package pSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import pSystem.model.SuggestionVote;
import pSystem.model.SuggestionVoteKey;

public interface SuggestionVoteRepository extends JpaRepository<SuggestionVote, SuggestionVoteKey> {

}
