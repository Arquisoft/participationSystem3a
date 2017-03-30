package pSystem.DBManagement;

import java.util.List;

import pSystem.model.Sugerencia;
import pSystem.util.BusinessException;

public interface GetSuggestion {
	
	public List<Sugerencia> getSuggestions() throws BusinessException;
	public Sugerencia getSuggestion(Long id) throws BusinessException;
}
