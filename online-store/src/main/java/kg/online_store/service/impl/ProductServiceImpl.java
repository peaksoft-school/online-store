package kg.online_store.service.impl;

import kg.online_store.model.Product;
import kg.online_store.model.Rating;
import kg.online_store.repository.ProductRepository;
import kg.online_store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

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

    @Override
    public double avgRating(long id){
        double intTotal = 0;

        List<Rating> ratings = productRepository.findById(id).getRatings();

        for(int i=0;i<ratings.size();i++){
            intTotal += ratings.get(i).getRating();
        }

        double avgRating = intTotal / ratings.size();


       Product product = productRepository.findById(id);
        product.setRating_average(avgRating);
        productRepository.save(product);

        return avgRating;
    }

}
