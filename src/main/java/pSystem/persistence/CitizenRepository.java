package pSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pSystem.model.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

}
