package hello.SistemaDeParticipacion;

import hello.DBManagement.UpdateSuggestion;
import hello.DBManagement.UpdateSuggestionP;
import hello.model.Sugerencia;

public class UpdateSuggestionR implements UpdateSuggestion {

	@Override
	public void addSuggestion(Sugerencia sugerencia) {
		UpdateSuggestionP.getInstance().addSuggestion(sugerencia);
	}

	@Override
	public void updateSuggestion(Sugerencia sugerencia) {
		UpdateSuggestionP.getInstance().updateSuggestion(sugerencia);
	}
}
