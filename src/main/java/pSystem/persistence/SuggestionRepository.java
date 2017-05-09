package pSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pSystem.model.Suggestion;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {	
	
	Suggestion findByContents(String contents);
	
	@Query("SELECT count(s) FROM Suggestion s, SuggestionVote sv WHERE s.id = :idS and s.id = sv.suggestion.id and sv.vote = 'IN_FAVOUR'")
	Long countInFavourVotes(@Param("idS") Long id);
}