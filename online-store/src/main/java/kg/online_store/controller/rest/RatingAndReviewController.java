package kg.online_store.controller.rest;

import kg.online_store.model.Rating;
import kg.online_store.model.User;
import kg.online_store.repository.RatingAndReviewRepository;
import kg.online_store.service.ProductService;
import kg.online_store.service.RatingReviewService;
import kg.online_store.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rating")
@CrossOrigin
@AllArgsConstructor
public class RatingAndReviewController {
    private final RatingReviewService reviewService;
    private final UserService userService;

//    private ProductSer


    @Autowired
    private ProductService productService;

    @Autowired
    RatingAndReviewRepository r;


    @PostMapping("/{id}")
    public ResponseEntity<?> saveRatingAndReview(@RequestBody Rating rating, @PathVariable("id") Long productId, Principal p) {
        try {
            User user = userService.findUserByUsername(p.getName());
            boolean isFalse = false;
            user.getRatings();
            for (Rating r:user.getRatings()) {
                System.out.println(r.getId());
                if (r.getProduct().getId()==productId){

                    isFalse =true;
                    break;
                }
            }
//            new kg.online_store.model.Product()
//
//            long userId = user.getId();
//            List<Rating> ratings = userService.findById(userId).getRatings();

            System.out.println();
            System.out.println();
            System.out.println(productId);
            if (!isFalse) {

//                ratings = null;

                reviewService.saveRating(rating, productId, user.getId());
            }
//            User us = userService.findById(userId);
//            us.setRatings(ratings);

//            if (ratings != null) {
//            }


//            reviewService.
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> saveRatingAndReview2(@PathVariable("id") Long productId) {
        try {

            Rating ra = new Rating();
            double test = productService.avgRating(productId);
            try {

            } catch (Exception e) {

            }
            ra.setRating(test);
            return new ResponseEntity<>(ra, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> saveRatingAndReview3(@PathVariable("id") Long userId, Principal p) {
        try {
            userId = userService.findUserByUsername(p.getName()).getId();
            List<Rating> ratings = userService.findById(userId).getRatings();
            if (userService.findById(userId).getRatings().size() == 0) {
                ratings = null;
            }
            User us = userService.findById(userId);
            us.setRatings(ratings);
            System.out.println(userService.findById(userId).getRatings().size());
            User user = userService.findUserByUsername(p.getName());

            System.out.println(user.getRatings().size());
            System.out.println();
            if (user.getRatings().size() > 0)
                return new ResponseEntity<>(us, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }
//  @GetMapping("ratings")
//    public ResponseEntity<List<Rating>> getAllRating() {
//
//      try {
//          List<Rating> ratings=r.findAll();
//  return new ResponseEntity<>(ratings,HttpStatus.OK);
//      }catch (Exception e){
//          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//      }
//  }

}
