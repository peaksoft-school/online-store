package kg.online_store.model;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
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
@ApiModel(description = "Description", value = "Description")
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    Long id;

    @Column(name = "product_manufacturer")
    @Schema(description = "производитель", example = "iPhone")
    String productManufacturer;

    @Column(name = "product_guarantee")
    @Schema(description = "гарантия", example = "3 года")
    String productGuarantee;

    @Column(name = "product_color")
    @Schema(description = "цвет", example = "красный")
    String productColor;

    @Column(name = "product_dimensions")
    @Schema(description = "размер", example = "33")
    int productDimensions;

    @Column(name = "product_weight")
    @Schema(description = "вес", example = "600")
    double productWeight;
}