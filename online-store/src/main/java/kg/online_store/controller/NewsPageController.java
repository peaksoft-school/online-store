package kg.online_store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("news_page")
public class NewsPageController {
    @GetMapping
    public String newsPage() {
        return "news_page";
    }
}
