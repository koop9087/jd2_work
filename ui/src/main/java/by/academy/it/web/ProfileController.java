package by.academy.it.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/profile/info")
@SessionAttributes("id")
public class ProfileController {

    @RequestMapping
    public void doGet(@ModelAttribute("id") String id) {
        doPost(id);
    }

    @PostMapping
    public void doPost(@ModelAttribute("id") String id) {

    }

}
