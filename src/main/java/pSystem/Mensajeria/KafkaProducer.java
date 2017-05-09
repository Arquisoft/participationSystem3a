package pSystem.Mensajeria;

import pSystem.model.Comment;
import pSystem.model.Suggestion;

public interface KafkaProducer {
	
	public void sendComentario(Comment comment);
	public void sendSugerencia(Suggestion suggestion);
}
