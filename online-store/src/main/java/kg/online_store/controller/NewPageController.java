package kg.online_store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/new_user")
public class NewPageController {

    @GetMapping
    public String userPage() {
        return "new_user";
    }
}