package pSystem.SistemaDeParticipacion;

import pSystem.DBManagement.UpdateSuggestion;
import pSystem.DBManagement.UpdateSuggestionP;
import pSystem.business.command.Command;
import pSystem.business.command.CommandExecutor;
import pSystem.model.Sugerencia;
import pSystem.util.BusinessException;

public class UpdateSuggestionR implements UpdateSuggestion {

	@Override
	public void addSuggestion(Sugerencia sugerencia) {
		try {
			new CommandExecutor<Void>().execute(new Command<Void>() {
				@Override
				public Void execute() throws BusinessException {										
					UpdateSuggestionP.getInstance().addSuggestion(sugerencia);
					return null;					
				}
			});
		} catch (BusinessException e) {
		}
	}

	@Override
	public void updateSuggestion(Sugerencia sugerencia) {
		try {
			new CommandExecutor<Void>().execute(new Command<Void>() {
				@Override
				public Void execute() throws BusinessException {										
					UpdateSuggestionP.getInstance().updateSuggestion(sugerencia);
					return null;					
				}
			});
		} catch (BusinessException e) {
		}
	}
}
