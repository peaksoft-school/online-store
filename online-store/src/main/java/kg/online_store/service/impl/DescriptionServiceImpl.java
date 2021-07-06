package kg.online_store.service.impl;

import kg.online_store.model.Description;
import kg.online_store.repository.DescriptionRepository;
import kg.online_store.service.DescriptionService;
import org.springframework.stereotype.Service;

@Service
public class DescriptionServiceImpl implements DescriptionService {
    private final DescriptionRepository descriptionRepository;

    public DescriptionServiceImpl(DescriptionRepository descriptionRepository) {
        this.descriptionRepository = descriptionRepository;
    }

    @Override
    public void addDescription(Description description) {
        descriptionRepository.save(description);
    }

    @Override
    public void removeDescriptionById(long id) {
        descriptionRepository.deleteById(id);
    }
}
