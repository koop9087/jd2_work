package by.academy.it.web;

import by.academy.it.pojo.User;
import by.academy.it.service.UserFriendsService;
import by.academy.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("user")
public class FriendsController {

    @Autowired
    UserService userService;

    @Autowired
    UserFriendsService userFriendsService;

    @RequestMapping(value = "/friends/{pageId}")
    public String viewAllUsersForAddToFriends(@PathVariable int pageId, Model model) {
        int total = 5;
        if(pageId == 1) {

        } else {
            pageId = (pageId - 1) * total + 1;
        }
        System.out.println(pageId);
        List<User> userList = userService.getUsersByPage(pageId, total);
        model.addAttribute("msg", userList);
        return "viewfriends";
    }
}
