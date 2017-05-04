package pSystem;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pSystem.business.SuggestionService;
import pSystem.model.Category;
import pSystem.model.Comment;
import pSystem.model.Suggestion;
import pSystem.model.User;
import pSystem.persistence.CategoryRepository;
import pSystem.persistence.CommentRepository;
import pSystem.util.Util;

@Controller
public class UserController {

	@Autowired
	private SuggestionService suggestionService;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CommentRepository CommentRepository;
	
	private Util util = new Util();
	
	@RequestMapping(value = "/mostrar", method = RequestMethod.POST)
	public String mostrarSugerencia(HttpSession session, Model model, @RequestParam("sugerencia") Long id) {
		Suggestion sugerencia = suggestionService.getSuggestion(id);
		util.setSeleccionada(sugerencia);
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
		List<Category> categorias = categoryRepository.findAll();
		Suggestion suggestion = new Suggestion(contenido, categorias.get(0), (User) session.getAttribute("user"));
		suggestionService.addSuggestion(suggestion);
		util.cargarSugerencias(model, suggestionService);
		return "listaSugerencias";
	}	

	@RequestMapping("/nuevoComentario")
	public String nuevoComentario(@RequestParam("sugerencia") Suggestion sugerencia) {
		util.setSeleccionada(sugerencia);
		return "añadirComentario";
	}

	@RequestMapping(value = "/anadirComentario", method = RequestMethod.POST)
	public String añadirComentario(HttpSession session, Model model, @RequestParam String contenido) {
		Comment comentario = new Comment(contenido, util.getSeleccionada(), (User) session.getAttribute("user"));
		CommentRepository.save(comentario);
		model.addAttribute("seleccionada", suggestionService.getSuggestion(util.getSeleccionada().getId()));
		return "mostrarSugerencia";
	}
	
	@RequestMapping(value = "/listarSugerencias", method = RequestMethod.POST)
	public String irALista(Model model) {
		util.cargarSugerencias(model, suggestionService);
		return "listaSugerencias";
	}
}
