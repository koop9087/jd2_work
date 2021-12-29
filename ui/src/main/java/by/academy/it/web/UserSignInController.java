package by.academy.it.web;

import by.academy.it.pojo.User;
import by.academy.it.service.SecurityService;
import by.academy.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class UserSignInController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;


    @GetMapping("sign")
    public String login() {
        return "_user_sign_in";
    }

    @PostMapping("sign")
    public String sign(@RequestParam String login,
                       @RequestParam String password,
                       Model model) {
        User user = userService.findByLogin(login);
        if (user.getStatus().equals("deleted")) {
            return "_error_page";
        }
        if (user.getLogin().equals(login) && !user.getStatus().equals("banned")) {
            securityService.autoLogin(login, password);
            model.addAttribute("user", user);
            return "redirect:/home";
        }
        return "_user_sign_in";
    }
}
