package by.academy.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//@Controller
//@RequestMapping("/profile")
//@SessionAttributes("id")
//public class AddInformationController {
//
//    //@Autowired
//    //UserService userService;
//
//    @GetMapping
//    public String redirectToUser(@RequestParam String firstName,
//                      @RequestParam String secondName,
//                      @RequestParam String url,
//                      @ModelAttribute("id") String id) {
//        return "redirect:/profile/" + id;
//    }
//
//
//    //@GetMapping(value = "/{url}")
//    public String getUserInfo(Model model,
////            @RequestParam String firstName,
////                        @RequestParam String secondName,
////                        @RequestParam String url,
//                        @PathVariable("url") String id) {
//        //User user = userService.readUser(id);
//        //model.addAttribute("user", user);
//        return "_user_welcome";
//    }
//}
//