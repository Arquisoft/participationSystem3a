package pSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import pSystem.model.CommentVote;
import pSystem.model.CommentVoteKey;


public interface CommentVoteRepository  extends JpaRepository<CommentVote, CommentVoteKey>{

}