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

import pSystem.DBManagement.CategoryService;
import pSystem.DBManagement.SuggestionService;
import pSystem.DBManagement.UserService;
import pSystem.model.Suggestion;
import pSystem.model.User;
//import pSystem.producers.KafkaProducer;
import pSystem.producers.KafkaProducer;

@Controller
public class MainController {
	  
	  @Autowired
	  private UserService userService;
	  
	  @Autowired
	  private SuggestionService suggestionService;
	  
	  @Autowired
	  private CategoryService categoryService;
	
    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/")
    public String landing(Model model) {
        model.addAttribute("message", new Message());
        return "login";
    }
    
    @RequestMapping("/send")
    public String send(Model model, @ModelAttribute Message message) {
        kafkaProducer.send("exampleTopic", message.getMessage());        
        return "redirect:/";
    }
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(HttpSession session, Model model, @RequestParam String nombre, @RequestParam String password){
    	User userLogin = userService.findByUserAndPassword(nombre, password);
    	if(userLogin!=null){
    		session.setAttribute("user", userLogin);
    		//cargarSugerencias(model);
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
    //	List<Category> categorias = categoryService.getCategories();
    	//model.addAttribute("categorias", categorias);
    	List<Suggestion> sugerencias = suggestionService.getSuggestions();
    	model.addAttribute("sugerencias", sugerencias);
    }
}