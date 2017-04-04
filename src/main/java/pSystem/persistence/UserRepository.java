package pSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pSystem.model.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{

}
