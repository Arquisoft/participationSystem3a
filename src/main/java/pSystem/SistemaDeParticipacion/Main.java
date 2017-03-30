package pSystem.SistemaDeParticipacion;

import pSystem.model.Sugerencia;

public class Main {
	
	public static void main(String[] args) {

		GetSuggestionR r = new GetSuggestionR();
		r.getSuggestion((long) 1);
		Sugerencia s = r.getSugerencia();
		System.out.println(s);
	}

}
