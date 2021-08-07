package kg.online_store.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "product_picture")
    String productPicture = "";

    @Column(name = "product_price")
    double productPrice;

    @Column(name = "product_count")
    int productCount = 0;

    @Column(name = "rating")
    @NonNull
    @Min(0)
    @Max(5)
    Double rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "description_id")
    Description description;
}