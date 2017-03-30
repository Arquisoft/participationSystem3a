package pSystem.SistemaDeParticipacion;

import java.util.List;

import pSystem.DBManagement.GetSuggestion;
import pSystem.DBManagement.GetSuggestionP;
import pSystem.business.command.Command;
import pSystem.business.command.CommandExecutor;
import pSystem.model.Sugerencia;
import pSystem.util.BusinessException;

public class GetSuggestionR implements GetSuggestion {
	
	private Sugerencia sugerencia;
	private List<Sugerencia> lista;

	@Override
	public List<Sugerencia> getSuggestions() {
		try {
			new CommandExecutor<List<Sugerencia>>().execute(new Command<List<Sugerencia>>() {
				@Override
				public List<Sugerencia> execute() throws BusinessException {										
					lista = GetSuggestionP.getInstance().getSuggestions();
					return lista;
				}
			});
		} catch (BusinessException e) {
		}
		return null;
	}

	@Override
	public Sugerencia getSuggestion(Long id) {
		try {
			new CommandExecutor<Sugerencia>().execute(new Command<Sugerencia>() {
				@Override
				public Sugerencia execute() throws BusinessException {										
					sugerencia = GetSuggestionP.getInstance().getSuggestion(id);
					return sugerencia;
				}
			});
		} catch (BusinessException e) {
		}
		return null;
	}
	
	public Sugerencia getSugerencia(){
		return sugerencia;
	}
	
	public List<Sugerencia> getSugerencias(){
		return lista;
	}
}
