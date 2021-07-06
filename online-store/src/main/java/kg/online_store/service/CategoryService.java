package kg.online_store.service;

import kg.online_store.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryById(long id);
    Category getCategoryByName(String name);
    void addCategory(Category category);
    void removeCategoryById(long id);
}
