package by.academy.it.web;

import by.academy.it.repository.UserDaoImplements;
import by.academy.it.pojo.User;
import by.academy.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/login/addedInfo")
@SessionAttributes("id")
public class AddInformationController {

    @Autowired
    UserService userService;

    @GetMapping
    public void doGet(@RequestParam String firstName,
                      @RequestParam String secondName,
                      @ModelAttribute("id") String id) {
        doPost(firstName, secondName, id);
    }

    @PostMapping
    public ModelAndView doPost(@RequestParam String firstName,
                         @RequestParam String secondName,
                         @ModelAttribute("id") String id) {
        User user = userService.readUser(id);
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setUserStatus("created");
        user.setRole("user");
        userService.updateUser(user);
        ModelAndView modelAndView = new ModelAndView("_user_welcome");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
}
