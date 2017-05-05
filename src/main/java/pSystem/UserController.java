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
import pSystem.model.Category;
import pSystem.model.Comment;
import pSystem.model.Suggestion;
import pSystem.model.User;
import pSystem.util.Util;

@Controller
public class UserController {

	@Autowired
	private ManageSuggestion manageSuggestion;

	@Autowired
	private ManageComment manageComment;
	
	@RequestMapping(value = "/mostrar", method = RequestMethod.POST)
	public String mostrarSugerencia(HttpSession session, Model model, @RequestParam("sugerencia") Long id) {
		Suggestion sugerencia = manageSuggestion.getSuggestion(id);
		Util.setSeleccionada(sugerencia);
		if (sugerencia != null) {
			model.addAttribute("seleccionada", sugerencia);
			return "mostrarSugerencia";
		}
		return "listaSugerencias";
	}

	@RequestMapping("/nuevaSugerencia")
	public String nuevaSugerencia() {
		return "añadirSugerencia";
	}

	@RequestMapping(value = "/anadirSugerencia", method = RequestMethod.POST)
	public String añadirSugerencia(HttpSession session, Model model, @RequestParam String contenido) {
		List<Category> categorias = manageSuggestion.findSuggestionCategories();
		Suggestion suggestion = new Suggestion(contenido, categorias.get(0), (User) session.getAttribute("user"));
		manageSuggestion.addSuggestion(suggestion);
		Util.cargarSugerencias(model);
		return "listaSugerencias";
	}	

	@RequestMapping("/nuevoComentario")
	public String nuevoComentario(@RequestParam("sugerencia") Suggestion sugerencia) {
		Util.setSeleccionada(sugerencia);
		return "añadirComentario";
	}

	@RequestMapping(value = "/anadirComentario", method = RequestMethod.POST)
	public String añadirComentario(HttpSession session, Model model, @RequestParam String contenido) {
		Comment comentario = new Comment(contenido, Util.getSeleccionada(), (User) session.getAttribute("user"));
		manageComment.addComment(comentario);
		model.addAttribute("seleccionada", manageSuggestion.getSuggestion(Util.getSeleccionada().getId()));
		return "mostrarSugerencia";
	}
	
	@RequestMapping(value = "/listarSugerencias", method = RequestMethod.POST)
	public String irALista(Model model) {
		Util.cargarSugerencias(model);
		return "listaSugerencias";
	}
}
