package by.academy.it.web;

import by.academy.it.pojo.User;
import by.academy.it.service.SecurityService;
import by.academy.it.service.UserService;
import by.academy.it.web.wrapper.SignWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class UserSignInController {

    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @GetMapping("sign")
    public String login(Model model) {
        model.addAttribute("signWrapper", new SignWrapper());
        return "_user_sign_in";
    }

    @PostMapping("sign")
    public String sign(@ModelAttribute @Valid SignWrapper signWrapper,
                       BindingResult bindingResult,
                       Model model) {
        try {
            User user = userService.findByLogin(signWrapper.getLogin());

            if (StringUtils.isEmpty(signWrapper.getLogin()) || StringUtils.isEmpty(user)) {
                return "_user_sign_in";
            }
            if (user.getStatus().equals("deleted") || user.getStatus().equals("banned")) {
                model.addAttribute("status", user.getStatus());
                return "_error_page";
            }
            if (user.getLogin().equals(signWrapper.getLogin())
                    && !user.getStatus().equals("banned")
                    && securityService.autoLogin(signWrapper.getLogin(),
                    signWrapper.getPassword())) {
                model.addAttribute("user", user);
                return "redirect:/home";
            }
        } catch (NoResultException resultException) {
            return "_error_page";
        }
        return "_user_sign_in";
    }
}
