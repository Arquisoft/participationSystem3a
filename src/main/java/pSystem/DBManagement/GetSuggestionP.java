package pSystem.DBManagement;

import java.util.List;

import pSystem.model.Sugerencia;
import pSystem.persistence.SuggestionFinder;
import pSystem.persistence.util.Jpa;
import pSystem.util.BusinessException;

public class GetSuggestionP implements GetSuggestion {
	
	private static GetSuggestionP INSTANCE = null;
	
	private GetSuggestionP(){
	}
	
	public static GetSuggestionP getInstance(){
		if(INSTANCE==null){
			return new GetSuggestionP();
		}
		return INSTANCE;
	}

	@Override
	public List<Sugerencia> getSuggestions() throws BusinessException {
		List<Sugerencia> sugerencias = SuggestionFinder.getAllSugestions();
		if(sugerencias==null){
			throw new BusinessException("No hay sugerencias");
		}
		return sugerencias;
	}

	@Override
	public Sugerencia getSuggestion(Long id) throws BusinessException {
		Sugerencia sugerencia = Jpa.getManager().find(Sugerencia.class, id);
		if(sugerencia==null){
			throw new BusinessException("No existe la sugerencia con id=" + id);
		}
		return sugerencia;
	}

}
