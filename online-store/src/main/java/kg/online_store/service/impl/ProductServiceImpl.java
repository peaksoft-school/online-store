package kg.online_store.service.impl;

import kg.online_store.model.Category;
import kg.online_store.model.Product;
import kg.online_store.repository.ProductRepository;
import kg.online_store.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAndOrderByRating() {
        return productRepository.findAndOrderByRating()
                .stream()
                .filter(x -> x.getProductCount() >= 1)
                .limit(6)
                .collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }
}
