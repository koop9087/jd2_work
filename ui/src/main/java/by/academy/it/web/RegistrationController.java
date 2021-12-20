package by.academy.it.web;

import by.academy.it.pojo.User;
import by.academy.it.pojo.UserFriends;
import by.academy.it.service.UserFriendsService;
import by.academy.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Random;


@Controller
@SessionAttributes("user")
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String doGet() {
        return "_user_login";
    }

    @PostMapping("/login")
    public String doPost(@RequestParam String login,
                         @RequestParam String password,
                         @RequestParam String email,
                         Model model) {
        User user = new User(login, password, email);
        user.setUserLink(Integer.toString(new Random().nextInt(1_000_000)));

        Serializable id = userService.saveUser(user);
        if (id != null) {
            model.addAttribute("user", user);
            return "_userAddInfo";
        } else {
            return "_user_login";
        }
    }

    @GetMapping("/profile")
    public String redirectToUser() {
        return "_userAddInfo";
    }

    @PostMapping("/profile")
    public String saveAddInfoUser(@RequestParam String firstName,
                                  @RequestParam String secondName,
                                  @RequestParam String link,
                                  @ModelAttribute("user") User user) {
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setUserLink(link);
        userService.updateUser(user);
        return "_user_welcome";
    }


    @GetMapping(value = "/profile/{url}")
    public String getUserInfo(Model model, @PathVariable("url") String url) {
        User user = userService.readUserFromUrl(url);
        model.addAttribute("user", user);
        return "_user_welcome";
    }
}
