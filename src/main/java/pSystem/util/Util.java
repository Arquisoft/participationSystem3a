package pSystem.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import pSystem.SistemaDeParticipacion.ManageSuggestion;
import pSystem.model.Suggestion;

public class Util {
	
	@Autowired
	private static ManageSuggestion manageSuggestion;
	
	private static Suggestion seleccionada;
	
	public static void cargarSugerencias(Model model) {
		List<Suggestion> sugerencias = manageSuggestion.getSuggestions();
		model.addAttribute("sugerencias", sugerencias);
	}

	public static Suggestion getSeleccionada() {
		return seleccionada;
	}

	public static void setSeleccionada(Suggestion seleccionada) {
		Util.seleccionada = seleccionada;
	}
}