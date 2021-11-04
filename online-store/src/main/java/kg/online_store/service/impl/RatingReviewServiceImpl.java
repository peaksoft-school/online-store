package kg.online_store.service.impl;

import kg.online_store.model.Product;
import kg.online_store.model.Rating;
import kg.online_store.model.User;
import kg.online_store.repository.ProductRepository;
import kg.online_store.repository.RatingAndReviewRepository;
import kg.online_store.repository.UserRepository;
import kg.online_store.service.ProductService;
import kg.online_store.service.RatingReviewService;
import kg.online_store.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingReviewServiceImpl implements RatingReviewService {

    private final RatingAndReviewRepository ratingAndReviewRepository;
    private final ProductService productService;
    private final UserService userService;

    public RatingReviewServiceImpl(RatingAndReviewRepository ratingAndReviewRepository, ProductService productService, UserService userService) {
        this.ratingAndReviewRepository = ratingAndReviewRepository;
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public void saveRating(Rating rating, long id, Long userId) {
        try {
            rating.setProduct(productService.findById(id));
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            User user = (User) authentication.getPrincipal();
//            System.out.println(user.getLastName());
            rating.setUser(userService.findById(id));
            ratingAndReviewRepository.save(rating);
            System.out.println(rating);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }


}
