package pSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import pSystem.model.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {

}
