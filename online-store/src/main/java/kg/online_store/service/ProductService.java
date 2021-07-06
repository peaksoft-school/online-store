package kg.online_store.service;

import kg.online_store.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(String sort);
    Product getProductById(long id);
    Product getProductByName(String name);
    void addProduct(Product product);
    void removeProductById(long id);
}
