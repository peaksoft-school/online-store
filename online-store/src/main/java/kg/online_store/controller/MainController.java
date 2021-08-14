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

    @GetMapping("editProfile")
    public String editPage() {
        return "editUserPage";
    }
    @GetMapping("userProfile")
    public String userPage() {
        return "userTable";
    }
}
