
package kg.online_store.controller;

import kg.online_store.model.ActualProduct;
import kg.online_store.model.Category;
import kg.online_store.model.Product;
import kg.online_store.service.ProductService;
import kg.online_store.service.impl.ActualProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
    private final ProductService productService;
    @Autowired
    private ActualProductServiceImpl actualProductRepository;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        try {
            return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/actual")
    public ResponseEntity<List<Product>> getActualProducts() {
        try {
            List<Product> products = new ArrayList<>();
            List<Product> allProducts = productService.findAll();
            List<ActualProduct> allActualProducts = actualProductRepository.findAll();
            ActualProduct testAc;
            for (int i = 0; i < allActualProducts.size(); i++) {
                for (int j = 0; j < allActualProducts.size()-1; j++) {
                    if(allActualProducts.get(j).getCount()<allActualProducts.get(j+1).getCount()){
                        testAc = allActualProducts.get(j);
                        allActualProducts.set(j,allActualProducts.get(j+1));
                        allActualProducts.set(j+1,testAc);
                    }
                }
            }
            for (int i = 0; i < allActualProducts.size(); i++) {
                for (int j = 0; j < allProducts.size(); j++) {
                    if (allActualProducts.get(i).getProductId() == allProducts.get(j).getId()){
                        products.add(allProducts.get(j));
                    }
                }
            }
            for (int i = 0; i < allActualProducts.size(); i++) {
                for (int j = 0; j < allProducts.size(); j++) {
                    if (allActualProducts.get(i).getProductId() == allProducts.get(j).getId()){
                        allProducts.remove(j);
                    }else {
                    }
                }
            }
            products.addAll(allProducts);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("exception");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        try {
            ActualProduct actualProduct;
            try {
                actualProduct = actualProductRepository.getByProductId(id);
            } catch (Exception e) {
                actualProduct = new ActualProduct(id,0L);

            }
            actualProduct.setCount(actualProduct.getCount()+1);
            actualProductRepository.save(actualProduct);
            return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getByName/{name}")
    public ResponseEntity<Product> getByName(@PathVariable String name) {
        try {
            Product product = productService.findProductByName(name);
            System.out.println(product.getId());
            ActualProduct actualProduct = new ActualProduct(product.getId(), actualProductRepository.getById(product.getId()).getCount());
            actualProductRepository.save(actualProduct);
            return new ResponseEntity<>(productService.findProductByName(name), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        try {
            productService.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            productService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

