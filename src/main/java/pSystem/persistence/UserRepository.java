package pSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pSystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u WHERE u.usuario = :usuario and u.contraseña = :contraseña")
	User findByUserAndPassword(@Param("usuario") String usuario, @Param("contraseña") String contraseña);

}