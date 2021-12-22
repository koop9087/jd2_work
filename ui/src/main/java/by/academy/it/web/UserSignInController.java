package by.academy.it.web;

import by.academy.it.repository.UserDao;
import by.academy.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserSignInController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping(value = "/sign")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Login or password incorrect");
        }
        if (logout != null) {
            model.addAttribute("message", "logout successful");
        }
        return "_user_sign_in";
    }

    @PostMapping("/sign")
    public String sign(@RequestParam String login,
                       @RequestParam String password,
                       Model model) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();
        by.academy.it.pojo.User userLocal = userService.findByLogin(user.getUsername());

        if (userLocal != null) {
            model.addAttribute("user", userLocal);
            return "user_home";
        }
        return "_user_sign_in";
    }

}
