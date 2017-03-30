package pSystem.DBManagement;

import pSystem.model.Sugerencia;
import pSystem.persistence.util.Jpa;

public class UpdateSuggestionP implements UpdateSuggestion{
	
	private static UpdateSuggestionP INSTANCE = null;
	
	private UpdateSuggestionP() {
	}
	
	public static UpdateSuggestionP getInstance(){
		if(INSTANCE==null){
			return new UpdateSuggestionP();
		}
		return INSTANCE;
	}

	@Override
	public void addSuggestion(Sugerencia sugerencia) {
		Jpa.getManager().persist(sugerencia);		
	}

	@Override
	public void updateSuggestion(Sugerencia sugerencia) {
		Jpa.getManager().merge(sugerencia);
	}

}
