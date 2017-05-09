package pSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pSystem.model.SuggestionVote;
import pSystem.model.SuggestionVoteKey;

@Repository
public interface SuggestionVoteRepository extends JpaRepository<SuggestionVote, SuggestionVoteKey> {

}