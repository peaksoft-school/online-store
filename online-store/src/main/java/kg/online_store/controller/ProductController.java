package kg.online_store.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.online_store.model.Product;
import kg.online_store.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
@Tag(name = "Контроллер для управления продуктами", description = "***")
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
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    @Operation(summary = "Продукт(id)", description = "Позволяет получить продукт по 'id'")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByName/{name}")
    @Operation(summary = "Продукт(name)", description = "Позволяет получить продукт по имени")
    public ResponseEntity<Product> getByName(@PathVariable String name) {
        try {
            return new ResponseEntity<>(productService.findProductByName(name), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    @Operation(summary = "Добавление продукта", description = "Позволяет добавить новый продукт")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        try {
            productService.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    @Operation(summary = "Удаление продукта", description = "Позволяет удалить продукт")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            productService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
