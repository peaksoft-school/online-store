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
    public List<Product> findActual (){
        List<Product> allProducts = productRepository.findAll();
        Product testPr;
        for (int i = 0; i < allProducts.size(); i++) {
            for (int j = 0; j < allProducts.size()-1; j++) {
                if(allProducts.get(j).getCount()<allProducts.get(j+1).getCount()){
                    testPr = allProducts.get(j);
                    allProducts.set(j,allProducts.get(j+1));
                    allProducts.set(j+1,testPr);
                }
            }
        }
        return allProducts;
    }

    @Override
    public List<Product> findCheap() {
        List<Product> allCheapProducts = productRepository.findAll();
        Product testCheap;
        for (int i = 0; i < allCheapProducts.size(); i++) {
            for (int j = 0; j < allCheapProducts.size()-1; j++) {
                if(allCheapProducts.get(j).getProductPrice()>allCheapProducts.get(j+1).getProductPrice()){
                    testCheap = allCheapProducts.get(j);
                    allCheapProducts.set(j,allCheapProducts.get(j+1));
                    allCheapProducts.set(j+1,testCheap);
                }
            }
        }
        return allCheapProducts;
    }

    @Override
    public List<Product> findExpensive() {
        List<Product> allExpensiveProducts = productRepository.findAll();
        Product testExp;
        for (int i = 0; i < allExpensiveProducts.size(); i++) {
            for (int j = 0; j < allExpensiveProducts.size()-1; j++) {
                if(allExpensiveProducts.get(j).getProductPrice()<allExpensiveProducts.get(j+1).getProductPrice()){
                    testExp = allExpensiveProducts.get(j);
                    allExpensiveProducts.set(j,allExpensiveProducts.get(j+1));
                    allExpensiveProducts.set(j+1,testExp);
                }
            }
        }
        return allExpensiveProducts;
    }
}
