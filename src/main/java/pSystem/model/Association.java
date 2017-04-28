package pSystem.model;

public class Association {

	public static class Asignar {

		public static void link(User usuario, Citizen ciudadano) {
			usuario._setCiudadano(ciudadano);
			ciudadano._setUser(usuario);
		}

		public static void unlink(User usuario, Citizen ciudadano) {
			ciudadano._setUser(null);
			usuario._setCiudadano(null);
		}
	}
	
	public static class AsignarSugerencia {
		
		public static void link(User usuario, Suggestion sugerencia) {
			usuario._addSugerencia(sugerencia);
			sugerencia._setUser(usuario);
		}
		
		public static void unlink(User usuario, Suggestion sugerencia) {
			usuario._removeSugerencia(sugerencia);
			sugerencia._setUser(null);
		}
	}
	
	public static class AsignarComentario {
		
		public static void link(Comment comentario, Suggestion sugerencia, User usuario){
			usuario._addComentario(comentario);
			sugerencia.addComentario(comentario);
			comentario._setSugerencia(sugerencia);
			comentario._setUser(usuario);
		}
		
		public static void unlink(Comment comentario, Suggestion sugerencia, User usuario){
			usuario._removeComentario(comentario);
			usuario._removeSugerencia(sugerencia);
			comentario._setSugerencia(null);
			comentario._setUser(null);
		}
	}
	
	public static class VotarComentario {

		public static void link(Comment comentario, CommentVote voto, User citizen) {
			voto._setComment(comentario);
			voto._setUser(citizen);
			
			comentario.getVotos().add(voto);
			citizen.getVotosComentarios().add(voto);
			
		}

		public static void unlink(Comment comentario, CommentVote voto, User citizen) {
			comentario.getVotos().remove(voto);
			citizen.getVotosComentarios().remove(voto);
			
			voto._setComment(null);
			voto._setUser(null);			
		}
		
	

}
}
