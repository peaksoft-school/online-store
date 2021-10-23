package kg.online_store.controller.rest;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import kg.online_store.model.Stock;
import kg.online_store.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/stocks")
@Api(description = "контроллер для управления Акция")
public class StockController {
    @Autowired
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
    @GetMapping()
    @Operation(summary = "все акции",description = "Позволяет получить всех акции из база данных")
    public ResponseEntity<List<Stock>> findAllStock(){
     List<Stock> stockList = stockService.findAllStock();
        try{
            return new ResponseEntity<>(stockService.findAllStock(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/add")
    @Operation(summary = "Save stock",description = "Save stock")
    public ResponseEntity<?> saveStock(@RequestBody Stock stock){
        try{
            stockService.save(stock);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/post")
    @Operation(summary = "Акция(id)",description = "Позволяеть получить акция по id")
    public ResponseEntity<Stock> findById(@PathVariable Long id){
        try{
            return new ResponseEntity<>(stockService.findById(id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete")
    @Operation(summary = "Delete stock",description = "Позволяеть удалить акция")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        try {
            stockService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        }
    }