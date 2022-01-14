package by.academy.it.web;

import by.academy.it.pojo.User;
import by.academy.it.service.UserService;
import by.academy.it.web.wrapper.EditWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/edit")
@SessionAttributes("user")
public class EditController {
    @Autowired
    UserService userService;

    @GetMapping
    public String showEditPage(Model model, @ModelAttribute("user") User localeUser) {
        model.addAttribute("editWrapper", new EditWrapper());
        return "edit_page";
    }

    @PostMapping
    public String saveEditedParams(@ModelAttribute @Valid EditWrapper editWrapper,
                                   BindingResult bindingResult,
                                   @ModelAttribute("user") User newUserInSession,
                                   Model model) {
        if (bindingResult.hasErrors()) {
            return "edit_page";
        }
        changeFields(editWrapper, newUserInSession);
        userService.updateUser(newUserInSession);
        model.addAttribute("user", newUserInSession);
        return "redirect:/home";
    }

    private void changeFields(EditWrapper editWrapper, User user) {
        String firstName = editWrapper.getWrapperFirstName();
        if (!StringUtils.isEmpty(firstName)) {
            user.setFirstName(firstName);
        }
        String secondName = editWrapper.getWrapperSecondName();
        if (!StringUtils.isEmpty(secondName)) {
            user.setSecondName(secondName);
        }
        String email = editWrapper.getWrapperEmail();
        if (!StringUtils.isEmpty(email)) {
            user.setEmail(email);
        }
        String url = editWrapper.getWrapperUrl();
        if (!StringUtils.isEmpty(url)) {
            user.setUserLink(url);
        }
        String profileStatus = editWrapper.getWrapperProfileStatus();
        if (!StringUtils.isEmpty(profileStatus)) {
            user.setProfileStatus(profileStatus);
        }
        String gender = editWrapper.getWrapperGender();
        if (!StringUtils.isEmpty(gender)) {
            user.setGender(gender);
        }
        String country = editWrapper.getWrapperCountry();
        if (!StringUtils.isEmpty(country)) {
            user.setCountry(country);
        }
    }
}
