package kg.online_store.service.impl;

import kg.online_store.model.Description;
import kg.online_store.repository.DescriptionRepository;
import kg.online_store.service.DescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DescriptionServiceImpl implements DescriptionService {

    private final DescriptionRepository descriptionRepository;

    @Override
    public void save(Description description) {
        descriptionRepository.save(description);
    }

    @Override
    public void deleteById(long id) {
        descriptionRepository.deleteById(id);
    }
}
