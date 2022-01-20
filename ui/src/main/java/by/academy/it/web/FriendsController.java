package by.academy.it.web;

import by.academy.it.pojo.User;
import by.academy.it.pojo.UserFriends;
import by.academy.it.service.UserFriendsService;
import by.academy.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("user")
public class FriendsController {

    @Autowired
    UserService userService;

    @Autowired
    UserFriendsService userFriendsService;

    @GetMapping(value = "/friends/{pageId}")
    public String viewAllUsersForAddToFriends(@PathVariable int pageId, Model model) {
        int total = 5;
        if (pageId == 1) {

        } else {
            pageId = (pageId - 1) * total + 1;
        }
        System.out.println(pageId);
        List<User> userList = userService.getUsersByPage(pageId, total);
        model.addAttribute("msg", userList);
        return "viewfriends";
    }

    @PostMapping("/profile/add")
    public String addFriend(@RequestParam String testUserLink,
                            @ModelAttribute("user") User user,
                            Model model) {
        User opponentUserReceiver = userService.readUserFromUrl(testUserLink);
        UserFriends loadedAuthUserSenderFromId = new UserFriends();
        loadedAuthUserSenderFromId.setFriendId(opponentUserReceiver.getId());
        loadedAuthUserSenderFromId.setStatus("friend");
        loadedAuthUserSenderFromId.setUserLogin(user);
        List<UserFriends> userFriendsList = user.getUserFriends();
        userFriendsList.add(loadedAuthUserSenderFromId);
        userService.updateUser(user);
        userFriendsService.updateFriends(loadedAuthUserSenderFromId);
        UserFriends opponent = new UserFriends();
        opponent.setFriendId(user.getId());
        opponent.setStatus("friend");
        opponent.setUserLogin(opponentUserReceiver);
        List<UserFriends> opponentUserList = opponentUserReceiver.getUserFriends();
        opponentUserList.add(opponent);
        userService.updateUser(opponentUserReceiver);
        userFriendsService.updateFriends(opponent);
        model.addAttribute("user", user);
        return "redirect:/home";
    }

    @PostMapping("/delete/{url}")
    public String deleteFriend(@PathVariable("url") String url,
                               @ModelAttribute("user") User user,
                               Model model) {
        User loadedUserRecipient = userService.readUserFromUrl(url);
        if (loadedUserRecipient == null) {
            return "_error_page";
        }
        userFriendsService.deleteFriends(user.getId(), loadedUserRecipient.getId());
        user = userService.readUser(user.getId());
        userService.updateUser(loadedUserRecipient);
        model.addAttribute("user", user);
        return "redirect:/home";
    }

    @GetMapping("/friends")
    public String viewFriendList(@ModelAttribute("user") User user, Model model) {
        List<UserFriends> userFriends = user.getUserFriends();
        List<User> friendsList = new ArrayList<>();
        for (UserFriends friends : userFriends) {
            User loadedUser = userService.readUser(friends.getFriendId());
            friendsList.add(loadedUser);
        }
        model.addAttribute("friends", friendsList);
        return "viewfriends";
    }
}
