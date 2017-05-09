package pSystem.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pSystem.model.Comment;
import pSystem.model.Suggestion;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	List<Comment> findBySuggestionOrderByCreationDateDesc(Suggestion suggestion);
	List<Comment> findBySuggestionOrderByCreationDateAsc(Suggestion suggestion);
	
}