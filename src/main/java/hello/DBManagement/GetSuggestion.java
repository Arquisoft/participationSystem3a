package hello.DBManagement;

import java.util.List;

import hello.model.Sugerencia;

public interface GetSuggestion {
	
	public List<Sugerencia> getSuggestions(Long id);
}
