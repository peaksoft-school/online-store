package kg.online_store.service;

import kg.online_store.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    List<News> findAllNews();
    News findById(Long id);
    void save(News news);
    void deleteById(Long id);
}
