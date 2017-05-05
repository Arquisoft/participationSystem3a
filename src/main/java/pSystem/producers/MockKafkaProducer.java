package pSystem.producers;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pSystem.model.Comment;
import pSystem.model.Suggestion;
import pSystem.model.SuggestionVote;

/**
 * Created by herminio on 26/12/16.
 */
@ManagedBean
public class MockKafkaProducer {

	private static final Logger logger = Logger.getLogger(MockKafkaProducer.class);
	public static final AtomicInteger counterComentario = new AtomicInteger(0);
	public static final AtomicInteger counterSugerencia = new AtomicInteger(0);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendComentario(Comment comment) {
		sendMessageJSON("comentarios", comment);
	}

	public void sendSugerencia(Suggestion suggestion) {		
		sendMessageJSON("sugerencias", suggestion);
	}
	
	public void sendSuggestionVote(SuggestionVote suggestionVote){
		sendMessageJSON("suggestionVote", suggestionVote);
	}

	public void sendMessage(String topic, String data) {
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, data);
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onSuccess(SendResult<String, String> result) {
				logger.info("Success on sending message \"" + data + "\" to topic " + topic);
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.error("Error on sending message \"" + data + "\", stacktrace " + ex.getMessage());
			}
		});
	}
	
	public void sendMessageJSON(String topic, Object data) {
		try {
			sendMessage(topic, new ObjectMapper().writeValueAsString(data));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
