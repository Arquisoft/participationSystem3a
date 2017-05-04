package pSystem.util;

import java.util.List;

import org.springframework.ui.Model;

import pSystem.business.SuggestionService;
import pSystem.model.Suggestion;

public class Util {
	
	private Suggestion seleccionada;
	
	public void cargarSugerencias(Model model, SuggestionService suggestionService) {
		List<Suggestion> sugerencias = suggestionService.getSuggestions();
		model.addAttribute("sugerencias", sugerencias);
	}

	public Suggestion getSeleccionada() {
		return seleccionada;
	}

	public void setSeleccionada(Suggestion seleccionada) {
		this.seleccionada = seleccionada;
	}
}