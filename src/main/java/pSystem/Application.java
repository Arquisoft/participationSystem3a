package pSystem;



import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.bootstrap.encrypt.KeyProperties.Rsa;
import org.springframework.context.annotation.Bean;

import pSystem.DBManagement.CommentService;
import pSystem.DBManagement.SuggestionService;
import pSystem.DBManagement.UserService;
import pSystem.model.*;
import pSystem.persistence.SuggestionRepository;
import pSystem.persistence.VotoComentarioRepository;


@SpringBootApplication
public class Application {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private SuggestionService suggestionService;
	
	@Autowired
	private VotoComentarioRepository vRepository;
	
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public CommandLineRunner iniciarBD(SuggestionRepository sR){
    	return (args) -> {
    		User u = new User("prueba");
    		u.setContraseña("prueba");
    		userService.addUser(u);
    		
    		Suggestion s = new Suggestion("prueba", null, u);
    		suggestionService.addSuggestion(s);
    		
    		Comment c = new Comment("prueba", s, u);
    		c.setFecha(new Date());
    		
    		commentService.addComment(c);
    		VotoComentario votoComentario = new VotoComentario(c, u, true);
    		//vRepository.save(votoComentario);
    		
    		Comment c1 = new Comment("prueba", s, u);    		
    		Calendar cal = Calendar.getInstance();
    		cal.add(Calendar.DAY_OF_WEEK, -1);    		
    		c1.setFecha(cal.getTime());
    		commentService.addComment(c1);
    		
    		List<Comment> aux = commentService.findBySugerenciaOrderByFechaDesc(s);
    		
    		
//    		VotoComentario votoComentario2 = new VotoComentario(c1, u, true);
//    		
//    		
//    		vRepository.save(votoComentario2);
    		
    		for(Comment co: aux) {
    			System.out.println(co.getId());
    		}
//    		System.out.println(userService.findByUserAndPassword("prueba", "prueba").getContraseña());
    		
    		
    		
//    		sR.save(s);
    		
    	};
    }
}