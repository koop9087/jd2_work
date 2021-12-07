package by.academy.it.web;

import by.academy.it.pojo.UserLogin;
import by.academy.it.userService.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/login")
@SessionAttributes("id")
public class UserLoginServlet {

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
        if (userLoginService.isLoginValidForRegistration(userLogin.getLogin())) {
            userLoginService.save(userLogin);
            model.addAttribute("id", userLogin.getUser().getId());
            return "_userAddInfo";
        } else {
            return "_user_login";
        }
    }
}
