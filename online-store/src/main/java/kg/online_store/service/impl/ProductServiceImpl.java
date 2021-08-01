package kg.online_store.service.impl;
import kg.online_store.model.Product;
import kg.online_store.repository.ProductRepository;
import kg.online_store.service.ProductService;
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
    public List<Product> findAll() {
        return productRepository.findAll();
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
    @Override
    public List<Product> getActual (){
        List<Product> allProducts = productRepository.findAll();
        Product testPr;
        for (int i = 0; i < allProducts.size(); i++) {
            for (int j = 0; j < allProducts.size()-1; j++) {
                if(allProducts.get(j).getActual()<allProducts.get(j+1).getActual()){
                    testPr = allProducts.get(j);
                    allProducts.set(j,allProducts.get(j+1));
                    allProducts.set(j+1,testPr);
                }
            }
        }
        return allProducts;
    }
}