package pSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pSystem.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
