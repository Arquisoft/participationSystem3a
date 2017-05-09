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

import pSystem.Mensajeria.KafkaProducer;
import pSystem.SistemaDeParticipacion.ManageCitizen;
import pSystem.SistemaDeParticipacion.ManageSuggestion;
import pSystem.model.Suggestion;
import pSystem.model.User;

@Controller
public class MainController {

	@Autowired
	private ManageCitizen manageUser;
	
	@Autowired
	private ManageSuggestion manageSuggestion;

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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, Model model, @RequestParam String nombre, @RequestParam String password) {
		User userLogin = manageUser.findByUserAndPassword(nombre, password);
		if (userLogin != null) {
			session.setAttribute("user", userLogin);
			List<Suggestion> sugerencias = manageSuggestion.getSuggestions();
			model.addAttribute("sugerencias", sugerencias);
			if (userLogin.isAdmin()) {
				return "listaSugerenciasAdmin";
			} else {
				return "listaSugerencias";
			}
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String cerrarSesion(HttpSession session) {
		session.setAttribute("user", null);
		return "login";
	}
}