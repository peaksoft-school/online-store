package kg.online_store.service.impl;

import kg.online_store.model.ActualProduct;
import kg.online_store.repository.ActualProductRepository;
import kg.online_store.service.ActualProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActualProductServiceImpl implements ActualProductService {

    private final ActualProductRepository actualProductRepository;

    @Autowired
    public ActualProductServiceImpl(ActualProductRepository actualProductRepository) {
        this.actualProductRepository = actualProductRepository;
    }

    @Override
    public void save(ActualProduct a) {
        actualProductRepository.save(a);
    }

    @Override
    public ActualProduct getById(Long id) {
        return actualProductRepository.getById(id);
    }

    @Override
    public ActualProduct getByProductId(Long id) {
        List<ActualProduct> actualProductList = actualProductRepository.findAll();
        for (int i = 0; i < actualProductList.size(); i++) {
            if (id == actualProductList.get(i).getProductId()) {
                return actualProductList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<ActualProduct> findAll() {
        return actualProductRepository.findAll();
    }

}
