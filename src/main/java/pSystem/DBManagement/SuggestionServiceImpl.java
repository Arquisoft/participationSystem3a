package pSystem.DBManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pSystem.model.Sugerencia;
import pSystem.persistence.SuggestionRepository;

public class SuggestionServiceImpl implements SuggestionService {
	
	@Autowired
	private SuggestionRepository sRepository;

	@Override
	public void addSuggestion(Sugerencia sugerencia) {
		sRepository.save(sugerencia);
	}

	@Override
	public void updateSuggestion(Sugerencia sugerencia) {
		sRepository.saveAndFlush(sugerencia);
	}

	@Override
	public List<Sugerencia> getSuggestions() {
		return sRepository.findAll();
	}

	@Override
	public Sugerencia getSuggestion(Long id) {
		return sRepository.findById(id);
	}

}
