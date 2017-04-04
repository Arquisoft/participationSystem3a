package pSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import pSystem.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
