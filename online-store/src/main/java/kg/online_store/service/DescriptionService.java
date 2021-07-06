package kg.online_store.service;

import kg.online_store.model.Description;

import java.util.List;

public interface DescriptionService {
    void addDescription(Description description);
    void removeDescriptionById(long id);
}
