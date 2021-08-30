package kg.online_store.controller;

import kg.online_store.model.User;
import kg.online_store.repository.UserRepository;
import kg.online_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Controller
public class AdminPageController {

    private final UserService userService;
    private final UserRepository repository;

    @Autowired
    public AdminPageController(UserService userService, UserRepository repository) {
        this.userService = userService;
        this.repository = repository;
    }
    public static String uploadDirectory = System.getProperty("user.dir") + "/src/imageData";


    @RequestMapping("/users/{pageNo}/{pageSize}")
    @ResponseBody
    public List<User> getPaginated(@PathVariable int pageNo, @PathVariable int pageSize) {
        return userService.findPaginated(pageNo, pageSize);
    }

    @RequestMapping("admin_page")
    public String homeFun(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.setAttribute("allUsers", repository.count());
        return "admin_page";
    }

    @RequestMapping("addUser")
    @ResponseBody
    public String saveUser(User user,@RequestParam("img") MultipartFile file) {

        StringBuilder fileNames = new StringBuilder();
        String filename=user.getId()+ file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
        Path fileNameAndPath = Paths.get(uploadDirectory,filename);
        try {
            Files.write(fileNameAndPath,file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setProfilePicture(filename);
        user.setRegisterDate(LocalDate.now());
        userService.save(user);
        return "Успешно сохранен ! ";
    }

    @RequestMapping("delUser")
    public String deleteUser(long id) {
        userService.deleteById(id);
        return "admin_page";
    }

}


