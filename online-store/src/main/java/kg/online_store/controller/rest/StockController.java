package kg.online_store.controller.rest;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kg.online_store.model.Stock;
import kg.online_store.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@Api(description = "контроллер для управления Акция")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping
    @Operation(summary = "все акции", description = "Позволяет получить всех акции из база данных")
    public ResponseEntity<List<Stock>> findAllStock() {
        try {
            return new ResponseEntity<>(stockService.findAllStock(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    @Operation(summary = "Save stock", description = "Save stock")
    public ResponseEntity<?> insert(@RequestBody Stock stock) {
        try {
            stockService.save(stock);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Акция(stockId)", description = "Позволяеть получить акцию по stockId")
    public ResponseEntity<Stock> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(stockService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete stock", description = "Позволяеть удалить акция")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            stockService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}