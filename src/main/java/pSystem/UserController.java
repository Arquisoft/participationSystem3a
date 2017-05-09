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
import pSystem.model.RestringedWords;
import pSystem.model.Suggestion;
import pSystem.model.SuggestionVote;
import pSystem.model.User;
import pSystem.model.types.VoteStatus;

@Controller
public class UserController {

	@Autowired
	private ManageSuggestion manageSuggestion;

	@Autowired
	private ManageComment manageComment;
	
	private Suggestion seleccionada;

	@RequestMapping(value = "/mostrar", method = RequestMethod.POST)
	public String mostrarSugerencia(HttpSession session, Model model, @RequestParam("sugerencia") Long id) {
		Suggestion sugerencia = manageSuggestion.getSuggestion(id);
		setSeleccionada(sugerencia);
		if (sugerencia != null) {
			model.addAttribute("seleccionada", sugerencia);
			model.addAttribute("comentarios", sugerencia.getComments());
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
		List<RestringedWords> prohibidas = manageSuggestion.findSuggestionRestringedWords();
		boolean contiene=false;
		for(RestringedWords r: prohibidas){
			if(contenido.toUpperCase().contains(r.getWord().toUpperCase())){
				contiene=true;
				break;
			}
		}
		if(!contiene){
			List<Category> categorias = manageSuggestion.findSuggestionCategories();
			Suggestion suggestion = new Suggestion(contenido, categorias.get(0), (User) session.getAttribute("user"));
			manageSuggestion.addSuggestion(suggestion);
		}
		List<Suggestion> sugerencias = manageSuggestion.getSuggestions();
		model.addAttribute("sugerencias", sugerencias);
		return "listaSugerencias";
	}

	@RequestMapping("/nuevoComentario")
	public String nuevoComentario(@RequestParam("sugerencia") Suggestion sugerencia) {
		setSeleccionada(sugerencia);
		return "añadirComentario";
	}

	@RequestMapping(value = "/anadirComentario", method = RequestMethod.POST)
	public String añadirComentario(HttpSession session, Model model, @RequestParam String contenido) {
		List<RestringedWords> prohibidas = manageSuggestion.findSuggestionRestringedWords();
		boolean contiene = false;
		for(RestringedWords r: prohibidas){
			if(contenido.toUpperCase().contains(r.getWord().toUpperCase())){
				contiene = true;
				break;
			}
		}
		if(!contiene){
			Comment comentario = new Comment(contenido, getSeleccionada(), (User) session.getAttribute("user"));
			manageComment.addComment(comentario);
		}
		model.addAttribute("seleccionada", manageSuggestion.getSuggestion(getSeleccionada().getId()));
		return "mostrarSugerencia";
	}

	@RequestMapping(value = "/listarSugerencias", method = RequestMethod.POST)
	public String irALista(Model model) {
		List<Suggestion> sugerencias = manageSuggestion.getSuggestions();
		model.addAttribute("sugerencias", sugerencias);
		return "listaSugerencias";
	}

	@RequestMapping(value = "/votarSugerencia", method = RequestMethod.POST)
	public String votarSugerencia(HttpSession session, Model model,  @RequestParam("voto") String contenido) {
		SuggestionVote vote = null;
		if (contenido.equals("positivo")) {
			vote = manageSuggestion.voteSuggestion(getSeleccionada(), (User) session.getAttribute("user"),
					VoteStatus.IN_FAVOUR);
		} else {
			vote = manageSuggestion.voteSuggestion(getSeleccionada(), (User) session.getAttribute("user"),
					VoteStatus.AGAINST);
		}	
		if(vote!=null){
			System.out.println("Voto añadido");
		}
		List<Suggestion> sugerencias = manageSuggestion.getSuggestions();
		model.addAttribute("sugerencias", sugerencias);
		return "listaSugerencias";
	}
	
	@RequestMapping(value = "/ordenarPorFecha", method = RequestMethod.POST)
	public String ordenarPorFecha(Model model){
		List<Comment> comments = manageComment.getCommentsByDate(seleccionada);
		model.addAttribute("comentarios", comments);
		model.addAttribute("seleccionada", seleccionada);
		return "mostrarSugerencia";
	}

	public Suggestion getSeleccionada() {
		return seleccionada;
	}

	public void setSeleccionada(Suggestion seleccionada) {
		this.seleccionada = seleccionada;
	}
}
