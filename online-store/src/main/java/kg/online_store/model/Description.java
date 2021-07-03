package kg.online_store.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "descriptions")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "product_manufacturer")
    String productManufacturer;

    @Column(name = "product_guarantee")
    String productGuarantee;

    @Column(name = "product_color")
    String productColor;

    @Column(name = "product_dimensions")
    int productDimensions;

    @Column(name = "product_weight")
    double productWeight;
}