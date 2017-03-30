package pSystem.SistemaDeParticipacion;

import pSystem.model.Comentario;
import pSystem.model.Sugerencia;

public class AddComment implements ManageComment {

	@Override
	public void addComment(Comentario comentario) {
		Sugerencia sugerencia = comentario.getSugerencia();
		sugerencia.addComentario(comentario);
		UpdateSuggestionR usR = new UpdateSuggestionR();
		usR.updateSuggestion(sugerencia);
	}

}
