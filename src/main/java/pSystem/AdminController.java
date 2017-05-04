package pSystem;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pSystem.business.SuggestionService;
import pSystem.model.Association;
import pSystem.model.Comment;
import pSystem.model.Suggestion;
import pSystem.persistence.CommentRepository;
import pSystem.util.Util;

@Controller
public class AdminController {

	@Autowired
	private CommentRepository CommentRepository;

	@Autowired
	private SuggestionService suggestionService;
	
	private Util util = new Util();
	
	@RequestMapping(value = "/mostrarAdmin", method = RequestMethod.POST)
	public String mostrarSugerencia(HttpSession session, Model model, @RequestParam("sugerencia") Long id) {
		Suggestion sugerencia = suggestionService.getSuggestion(id);
		util.setSeleccionada(sugerencia);
		if (sugerencia != null) {
			model.addAttribute("seleccionada", sugerencia);
			return "mostrarSugerenciaAdmin";
		}
		return "listaSugerenciasAdmin";
	}

	@RequestMapping(value = "/eliminarComentario", method = RequestMethod.POST)
	public String eliminarComentario(HttpSession session, Model model, @RequestParam("comentario") Long id) {
		CommentRepository.delete(id);
		System.out.println(util.getSeleccionada()+"\n"+"\n");
		model.addAttribute("seleccionada", suggestionService.getSuggestion(util.getSeleccionada().getId()));
		return "mostrarSugerenciaAdmin";
	}

	@RequestMapping(value = "/eliminarSugerencia", method = RequestMethod.POST)
	public String eliminarSugerencia(Model model, @RequestParam("sugerencia") Long id) {
		Suggestion s = suggestionService.getSuggestion(id);
		Association.AsignarSugerencia.unlink(s.getUser(), s);
		for (Comment c : s.getComments()) {
			CommentRepository.delete(c);
		}
		suggestionService.deleteSuggestion(id);
		util.cargarSugerencias(model, suggestionService);
		return "listaSugerenciasAdmin";
	}
	
	@RequestMapping(value = "/listarSugerenciasAdmin", method = RequestMethod.POST)
	public String irALista(Model model) {
		util.cargarSugerencias(model, suggestionService);
		return "listaSugerenciasAdmin";
	}
}
