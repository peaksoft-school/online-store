package kg.online_store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String loginPage() {
        return "main-page";
    }

    @GetMapping("editProfile")
    public String editPage() {
        return "edit-user-page";
    }

    @GetMapping("userProfile")
    public String userPage() {
        return "user-table";
    }

    @GetMapping("update")
    public String userPageTest() {
        return "update";
    }

    @GetMapping("/buyer's_cabinet")
    public String buyersCabinet() {
        return "buyer's-cabinet";
    }

    @GetMapping("/stock_page")
    public String stockPage() {
        return "stock";
    }
}
