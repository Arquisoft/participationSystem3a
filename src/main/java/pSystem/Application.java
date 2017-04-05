package pSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pSystem.DBManagement.CommentService;
import pSystem.DBManagement.SuggestionService;
import pSystem.DBManagement.UserService;
import pSystem.model.*;
import pSystem.persistence.CategoryRepository;
import pSystem.persistence.SuggestionRepository;


@SpringBootApplication
public class Application {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private SuggestionService suggestionService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public CommandLineRunner iniciarBD(SuggestionRepository sR){
    	return (args) -> {
    		User user1 = new User("user1");
    		user1.setContraseña("user1");
    		
    		userService.addUser(user1);
    		
    		User user2 = new User("user2");
    		user2.setContraseña("user2");
    		
    		userService.addUser(user2);
    		
    		User admin = new User("admin");
    		admin.setContraseña("admin");
    		admin.setAdmin(true);

    		userService.addUser(admin);
    		
    		Category categoria1 = new Category("Categoria1");
    		Category categoria2 = new Category("Categoria2");
    		
    		categoryRepository.save(categoria1);
    		categoryRepository.save(categoria2);
    		
    		Suggestion sugerencia1 = new Suggestion("Sugerencia1 de prueba", categoria1, user1);
    		suggestionService.addSuggestion(sugerencia1);
    		Suggestion sugerencia2 = new Suggestion("Sugerencia2 de prueba", categoria1, user1);
    		suggestionService.addSuggestion(sugerencia2);
    		Suggestion sugerencia3 = new Suggestion("Sugerencia3 de prueba", categoria2, user1);
    		suggestionService.addSuggestion(sugerencia3);
    		
    		Comment comentario1 = new Comment("Comentario1 de prueba", sugerencia1, user2);
    		commentService.addComment(comentario1);
    		Comment comentario2 = new Comment("Comentario2 de prueba", sugerencia1, user2);
    		commentService.addComment(comentario2);
    		Comment comentario3 = new Comment("Comentario3 de prueba", sugerencia1, user2);
    		commentService.addComment(comentario3);
    	};
    }
}