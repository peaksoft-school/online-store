package kg.online_store.service;

import kg.online_store.model.Rating;
import kg.online_store.model.User;

public interface RatingReviewService {
void saveRating(Rating rating, long id, Long userId);
}
