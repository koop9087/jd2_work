package by.academy.it.web;

import by.academy.it.pojo.User;
import by.academy.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/profile/{url}")
    public String getUserInfo(Model model, @PathVariable("url") String url) {
        User user = userService.readUserFromUrl(url);
        model.addAttribute("recipientUser", user);
        return "_user_welcome";
    }
}
