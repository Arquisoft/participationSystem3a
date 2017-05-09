package pSystem.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pSystem.business.RestringedWordsService;
import pSystem.model.RestringedWords;
import pSystem.persistence.RestringedWordsRepository;

@Service
public class RestringedWordsImpl implements RestringedWordsService {
	
	@Autowired
	private RestringedWordsRepository wordRepository;

	@Override
	public RestringedWords addRestringedWord(RestringedWords word) {
		return wordRepository.save(word);
	}
	
	@Override
	public List<RestringedWords> findAllWords() {
		return wordRepository.findAll();
	}
}
