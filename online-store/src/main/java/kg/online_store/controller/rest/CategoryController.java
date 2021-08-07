package kg.online_store.controller.rest;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import kg.online_store.model.Category;
import kg.online_store.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin
@Api(description = "Контроллер для категорий")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @Operation(summary = "Все категории", description = "Позволяет получить все категории из базы данных")
    public ResponseEntity<List<Category>> getAll() {
        try {
            return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    @Operation(summary = "Категория(id)", description = "Позволяет получить категорию по 'id'")
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getByName/{name}")
    @Operation(summary = "Категория(name)", description = "Позволяет получить категорию по имени")
    public ResponseEntity<Category> getByName(@PathVariable String name) {
        try {
            return new ResponseEntity<>(categoryService.findCategoryByName(name), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    @Operation(summary = "Добавление категории", description = "Позволяет добавить новую категорию")
    public ResponseEntity<?> saveCategory(@RequestBody Category category) {
        try {
            categoryService.save(category);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    @Operation(summary = "Удаление категории", description = "Позволяет удалить категорию")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            categoryService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
