package by.academy.it.web;

import by.academy.it.pojo.UserLogin;
import by.academy.it.service.UserLoginService;
import by.academy.it.service.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.io.Serializable;


@Controller
@RequestMapping("/login")
@SessionAttributes("id")
public class RegistrationController {

    @Autowired
    UserLoginService userLoginService;

    @GetMapping
    public String doGet() {
        return "_user_login";
    }

    @PostMapping
    public String doPost(@RequestParam String login,
                         @RequestParam String password,
                         @RequestParam String email,
                         Model model) {
        UserLogin userLogin = new UserLogin(login, password, email);

        Serializable id = userLoginService.saveUserLogin(userLogin);
        if (id != null) {
            model.addAttribute("id", userLogin.getUser().getId());
            return "_userAddInfo";
        } else {
            return "_user_login";
        }
    }
}
