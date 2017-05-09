package pSystem.business;

import java.util.List;

import pSystem.model.RestringedWords;

public interface RestringedWordsService {
	
	public RestringedWords addRestringedWord(RestringedWords word);
	public List<RestringedWords> findAllWords();
}
