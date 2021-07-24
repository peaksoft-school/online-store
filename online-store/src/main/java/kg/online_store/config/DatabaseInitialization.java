package kg.online_store.config;

import kg.online_store.model.*;
import kg.online_store.service.CategoryService;
import kg.online_store.service.ProductService;
import kg.online_store.service.UserService;
import org.springframework.boot.CommandLineRunner;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DatabaseInitialization implements CommandLineRunner {

    private final ProductService productService;

    private final CategoryService categoryService;

    private final UserService userService;

    public DatabaseInitialization(ProductService productService, CategoryService categoryService, UserService userService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.userService = userService;
    }


    /**
     * Метод для инициализация базы данных
     * развлекательные и информационные устройства а также бытовые техники
     *
     * @return Product
     */

//    Эта аннотация нужна только при первом запуске приложения.
//    @PostConstruct
    private Product initializationProduct() {
        Product iPhone12 = new Product();
        iPhone12.setName("iPhone 12 Pro Max");
        iPhone12.setProductCount(15);
        iPhone12.setProductPrice(100182);
        iPhone12.setProductPicture("https://istore.kg/catalog/product/12-pro-max");

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
        iPhone11.setProductCount(13);
        iPhone11.setProductPrice(75561);
        iPhone11.setProductPicture("https://istore.kg/catalog/product/11-pro");

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
        macBookProI9.setProductCount(25);
        macBookProI9.setProductPrice(241965);
        macBookProI9.setProductPicture("https://istore.kg/catalog/product/Pro-16-1");

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
        refrigerator.setProductCount(12);
        refrigerator.setProductPrice(21290);
        refrigerator.setProductPicture("https://www.technodom.kg/catalog/kholodilniki/p/holodilnik-indesit-ds--w-56558");

        Description descriptionRefrigerator = new Description();
        descriptionRefrigerator.setProductColor("White");
        descriptionRefrigerator.setProductDimensions(167);
        descriptionRefrigerator.setProductGuarantee("3 years official warranty");
        descriptionRefrigerator.setProductManufacturer("Whirlpool Corporation");
        descriptionRefrigerator.setProductWeight(58);

        refrigerator.setDescription(descriptionRefrigerator);

        Product washingMachineLG = new Product();
        washingMachineLG.setName("Стиральная машина LG");
        washingMachineLG.setProductCount(14);
        washingMachineLG.setProductPrice(29000);
        washingMachineLG.setProductPicture("https://www.tabilga.kg/stiralnaja-mashina-lg-7-kg-6/");

        Description washingMachineLGDescription = new Description();
        washingMachineLGDescription.setProductColor("тёмно-серый");
        washingMachineLGDescription.setProductDimensions(40);
        washingMachineLGDescription.setProductGuarantee("Гарантия: 3 года");
        washingMachineLGDescription.setProductManufacturer("Страна Россия");
        washingMachineLGDescription.setProductWeight(74);

        washingMachineLG.setDescription(washingMachineLGDescription);

        Product tv = new Product();
        tv.setName("LED ТЕЛЕВИЗОР BBK 32 LEX-7289");
        tv.setProductCount(8);
        tv.setProductPrice(15000);
        tv.setProductPicture("https://kupi.kg/catalog/tv_video_audio_v_bishkeke/led_lcd_televizori/i_13034_led_televizor_bbk_32_lex_7289");

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

        return iPhone12;
    }


    /**
     * Метод для инициализация базы данных пользователями
     *
     * @return User
     */
//    Эта аннотация нужна только при первом запуске приложения.
//    @PostConstruct
    private User initializationUser() {
        User user = new User();
        user.setUsername("user");
        user.setLastName("userov");
        user.setEmail("user@gmail.com");
        user.setPassword("2");
        user.setGender("Male");
        user.setPhoneNumber("0705250086");
        user.setProfilePicture("D:\\FFOutput");

        LocalDate birthDate = LocalDate.of(1989, 6, 1);
        user.setBirthDate(birthDate);

        LocalDate registerDate = LocalDate.now();
        user.setRegisterDate(registerDate);

        Role role = new Role();
        role.setName("ROLE_USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        user.setRoles(roleSet);

        return user;

    }


    /**
     * Метод для инициализация базы данных пользователями
     *
     * @return User
     */

//    Эта аннотация нужна только при первом запуске приложения.
//    @PostConstruct
    private User initializationAdmin() {
        User admin = new User();
        admin.setUsername("admin");
        admin.setLastName("adminov");
        admin.setEmail("admin@gmail.com");
        admin.setPassword("1");
        admin.setGender("Male");
        admin.setPhoneNumber("0705250086");
        admin.setProfilePicture("D:\\FFOutput");

        LocalDate birthDateAdmin = LocalDate.of(1989, 6, 1);
        admin.setBirthDate(birthDateAdmin);

        LocalDate registerDateAdmin = LocalDate.now();
        admin.setRegisterDate(registerDateAdmin);


        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        Set<Role> roles = new HashSet<>();
        roles.add(roleAdmin);

        admin.setRoles(roles);
        return admin;
    }


    /**
     * Переопределенный метод для инициализации базы данных
     *
     * @param args String
     * @throws Exception e
     */
    @Override
    public void run(String... args) throws Exception {
        Product product = initializationProduct();
        productService.save(product);

        User user = initializationUser();
        userService.save(user);

        User admin = initializationAdmin();
        userService.save(admin);
    }
}
