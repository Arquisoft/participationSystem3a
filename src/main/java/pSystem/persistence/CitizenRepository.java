package pSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pSystem.model.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
	
	/**
	 * Busca un usuario dados su login y contraseña
	 * 
	 * @param login login del usuario
	 * @param password contraseña
	 * @return usuario con ese login y contraseña
	*/
	 @Query("select c from Citizen c where c.email = ?1 and c.user.password = ?2")
	 Citizen findByEmailAndPassword(String email, String password);
	 
	 Citizen findByDni (String dni);
	 
}