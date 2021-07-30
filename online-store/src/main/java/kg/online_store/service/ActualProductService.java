package kg.online_store.service;

import kg.online_store.model.ActualProduct;

import java.util.List;

public interface ActualProductService {
    public void save(ActualProduct a);
    public ActualProduct getById(Long id);
    public ActualProduct getByProductId(Long id);
    public List<ActualProduct> findAll();

}
