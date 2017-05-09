package pSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pSystem.business.CommentService;
import pSystem.business.SuggestionService;
import pSystem.business.UserService;
import pSystem.model.*;
import pSystem.persistence.CategoryRepository;
import pSystem.persistence.RestringedWordsRepository;
import pSystem.persistence.SuggestionRepository;


@SpringBootApplication
public class Application {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private SuggestionService suggestionService;
	
//	@Autowired
//
//	private CommentVoteService voteService;
//	
//	@Autowired
//	private CommentVoteRepository vRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private RestringedWordsRepository wordRepository;
	
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public CommandLineRunner iniciarBD(SuggestionRepository sR){
    	return (args) -> {
    		User user1 = new User("user1",null);
    		user1.setPassword("user1");
    		
    		userService.addUser(user1);
    		


//    		Comment c2 = commentService.addComment(c);    	
//    		
//    		
//    		voteService.vote(c2,u2,true);
//    		
//
//    		
//    		VotoComentario votoComentario = new VotoComentario(c2, u2, true);
//    		vRepository.save(votoComentario);
    	
    		
//    		Comment c1 = new Comment("prueba", s, u);    		
//    		Calendar cal = Calendar.getInstance();
//    		cal.add(Calendar.DAY_OF_WEEK, -1);    		
//    		c1.setFecha(cal.getTime());
//    		commentService.addComment(c1);
//    		
//    		List<Comment> aux = commentService.findBySugerenciaOrderByFechaDesc(s);

    		User user2 = new User("user2", null);
    		user2.setPassword("user2");
    		
    		userService.addUser(user2);
    		
    		User admin = new User("admin", null);
    		admin.setPassword("admin");
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
    		
    		RestringedWords word1 = new RestringedWords("puta");
    		wordRepository.save(word1);
    	};
    }
}