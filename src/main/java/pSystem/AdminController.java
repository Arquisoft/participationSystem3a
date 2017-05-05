package pSystem;

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
import pSystem.model.Suggestion;
import pSystem.util.Util;

@Controller
public class AdminController {

	@Autowired
	private ManageSuggestion manageSuggestion;

	@Autowired
	private ManageComment manageComment;
	
	@RequestMapping(value = "/mostrarAdmin", method = RequestMethod.POST)
	public String mostrarSugerencia(HttpSession session, Model model, @RequestParam("sugerencia") Long id) {
		Suggestion sugerencia = manageSuggestion.getSuggestion(id);
		Util.setSeleccionada(sugerencia);
		if (sugerencia != null) {
			model.addAttribute("seleccionada", sugerencia);
			return "mostrarSugerenciaAdmin";
		}
		return "listaSugerenciasAdmin";
	}

	@RequestMapping(value = "/eliminarComentario", method = RequestMethod.POST)
	public String eliminarComentario(HttpSession session, Model model, @RequestParam("comentario") Long id) {
		manageComment.deleteComment(id);
		System.out.println(Util.getSeleccionada()+"\n"+"\n");
		model.addAttribute("seleccionada", manageSuggestion.getSuggestion(Util.getSeleccionada().getId()));
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
		Util.cargarSugerencias(model);
		return "listaSugerenciasAdmin";
	}
	
	@RequestMapping(value = "/listarSugerenciasAdmin", method = RequestMethod.POST)
	public String irALista(Model model) {
		Util.cargarSugerencias(model);
		return "listaSugerenciasAdmin";
	}
}
