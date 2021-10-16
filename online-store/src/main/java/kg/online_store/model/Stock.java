package kg.online_store.model;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel(description = "Акция",value = "Stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name_stock")
    @Schema(description = "Name stock",example = "iphone")
    String name;
    @Column(name = "stock")
    @Schema(description = "Акция ",example = "20%")
    Long stock;
    @Column(name = "stock_time")
    @Schema(description = "stock_time",example = "2021-01-01")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    LocalDate stockTime;
    @Column(name = "stock_price")
    @Schema(description = "Stock price",example = "900")
    Long stockPrice;
    @Column(name = "stock_picture")
    @Schema(description = "Stock_picture",example = "img.png")
    String stockPicture = "";

}
