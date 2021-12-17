package by.academy.it.web;

import by.academy.it.pojo.User;
import by.academy.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/edit")
@SessionAttributes("id")
public class EditController {

    @Autowired
    UserService userService;

    @GetMapping
    public String doGet() {
        return "_edit_user";
    }

    @PostMapping
    public String doPost(@RequestParam String firstName,
                               @RequestParam String secondName,
                               @ModelAttribute("id") String id,
                               Model model) {
        User user = userService.readUser(id);
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        userService.updateUser(user);
        model.addAttribute("user", user);
        return "_user_welcome";
    }
}
