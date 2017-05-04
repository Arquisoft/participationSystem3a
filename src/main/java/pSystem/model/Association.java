package pSystem.model;

public class Association {

	/**
	 * Relacionar User - Citizen
	 */
	public static class Asignar {

		public static void link(User user, Citizen citizen) {
			user._setCitizen(citizen);
			citizen._setUser(user);
		}

		public static void unlink(User user, Citizen citizen) {
			citizen._setUser(null);
			user._setCitizen(null);
		}
	}
	
	/**
	 * Relacionar Suggestion - User
	 */
	public static class AsignarSugerencia {
		
		public static void link(User user, Suggestion suggestion) {
			user._getSuggestions().add(suggestion);
			suggestion._setUser(user);
		}
		
		public static void unlink(User user, Suggestion suggestion) {
			user._getSuggestions().remove(suggestion);
			suggestion._setUser(null);
		}
	}
	
	/**
	 * Relacionar Comment -  Suggestion - User
	 */
	public static class AsignarComentario {
		
		public static void link(Comment comment, Suggestion suggestion, User user){
			user._getComments().add(comment);
			suggestion._getComments().add(comment);
			comment._setSuggestion(suggestion);
			comment._setUser(user);			
		}
		
		public static void unlink(Comment comment, Suggestion suggestion, User user){
			user._getComments().remove(comment);			
			suggestion._getComments().remove(comment);
			comment._setSuggestion(null);
			comment._setUser(null);			
		}
	}
	
	/**
	 * Relacionar Commment - CommentVote - User
	 */
	public static class VotarComentario {

		public static void link(Comment comment, CommentVote vote, User user) {
			vote._setComment(comment);
			vote._setUser(user);
			comment._getVotes().add(vote);
			user._getCommentsVotes().add(vote);			
		}

		public static void unlink(Comment comment, CommentVote vote, User user) {
			comment._getVotes().remove(vote);
			user._getCommentsVotes().remove(vote);
			vote._setComment(null);
			vote._setUser(null);			
		}
	}
	
	/**
	 * Relacionar Suggestion - SuggestionVote - User
	 */
	public static class VotarSugerencia {

		public static void link(Suggestion suggestion, SuggestionVote vote, User user) {
			vote._setSuggestion(suggestion);		
			vote._setUser(user);
			suggestion._getVotes().add(vote);
			user._getSuggestionsVotes().add(vote);			
		}

		public static void unlink(Suggestion suggestion, SuggestionVote vote, User user) {
			suggestion._getVotes().remove(vote);
			user._getSuggestionsVotes().remove(vote);
			vote._setSuggestion(null);
			vote._setUser(null);		
		}
	}
}