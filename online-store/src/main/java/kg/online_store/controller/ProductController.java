package kg.online_store.controller;
import kg.online_store.model.Product;
import kg.online_store.service.ProductService;
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
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/actual")
    public ResponseEntity<List<Product>> getActualProduct() {
        try {
            return new ResponseEntity<>(productService.getActual(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        try {
            return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        try {
            Product actualProduct;
            try {
                actualProduct = productService.findById(id);
            } catch (Exception e) {
                actualProduct = new Product();
                actualProduct.setId(id);
                actualProduct.setActual(0);
            }
            actualProduct.setActual(actualProduct.getActual()+1);
            productService.save(actualProduct);
            return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getByName/{name}")
    public ResponseEntity<Product> getByName(@PathVariable String name) {
        try {
            Product actualProduct;
            try {
                actualProduct = productService.findById(productService.findProductByName(name).getId());
            } catch (Exception e) {
                actualProduct = new Product();
                actualProduct.setId(productService.findProductByName(name).getId());
                actualProduct.setActual(0);
            }
            actualProduct.setActual(actualProduct.getActual()+1);
            productService.save(actualProduct);
            return new ResponseEntity<>(productService.findProductByName(name), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        try {
            productService.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            productService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}