package kg.online_store.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Продукт")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    Long id;

    @Column(name = "name")
    @Schema(description = "названия", example = "компьютер")
    String name;

    @Column(name = "product_picture")
    @Schema(description = "фото продукта", example = "ссылка'")
    String productPicture = "";

    @Column(name = "product_price")
    @Schema(description = "цена", example = "900")
    double productPrice;

    @Column(name = "product_count")
    @Schema(description = "Количество", example = "100")
    int productCount = 0;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "description_id")
    Description description;
}