package kg.online_store.service;

import kg.online_store.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    List<Product> findActual();
    List<Product> findCheap();
    List<Product> findExpensive();
    Product findById(long id);
    Product findProductByName(String name);
    void save(Product product);
    void deleteById(long id);
}
