package hello.DBManagement;

import java.util.List;

import hello.model.Sugerencia;

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
	public List<Sugerencia> getSuggestions(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
