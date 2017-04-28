package pSystem;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pSystem.DBManagement.SuggestionService;
import pSystem.DBManagement.UserService;
import pSystem.model.Category;
import pSystem.model.Comment;
import pSystem.model.Suggestion;
import pSystem.model.User;
import pSystem.persistence.CategoryRepository;
import pSystem.persistence.CommentRepository;
//import pSystem.producers.KafkaProducer;

@Controller
public class MainController {
	  
	  @Autowired
	  private UserService userService;
	  
	  @Autowired
	  private SuggestionService suggestionService;
	  
	  @Autowired
	  private CategoryRepository categoryRepository;
	  
	  @Autowired
	  private CommentRepository CommentRepository;
	
//	  @Autowired
//	  private KafkaProducer kafkaProducer;
	    
	  private Suggestion seleccionada;

    @RequestMapping("/")
    public String landing(Model model) {
        model.addAttribute("message", new Message());
        return "login";
    }
    
//    @RequestMapping("/send")
//    public String send(Model model, @ModelAttribute Message message) {
//        kafkaProducer.send("exampleTopic", message.getMessage());        
//        return "redirect:/";
//    }
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(HttpSession session, Model model, @RequestParam String nombre, @RequestParam String password){
    	User userLogin = userService.findByUserAndPassword(nombre, password);
    	if(userLogin!=null){
    		session.setAttribute("user", userLogin);
    		cargarSugerencias(model);
    	}
    	else{
    		return "login";
    	}
    	
    	return "listaSugerencias";
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.POST)
    public String cerrarSesion(HttpSession session){
    	session.setAttribute("user", null);
    	return "login";
    }
    
    private void cargarSugerencias(Model model){
    	List<Suggestion> sugerencias = suggestionService.getSuggestions();
    	model.addAttribute("sugerencias", sugerencias);
    }
    
    @RequestMapping("/nuevaSugerencia")
    public String nuevaSugerencia(){
    	return "añadirSugerencia";
    }
    
    @RequestMapping(value="/anadirSugerencia", method = RequestMethod.POST)
    public String añadirSugerencia(HttpSession session, Model model, @RequestParam String contenido){
    	List<Category> categorias = categoryRepository.findAll();    	
    	Suggestion suggestion = new Suggestion(contenido, categorias.get(0), (User)session.getAttribute("user"));
    	suggestionService.addSuggestion(suggestion);
    	cargarSugerencias(model);
    	return "listaSugerencias";
    }
    
    @RequestMapping(value="/mostrar", method = RequestMethod.POST)
    public String mostrarSugerencia(Model model, @RequestParam("sugerencia") Long id){
    	Suggestion sugerencia = suggestionService.getSuggestion(id);
    	if(sugerencia!=null){
	    	model.addAttribute("seleccionada", sugerencia);
	    	return "mostrarSugerencia";
    	}
    	return "listaSugerencias";
    }
    
    @RequestMapping("/nuevoComentario")
    public String nuevoComentario(@RequestParam("sugerencia") Suggestion sugerencia){
    	this.seleccionada=sugerencia;
    	return "añadirComentario";
    }
    
    @RequestMapping(value="/anadirComentario", method = RequestMethod.POST)
    public String añadirComentario(HttpSession session, Model model, @RequestParam String contenido){
    	Comment comentario = new Comment(contenido, seleccionada, (User)session.getAttribute("user"));
    	CommentRepository.save(comentario);
    	model.addAttribute("seleccionada", suggestionService.getSuggestion(seleccionada.getId()));
    	return "mostrarSugerencia";
    }
}