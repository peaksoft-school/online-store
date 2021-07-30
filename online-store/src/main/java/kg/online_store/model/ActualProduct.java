package kg.online_store.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;

@Entity
@Table(name = "actual_product")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActualProduct {
    @Id
    @Column(name = "actual_product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_id")
   private Long productId;
    @Column(name = "count")
    private Long count;


    public ActualProduct(Long productId, Long count) {
        this.productId = productId;
        this.count = count;
    }
}



