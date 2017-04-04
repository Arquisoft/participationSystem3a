package pSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import pSystem.model.VotoComentario;
import pSystem.model.VotoComentarioKey;

public interface VotoComentarioRepository extends JpaRepository<VotoComentario, VotoComentarioKey> {

}
