package pSystem.SistemaDeParticipacion;

import java.util.List;

import pSystem.model.Comentario;

public interface ManageComment {
	
	public void addComment(Comentario comentario);
	public List<Comentario> getCommentsByDate(Long id);
	public List<Comentario> getCommentsByPopularity(Long id);
}
