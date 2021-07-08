package kg.online_store.service;

import kg.online_store.model.Description;

import java.util.List;

public interface DescriptionService {
    void save(Description description);
    void deleteById(long id);
}
