package kg.online_store.service.impl;

import kg.online_store.model.Product;
import kg.online_store.repository.ProductRepository;
import kg.online_store.service.ProductService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll(String sort) {
        Sort sortProducts  = Sort.by(sort);
        return productRepository.findAll(sortProducts);
    }

    @Override
    public Product findById(long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public Product findProductByName(String name) {
        Optional<Product> product = productRepository.findProductByName(name);
        return product.orElse(null);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}
