package pSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import pSystem.model.RestringedWords;

public interface RestringedWordsRepository extends JpaRepository<RestringedWords, Long>{

}
