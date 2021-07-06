package kg.online_store.service.impl;

import kg.online_store.model.Category;
import kg.online_store.repository.CategoryRepository;
import kg.online_store.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @Override
    public Category getCategoryById(long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    @Override
    public Category getCategoryByName(String name) {
        Optional<Category> category = categoryRepository.findCategoryByName(name);
        return category.orElse(null);
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void removeCategoryById(long id) {
        categoryRepository.deleteById(id);
    }
}
