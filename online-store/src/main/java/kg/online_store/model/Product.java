package kg.online_store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel(description = "Продукт",value = "Product")
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

    @Column(name = "rating")
    @NonNull
    Double rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "description_id")
    Description description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.EAGER)
    @XmlTransient
    List<Comment> productComments;

//    public List<Comment> addCommentOfProduct(Comment comment) {
//        if (productComments == null) {
//            productComments = new ArrayList<>();
//        }
//        productComments.add(comment);
//        comment.setProduct(this);
//        return productComments;
//    }
}