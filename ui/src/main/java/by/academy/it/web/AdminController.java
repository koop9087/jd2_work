package by.academy.it.web;

import by.academy.it.pojo.User;
import by.academy.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("user")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String userList(@ModelAttribute("user") User user, Model model) {
        List<User> allUsers = userService.getAllUsers();
        allUsers.remove(user);
        model.addAttribute("allUsers", allUsers);
        return "admin";
    }

    @PostMapping("/admin")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") String userId,
                             @RequestParam(required = true, defaultValue = "") String action) {
        userService.softDeleteUser(userId, action, "delete");
        userService.banUser(userId, action, "ban");
        userService.unbanUser(userId, action, "unban");
        return "redirect:/admin";
    }

    @GetMapping("/error")
    public String getErrorPage(){
        return "/_error_page";
    }
}