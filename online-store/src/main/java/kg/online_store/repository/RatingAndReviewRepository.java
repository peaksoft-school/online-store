package kg.online_store.repository;

import kg.online_store.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingAndReviewRepository extends JpaRepository<Rating,Long> {

}
