package hello.DBManagement;

import hello.model.Sugerencia;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSuggestion(Sugerencia sugerencia) {
		// TODO Auto-generated method stub
		
	}

}
