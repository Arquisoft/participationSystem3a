package pSystem.persistence;

import java.util.List;

import pSystem.model.Sugerencia;
import pSystem.persistence.util.Jpa;

public class SuggestionFinder {
	
	public static List<Sugerencia> getAllSugestions(){
		return Jpa.getManager().createNamedQuery("Sugerencia.findAll", Sugerencia.class)
				.getResultList();
	}

}
