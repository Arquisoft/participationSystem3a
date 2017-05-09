package pSystem.Mensajeria.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pSystem.Mensajeria.KafkaProducer;
import pSystem.model.Comment;
import pSystem.model.Suggestion;
import pSystem.model.SuggestionVote;

import javax.annotation.ManagedBean;

/**
 * Created by herminio on 26/12/16.
 */
@ManagedBean
@Service
public class KafkaProducerImpl implements KafkaProducer{

    private static final Logger logger = Logger.getLogger(KafkaProducerImpl.class);

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
	
	private void sendMessageJSON(String topic, Object data) {
		try {
			send(topic, new ObjectMapper().writeValueAsString(data));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

    public void send(String topic, String data) {
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
}
