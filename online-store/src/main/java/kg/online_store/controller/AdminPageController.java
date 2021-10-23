package kg.online_store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin_page")
public class AdminPageController {

    @GetMapping
    public String adminPage() {
        return "admin_page";
    }
}
