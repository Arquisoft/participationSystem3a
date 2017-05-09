package pSystem;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pSystem.SistemaDeParticipacion.ManageComment;
import pSystem.SistemaDeParticipacion.ManageSuggestion;
import pSystem.model.Association;
import pSystem.model.Comment;
import pSystem.model.RestringedWords;
import pSystem.model.Suggestion;

@Controller
public class CouncilController {

	@Autowired
	private ManageSuggestion manageSuggestion;

	@Autowired
	private ManageComment manageComment;
	
	private Suggestion seleccionada;
	
	@RequestMapping(value = "/mostrarAdmin", method = RequestMethod.POST)
	public String mostrarSugerencia(HttpSession session, Model model, @RequestParam("sugerencia") Long id) {
		Suggestion sugerencia = manageSuggestion.getSuggestion(id);
		setSeleccionada(sugerencia);
		if (sugerencia != null) {
			model.addAttribute("seleccionada", sugerencia);
			return "mostrarSugerenciaAdmin";
		}
		return "listaSugerenciasAdmin";
	}

	@RequestMapping(value = "/eliminarComentario", method = RequestMethod.POST)
	public String eliminarComentario(HttpSession session, Model model, @RequestParam("comentario") Long id) {
		manageComment.deleteComment(id);
		System.out.println(getSeleccionada()+"\n"+"\n");
		model.addAttribute("seleccionada", manageSuggestion.getSuggestion(getSeleccionada().getId()));
		return "mostrarSugerenciaAdmin";
	}

	@RequestMapping(value = "/eliminarSugerencia", method = RequestMethod.POST)
	public String eliminarSugerencia(Model model, @RequestParam("sugerencia") Long id) {
		Suggestion s = manageSuggestion.getSuggestion(id);
		Association.AsignarSugerencia.unlink(s.getUser(), s);
		for (Comment c : s.getComments()) {
			manageComment.deleteComment(c.getId());
		}
		manageSuggestion.deleteSuggestion(id);
		List<Suggestion> sugerencias = manageSuggestion.getSuggestions();
		model.addAttribute("sugerencias", sugerencias);
		return "listaSugerenciasAdmin";
	}
	
	@RequestMapping(value = "/listarSugerenciasAdmin", method = RequestMethod.POST)
	public String irALista(Model model) {
		List<Suggestion> sugerencias = manageSuggestion.getSuggestions();
		model.addAttribute("sugerencias", sugerencias);
		return "listaSugerenciasAdmin";
	}
	
	@RequestMapping(value = "/anadirPalabra", method = RequestMethod.POST)
	public String añadirSugerencia(Model model, @RequestParam String palabra) {
		RestringedWords word = manageSuggestion.addRestringedWord(new RestringedWords(palabra));
		if(word!=null){
			System.out.println("añadida");
		}
		List<Suggestion> sugerencias = manageSuggestion.getSuggestions();
		model.addAttribute("sugerencias", sugerencias);
		return "listaSugerenciasAdmin";
	}

	public Suggestion getSeleccionada() {
		return seleccionada;
	}

	public void setSeleccionada(Suggestion seleccionada) {
		this.seleccionada = seleccionada;
	}
}
