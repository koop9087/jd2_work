package by.academy.it.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserSignInController {

    @GetMapping(value = "/signin")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Login or password incorrect");
        }
        if(logout != null) {
            model.addAttribute("message", "logout successful");
        }
        return "_user_sign_in";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }

}
