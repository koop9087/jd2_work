package by.academy.it.web;

import by.academy.it.pojo.User;
import by.academy.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@SessionAttributes("user")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String userList(@ModelAttribute("user") User user, Model model) {
        List<User> listOfAllUsers = userService.getAllUsers();
        listOfAllUsers.remove(user);
        model.addAttribute("allUsers", listOfAllUsers.stream()
                .filter(user1 -> user.getUserFriends().stream()
                        .noneMatch(userFriends -> userFriends.getFriendId().equals(user1.getId()))).collect(Collectors.toList()));
        return "users";
    }
}
