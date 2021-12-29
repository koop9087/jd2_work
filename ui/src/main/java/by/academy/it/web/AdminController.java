package by.academy.it.web;

import by.academy.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "admin";
    }

    @PostMapping("/admin")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") String userId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model) {
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