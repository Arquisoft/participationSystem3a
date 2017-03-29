package hello.SistemaDeParticipacion;

import java.util.List;

import hello.DBManagement.GetSuggestion;
import hello.DBManagement.GetSuggestionP;
import hello.model.Sugerencia;

public class GetSuggestionR implements GetSuggestion {

	@Override
	public List<Sugerencia> getSuggestions(Long id) {
		return GetSuggestionP.getInstance().getSuggestions(id);
	}
}
