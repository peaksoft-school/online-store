package kg.online_store.service;

import kg.online_store.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(long id);
    Product findProductByName(String name);
    void save(Product product);
    void deleteById(long id);
}
