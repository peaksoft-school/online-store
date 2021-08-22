package kg.online_store.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main_page")
public class MainController {
    @GetMapping
    public String loginPage() {
        return "main-page";
    }

    @GetMapping("phones")
    public String productPage() {
        return "phone";
    }

    @GetMapping("fridges")
    public String fridgePage() {
        return "fridge";
    }

    @GetMapping("laptops")
    public String laptopPage() {
        return "laptop";
    }

    @GetMapping("televisions")
    public String televisionPage() {
        return "television";
    }

    @GetMapping("washMachines")
    public String washMachinePage() {
        return "wash-machine";
    }

    @GetMapping("products")
    public String listProductPage() {
        return "list-product";
    }

     @GetMapping("editProfile")
    public String editPage() {
        return "editUserPage";
    }
    @GetMapping("userProfile")
    public String userPage() {
        return "userTable";
    }
}
