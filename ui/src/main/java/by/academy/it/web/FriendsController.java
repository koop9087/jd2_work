package by.academy.it.web;

import by.academy.it.pojo.User;
import by.academy.it.pojo.UserFriends;
import by.academy.it.service.UserFriendsService;
import by.academy.it.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/friends/add/{userLink}")
    public String addFriend(@PathVariable String userLink,
                            Model model,
                            @ModelAttribute("user") User authUserSender) {

        User opponentUserReceiver = userService.readUserFromUrl(userLink);


        UserFriends loadedAuthUserSenderFromId = new UserFriends();


        loadedAuthUserSenderFromId.setFriendId(opponentUserReceiver.getId());
        loadedAuthUserSenderFromId.setStatus("friend");
        loadedAuthUserSenderFromId.setUserLogin(authUserSender);
        List<UserFriends> userFriendsList = authUserSender.getUserFriends();
        userFriendsList.add(loadedAuthUserSenderFromId);
        userService.updateUser(authUserSender);

        UserFriends opponent = new UserFriends();
        opponent.setFriendId(authUserSender.getId());
        opponent.setStatus("friend");
        opponent.setUserLogin(opponentUserReceiver);
        List<UserFriends> opponentUserList = opponentUserReceiver.getUserFriends();
        opponentUserList.add(opponent);
        userService.updateUser(opponentUserReceiver);

        userFriendsService.updateFriends(loadedAuthUserSenderFromId);
        userFriendsService.updateFriends(opponent);

        return "_user_welcome";
    }
}
