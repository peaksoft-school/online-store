package kg.online_store.service.impl;

import kg.online_store.model.Stock;
import kg.online_store.repository.StockRepository;
import kg.online_store.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    @Override
    public List<Stock> findAllStock() {
        List<Stock> stockList = stockRepository.findAll();
        List<Stock> stocks = new ArrayList<>();
        Integer year = Integer.valueOf(new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime()));
        Integer month = Integer.valueOf(new SimpleDateFormat("MM").format(Calendar.getInstance().getTime()));
        Integer date = Integer.valueOf(new SimpleDateFormat("dd").format(Calendar.getInstance().getTime()));
        for (Stock stock: stockList) {
               if(stock.getStockTime().getYear() > year){
                   stocks.add(stock);
               }else if(stock.getStockTime().getYear() == year && stock.getStockTime().getMonth().getValue() > month){
                   stocks.add(stock);
               }else if(stock.getStockTime().getYear() == year && stock.getStockTime().getMonth().getValue() == month
                       && stock.getStockTime().getDayOfMonth() >= date){
                   stocks.add(stock);
               }
        }
        return stocks;
    }

    @Override
    public Stock findById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Stock stock) {
           stockRepository.save(stock);
    }

    @Override
    public void deleteById(Long id) {
          stockRepository.deleteById(id);
    }
}
