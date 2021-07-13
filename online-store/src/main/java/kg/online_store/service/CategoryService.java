package kg.online_store.service;

import kg.online_store.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Category findById(long id);
    Category findCategoryByName(String name);
    void save(Category category);
    void deleteById(long id);
}
