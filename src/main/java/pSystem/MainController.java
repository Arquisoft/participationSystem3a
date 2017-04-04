package pSystem;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pSystem.SistemaDeParticipacion.MComment;
import pSystem.SistemaDeParticipacion.MSuggestion;
import pSystem.model.Sugerencia;
import pSystem.model.Usuario;
import pSystem.persistence.UsuarioFinder;
import pSystem.producers.KafkaProducer;

@Controller
public class MainController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/")
    public String landing(Model model) {
        model.addAttribute("message", new Message());
        return "index";
    }
    
    @RequestMapping("/send")
    public String send(Model model, @ModelAttribute Message message) {
        kafkaProducer.send("exampleTopic", message.getMessage());        
        return "redirect:/";
    }
    
    @RequestMapping("/login")
    public String login(Model model, @RequestParam String nombre, @RequestParam String password){
    	Usuario user = UsuarioFinder.findUsuarioByUserAndPassword(nombre, password);
    	
    	return null;
    }

}