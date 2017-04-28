package pSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pSystem.model.CommentVote;
import pSystem.model.CommentVoteKey;

@Repository
public interface VotoComentarioRepository extends JpaRepository<CommentVote, CommentVoteKey> {

}