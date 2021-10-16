package kg.online_store.config;

import kg.online_store.model.*;
import kg.online_store.service.CategoryService;
import kg.online_store.service.NewsService;
import kg.online_store.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * класс первичного заполнения таблиц.
 * для первичного заполнения базы данных раскомментировать аннотацию
 * "@PostConstruct" и поменять значение  ключа "spring.jpa.hibernate.ddl-auto"
 * в файле "application.yml" с "update" на "create" или "create-drop".
 */
@Component
public class DataInitializer {

    private final CategoryService categoryService;
    private final UserService userService;
    private final NewsService newsService;

    public DataInitializer(CategoryService categoryService,
                           UserService userService,
                           NewsService newsService) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.newsService = newsService;
    }

    /**
     * Основной метод для заполнения базы данных.
     * Вызов методов добавлять в этод метод.
     * Следить за последовательностью вызова.
     */
    @PostConstruct
//    раскомментировать аннотацию при первом запуске проекта для создания таблиц БД, потом закомментировать
    public void initDataBaseFilling() {
        productsAndCategoriesInit();
        usersAndRolesInit();
        addNewsInit();
    }

    private void addNewsInit() {
        News news = new News();
        news.setName("Телевизор Xiaomi Mi LED TV 4s (2+8Гб) 50&quot");
        news.setNews("OUR NEW PRODUCTS FROM USA");
        LocalDate localTime =LocalDate.of(2021,10,18);
        news.setNews_time(localTime);
        news.setNews_price(115000L);
        news.setNews_picture("https://softech.kg/image/cache/28c69713d2de5da607c545d43476a345.jpg");
        newsService.save(news);
        news.setNews_detail("Операционная система: Android TV . Тип процессора: Cortex A53");

        News news1 = new News();
        news1.setName("Apple IPhone 13");
        news1.setNews("MOBILE TECHNOLOGIES (Apple)");
        LocalDate localTime1 =LocalDate.of(2021,10,20);
        news1.setNews_time(localTime);
        news1.setNews_price(90000L);
        news1.setNews_picture("https://softech.kg/image/cache/58c23d1f61e4dbc4de648b66965a00dd.png");
        newsService.save(news1);
        news.setNews_detail("Операционная система : iOS 15 .  Количество ядер : 6--128/256/512");

    }

    private void productsAndCategoriesInit() {
        Product iPhone12 = new Product();
        iPhone12.setName("iPhone 12 Pro Max");
        iPhone12.setRating(3.7);
        iPhone12.setProductCount(15);
        iPhone12.setProductPrice(100182);
        iPhone12.setProductPicture("https://www.mytrendyphone.eu/images/iPhone-12-Pro-Max-128GB-Graphite-0194252021200-25102020-1-p.jpg");

        Description descriptionIPhone12 = new Description();
        descriptionIPhone12.setProductColor("Silver");
        descriptionIPhone12.setProductDimensions(160);
        descriptionIPhone12.setProductGuarantee("Apple One (1) Year Limited Warranty for Apple\n" +
                "-branded Products Only");
        descriptionIPhone12.setProductManufacturer("Assembled in China");
        descriptionIPhone12.setProductWeight(226);

        iPhone12.setDescription(descriptionIPhone12);

        Product iPhone11 = new Product();
        iPhone11.setName("iPhone 11 Pro");
        iPhone11.setRating(4.8);
        iPhone11.setProductCount(13);
        iPhone11.setProductPrice(75561);
        iPhone11.setProductPicture("https://cdn.alzashop.com/Foto/f16/RI/RI029b1.jpg");

        Description descriptionIPhone11 = new Description();
        descriptionIPhone11.setProductColor("Gold ");
        descriptionIPhone11.setProductDimensions(144);
        descriptionIPhone11.setProductGuarantee("Apple One (1) Year Limited Warranty for Apple\n" +
                "-branded Products Only");
        descriptionIPhone11.setProductManufacturer("Assembled in China");
        descriptionIPhone11.setProductWeight(188);

        iPhone11.setDescription(descriptionIPhone11);

        Product macBookProI9 = new Product();
        macBookProI9.setName("MacBook Pro i9 - 1 ТБ");
        macBookProI9.setRating(4.3);
        macBookProI9.setProductCount(25);
        macBookProI9.setProductPrice(241965);
        macBookProI9.setProductPicture("https://asiastore.kg/image/cache/catalog/mac/macbook/pro/191114150007894631-670x540.png");

        Description descriptionMacBookProI9 = new Description();
        descriptionMacBookProI9.setProductColor("Space Gray");
        descriptionMacBookProI9.setProductDimensions(35);
        descriptionMacBookProI9.setProductGuarantee("Apple One (1) Year Limited Warranty for Apple\n" +
                "-branded Products Only");
        descriptionMacBookProI9.setProductManufacturer("Assembled in China");
        descriptionMacBookProI9.setProductWeight(2);

        macBookProI9.setDescription(descriptionMacBookProI9);

        Product refrigerator = new Product();
        refrigerator.setName("Холодильник Indesit DS 316 W");
        refrigerator.setRating(3.5);
        refrigerator.setProductCount(12);
        refrigerator.setProductPrice(21290);
        refrigerator.setProductPicture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSUuqtXCfN6yyeSALZ4HQIO8oAF0z5NeHF9Q&usqp=CAU");

        Description descriptionRefrigerator = new Description();
        descriptionRefrigerator.setProductColor("White");
        descriptionRefrigerator.setProductDimensions(167);
        descriptionRefrigerator.setProductGuarantee("3 years official warranty");
        descriptionRefrigerator.setProductManufacturer("Whirlpool Corporation");
        descriptionRefrigerator.setProductWeight(58);

        refrigerator.setDescription(descriptionRefrigerator);

        Product washingMachineLG = new Product();
        washingMachineLG.setName("Стиральная машина LG");
        washingMachineLG.setRating(3.9);
        washingMachineLG.setProductCount(14);
        washingMachineLG.setProductPrice(29000);
        washingMachineLG.setProductPicture("https://object.pscloud.io/cms/cms/Photo/img_0_8_629_0.png");

        Description washingMachineLGDescription = new Description();
        washingMachineLGDescription.setProductColor("тёмно-серый");
        washingMachineLGDescription.setProductDimensions(40);
        washingMachineLGDescription.setProductGuarantee("Гарантия: 3 года");
        washingMachineLGDescription.setProductManufacturer("Страна Россия");
        washingMachineLGDescription.setProductWeight(74);

        washingMachineLG.setDescription(washingMachineLGDescription);

        Product tv = new Product();
        tv.setName("LED ТЕЛЕВИЗОР BBK 32 LEX-7289");
        tv.setRating(3.1);
        tv.setProductCount(8);
        tv.setProductPrice(15000);
        tv.setProductPicture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcjpYci9bUHwcOVN1_1yvdgaHt_rhzLSF-MQ&usqp=CAU");

        Description tvDescription = new Description();
        tvDescription.setProductColor("серый");
        tvDescription.setProductDimensions(64);
        tvDescription.setProductGuarantee("Гарантия: 1 год");
        tvDescription.setProductManufacturer("Страна Узбекистан");
        tvDescription.setProductWeight(12);

        tv.setDescription(tvDescription);

        List<Product> productListTechnology = new ArrayList<>();
        productListTechnology.add(iPhone12);
        productListTechnology.add(iPhone11);
        productListTechnology.add(macBookProI9);

        Category categoryTechnology = new Category();
        categoryTechnology.setName("Technologies");
        categoryTechnology.setProducts(productListTechnology);
        categoryService.save(categoryTechnology);

        List<Product> productListWashingMachine = new ArrayList<>();
        productListWashingMachine.add(washingMachineLG);

        Category categoryWashingMachine = new Category();
        categoryWashingMachine.setName("Washing Machines");
        categoryWashingMachine.setProducts(productListWashingMachine);
        categoryService.save(categoryWashingMachine);

        List<Product> productListRefrigerator = new ArrayList<>();
        productListRefrigerator.add(refrigerator);

        Category categoryRefrigerator = new Category();
        categoryRefrigerator.setName("Refrigerators");
        categoryRefrigerator.setProducts(productListRefrigerator);
        categoryService.save(categoryRefrigerator);

        List<Product> productListTV = new ArrayList<>();
        productListTV.add(tv);

        Category categoryTV = new Category();
        categoryTV.setName("TV");
        categoryTV.setProducts(productListTV);
        categoryService.save(categoryTV);
    }


    private void usersAndRolesInit() {
        User user = new User();
        user.setUsername("user");
        user.setLastName("userov");
        user.setEmail("user@gmail.com");
        user.setPassword("$2a$12$X9w1iOGDuiI0bIh.juTHue4OfhZH0Md2v5kKaCX2SiuQqPqqkV0Re");
        user.setGender("Male");
        user.setPhoneNumber("0705250086");
        user.setProfilePicture("https://24.kg/files/media/205/205233.jpg");

        LocalDate birthDate = LocalDate.of(1989, 6, 1);
        user.setBirthDate(birthDate);

        LocalDate registerDate = LocalDate.now();
        user.setRegisterDate(registerDate);

        Role role = new Role();
        role.setName("ROLE_USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        user.setRoles(roleSet);

        userService.save(user);


        User admin = new User();
        admin.setUsername("admin");
        admin.setLastName("adminov");
        admin.setEmail("admin@gmail.com");
        admin.setPassword("$2a$12$X9w1iOGDuiI0bIh.juTHue4OfhZH0Md2v5kKaCX2SiuQqPqqkV0Re");
        admin.setGender("Male");
        admin.setPhoneNumber("0705250086");
        admin.setProfilePicture("https://24.kg/files/media/205/205233.jpg");

        LocalDate birthDateAdmin = LocalDate.of(1989, 6, 1);
        admin.setBirthDate(birthDateAdmin);

        LocalDate registerDateAdmin = LocalDate.now();
        admin.setRegisterDate(registerDateAdmin);


        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        Set<Role> roles = new HashSet<>();
        roles.add(roleAdmin);

        admin.setRoles(roles);

        userService.save(admin);
    }
}
