package pSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pSystem.model.*;

@Repository
public interface SuggestionRepository extends JpaRepository<Sugerencia, Long>{
	Sugerencia findById(Long id);
}
