package pSystem.model;

public class Association {

	public static class Asignar {

		public static void link(User usuario, Citizen ciudadano) {
			usuario._setCiudadano(ciudadano);
			ciudadano._setUsuario(usuario);
		}

		public static void unlink(User usuario, Citizen ciudadano) {
			ciudadano._setUsuario(null);
			usuario._setCiudadano(null);
		}
	}
	
	public static class AsignarSugerencia {
		
		public static void link(User usuario, Suggestion sugerencia) {
			usuario._addSugerencia(sugerencia);
			sugerencia._setUsuario(usuario);
		}
		
		public static void unlink(User usuario, Suggestion sugerencia) {
			usuario._removeSugerencia(sugerencia);
			sugerencia._setUsuario(null);
		}
	}
	
	public static class AsignarComentario {
		
		public static void link(Comment comentario, Suggestion sugerencia, User usuario){
			usuario._addComentario(comentario);
			sugerencia.addComentario(comentario);
			comentario._setSugerencia(sugerencia);
			comentario._setUsuario(usuario);
		}
		
		public static void unlink(Comment comentario, Suggestion sugerencia, User usuario){
			usuario._removeComentario(comentario);
			usuario._removeSugerencia(sugerencia);
			comentario._setSugerencia(null);
			comentario._setUsuario(null);
		}
	}
}
