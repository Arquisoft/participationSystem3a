package pSystem.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pSystem.business.CategoryService;
import pSystem.model.Category;
import pSystem.persistence.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Category category) {
		categoryRepository.delete(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public Category findCategory(Long categoryId) {
		return categoryRepository.findOne(categoryId);
	}

	@Override
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}
	
}