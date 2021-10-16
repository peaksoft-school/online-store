package kg.online_store.service.impl;

import kg.online_store.model.News;
import kg.online_store.repository.NewsRepository;
import kg.online_store.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> findAllNews() {
        List<News> newsList = newsRepository.findAll();
        List<News> news = new ArrayList<>();
        int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime()));
        int month = Integer.parseInt(new SimpleDateFormat("MM").format(Calendar.getInstance().getTime()));
        int date = Integer.parseInt(new SimpleDateFormat("dd").format(Calendar.getInstance().getTime()));
        for (News stock: newsList) {
            if(stock.getNewsTime().getYear() > year){
                news.add(stock);
            }else if(stock.getNewsTime().getYear() == year && stock.getNewsTime().getMonth().getValue() > month){
                news.add(stock);
            }else if(stock.getNewsTime().getYear() == year && stock.getNewsTime().getMonth().getValue() == month
                    && stock.getNewsTime().getDayOfMonth() >= date){
                news.add(stock);
            }
        }
        return news;
    }


    @Override
    public News findById(Long id) {
        return newsRepository.findById(id).get();
    }

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }

    @Override
    public void deleteById(Long id) {
        newsRepository.deleteById(id);
    }



}
