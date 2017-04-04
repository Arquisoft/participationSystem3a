package pSystem;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bootstrap.encrypt.KeyProperties.Rsa;
import org.springframework.context.annotation.Bean;

import pSystem.model.Sugerencia;
import pSystem.persistence.SuggestionRepository;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public CommandLineRunner iniciarBD(SuggestionRepository sR){
    	return (args) -> {
    		Sugerencia s = new Sugerencia("prueba", null, null);
    		sR.save(s);
    		
    	};
    }
}