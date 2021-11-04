//package kg.online_store.service.impl;
//
//import kg.online_store.model.Listing;
//import kg.online_store.model.Rating;
//import kg.online_store.model.User;
//import kg.online_store.repository.ListingRepository;
//import kg.online_store.repository.RatingAndReviewRepository;
//import kg.online_store.service.ListingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//public class ListingServiceImpl implements ListingService {
//        @Autowired
//        private ListingRepository listingRepository;
//
//        @Autowired
//        private RatingAndReviewRepository ratingRepository;
//
//        @Override
//        public void saveListing(Listing listing, User users){
//            listing.setUser(users);
//            listing.setRating_average(avgRating(listing.getId()));
//            listingRepository.save(listing);
//        }
//
//        @Override
//        public List<Listing> findAll(){
//            return listingRepository.findAll();
//
//        }
//
//
//    @Override
//        public Listing findById(long id){
//            return listingRepository.findById(id);
//        }
//
//        @Override
//        public void addReviewToListing(Rating rating, long id){
//           Listing listing = listingRepository.findById(id);
//            List<Rating> ratings = listing.getRatings();
//            List<Listing> listings = rating.getListings();
//            ratings.add(rating);
//            listing.setRating_average(avgRating(id));
//            listings.add(listing);
//
//            listingRepository.save(listing);
//            ratingRepository.save(rating);
//
//        }
//
//        public double avgRating(long id){
//            double intTotal = 0;
//
//            List<Rating> ratings = listingRepository.findById(id).getRatings();
//
//            for(int i=0;i<ratings.size();i++){
//                intTotal += ratings.get(i).getRating();
//            }
//
//            double avgRating = intTotal / ratings.size();
//
//
//            Listing listing = listingRepository.findById(id);
//            listing.setRating_average(avgRating);
//            listingRepository.save(listing);
//
//            return avgRating;
//        }
//
//
//    }
//
