package by.academy.it.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/profile/{url}")
@SessionAttributes("id")
public class ProfileController {

    @RequestMapping
    public ModelAndView doGet(@ModelAttribute("id") String id,
                      @PathVariable String url) {
        ModelAndView modelAndView = new ModelAndView("_user_welcome");
        modelAndView.addObject("url", url);
        return modelAndView;
    }

    @PostMapping
    public void doPost(@ModelAttribute("id") String id,
                       @PathVariable String url) {

    }

}
