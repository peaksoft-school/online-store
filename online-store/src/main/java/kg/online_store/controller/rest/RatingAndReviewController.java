package kg.online_store.controller.rest;

import kg.online_store.model.Rating;
import kg.online_store.model.User;
import kg.online_store.service.RatingReviewService;
import kg.online_store.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
@CrossOrigin
@AllArgsConstructor
public class RatingAndReviewController {
    private final RatingReviewService reviewService;
    private final UserService userService;



    @PostMapping("/{id}")
    public ResponseEntity<?> saveRatingAndReview(@RequestBody Rating rating, @PathVariable("id") Long productId) {
        try {
            User user = userService.findById(1);
            System.out.println(user.getUsername());
            reviewService.saveRating(rating, productId, (long)1);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
