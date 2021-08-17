package kg.online_store.controller.rest;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import kg.online_store.model.Category;
import kg.online_store.model.Product;
import kg.online_store.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
@Api(description = "Контроллер для управления продуктами")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Operation(summary = "Все продукты", description = "Позволяет получить все продукты из базы данных")
    public ResponseEntity<List<Product>> getAllProduct() {
        try {
            return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
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
    @Operation(summary = "Удаление продукта", description = "Позволяет удалить продукт")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            productService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/order-by-rating")
    public ResponseEntity<List<Product>> getActualProduct() {
        try {
            return new ResponseEntity<>(productService.findAndOrderByRating(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
