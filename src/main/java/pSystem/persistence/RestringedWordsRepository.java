package pSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pSystem.model.RestringedWords;

@Repository
public interface RestringedWordsRepository extends JpaRepository<RestringedWords, Long>{

}