//package kg.online_store.model;
//
//
//import io.swagger.annotations.ApiModel;
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
//@Entity
//@Table
//@Data
////@FieldDefaults(level = AccessLevel.PRIVATE)
//@ApiModel(description = "Listing", value = "Listing")
//public class Listing {
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "listings")
//    private List<Rating> ratings;
//
//    @Column
//    private double rating_average;
//
//    public Listing() {
//    }
//
//    @Column(updatable=false)
//    private Date createdAt;
//    @Column
//    private Date updatedAt;}