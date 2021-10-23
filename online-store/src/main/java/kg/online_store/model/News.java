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

@Getter
@Setter
@Entity
@Table(name = "news1")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel(description = "Новости", value = "News")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name_news")
    @Schema(description = "Name news",example = "iphone")
    String name;

    @Column(name = "news")
    @Schema(description = "Новости ",example = "about new products")
    String news;

    @Column(name = "news_time")
    @Schema(description = "news_time",example = "2021-01-01")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    LocalDate newsTime;

    @Column(name = "news_price")
    @Schema(description = "News price",example = "900")
    Long newsPrice;

    @Column(name = "news_picture")
    @Schema(description = "News picture",example = "img.png")
    String newsPicture = "";

    @Column(name = "news_detail")
    @Schema(description = "News detail",example = "250gb")
    String newsDetail = "";
}
