package kg.online_store.repository;

import kg.online_store.model.ActualProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActualProductRepository extends JpaRepository<ActualProduct,Long> {
}
