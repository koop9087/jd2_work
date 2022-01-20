package by.academy.it.web;

import by.academy.it.pojo.User;
import by.academy.it.service.SecurityService;
import by.academy.it.service.UserService;
import by.academy.it.validator.UserValidator;
import by.academy.it.web.wrapper.RegistrationWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Random;

@Controller
@SessionAttributes("user")
public class RegistrationController {
    private static final String ANONYMOUS_NAME = "Anonymous";
    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @Autowired
    UserValidator userValidator;

    @GetMapping(value = "/")
    public String redirectHomePage() {
        return "redirect:/home";
    }

    @GetMapping("home")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("registrationWrapper", new RegistrationWrapper());
        return "_user_login";
    }

    @PostMapping("register")
    public String saveNewUser(@RequestParam String login,
                              @ModelAttribute @Valid RegistrationWrapper registrationWrapper,
                              BindingResult bindingResult,
                              Model model) {
        User user = new User(login, registrationWrapper.getPassword(), registrationWrapper.getEmail());
        user.setFirstName(ANONYMOUS_NAME);
        user.setSecondName(ANONYMOUS_NAME);
        user.setUserLink(Integer.toString(new Random().nextInt(1_000_000)));
        Serializable id = null;
        if (!bindingResult.hasErrors()) {
            id = userService.saveUser(user);
            securityService.autoLogin(login, registrationWrapper.getPassword());
            if (id != null) {
                model.addAttribute("user", user);
                model.addAttribute("registrationWrapper", new RegistrationWrapper());
                return "_userAddInfo";
            }
        }
        model.addAttribute("login", login);
        return "_user_login";
    }

    @PostMapping("profile")
    public String saveAddInfoUser(@ModelAttribute @Valid RegistrationWrapper registrationWrapper,
                                  BindingResult bindingResult,
                                  @ModelAttribute("user") User user) {
        changeFields(registrationWrapper, user);
        if (!bindingResult.hasErrors()) {
            userService.updateUser(user);
            return "redirect:/home";
        } else {
            return "_userAddInfo";
        }
    }

    @GetMapping("profile")
    public String viewHomePage(@ModelAttribute("user") User user, Model model) {
        if (user.getStatus().equals("deleted") || user.getStatus().equals("banned")) {
            model.addAttribute("status", user.getStatus());
            return "_error_page";
        }
        if (userService.findByLogin(user.getLogin()).equals(user)) {
            return "home";
        }
        return "_error_page";
    }

    private void changeFields(RegistrationWrapper registrationWrapper, User user) {
        String firstName = registrationWrapper.getFirstName();
        if (!StringUtils.isEmpty(firstName)) {
            user.setFirstName(firstName);
        } else {
            user.setFirstName(ANONYMOUS_NAME);
        }
        String secondName = registrationWrapper.getSecondName();
        if (!StringUtils.isEmpty(secondName)) {
            user.setSecondName(secondName);
        } else {
            user.setSecondName(ANONYMOUS_NAME);
        }
        String url = registrationWrapper.getUrl();
        if (!StringUtils.isEmpty(url)) {
            user.setUserLink(url);
        }
    }
}