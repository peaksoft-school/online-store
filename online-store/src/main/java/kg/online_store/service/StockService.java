package kg.online_store.service;

import kg.online_store.model.Stock;

import java.util.List;

public interface StockService {
    List<Stock> findAllStock();
    Stock findById(Long id);
    void save(Stock stock);
    void deleteById(Long id);
}
