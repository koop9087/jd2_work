package by.academy.it.web;

import by.academy.it.pojo.User;
import by.academy.it.pojo.UserFriends;
import by.academy.it.pojo.UserMessages;
import by.academy.it.service.UserMessageService;
import by.academy.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("user")
public class MessageController {

    @Autowired
    UserMessageService userMessageService;

    @Autowired
    UserService userService;

    @GetMapping("/messages/{url}")
    public String showMessages(@PathVariable("url") String url, @ModelAttribute("user") User user, Model model) {
        User recipient = userService.readUserFromUrl(url);
        List<UserMessages> userMessages = userMessageService.readMessage(user.getId(), recipient.getId());
        List<UserFriends> userFriends = user.getUserFriends();
        List<User> friendsList = new ArrayList<>();
        for (UserFriends friends : userFriends) {
            User loadedUser = userService.readUser(friends.getFriendId());
            friendsList.add(loadedUser);
        }
        model.addAttribute("friends", friendsList);
        model.addAttribute("messages", userMessages);
        model.addAttribute("recipient", recipient);
        return "message";
    }

    @PostMapping("/messages/{url}")
    public String sendMessage(@PathVariable("url") String url, @ModelAttribute("user") User sender, Model model,
                              @RequestParam String value) {
        User recipient = userService.readUserFromUrl(url);
        UserMessages senderUserMessage = new UserMessages();
        senderUserMessage.setRecipientId(recipient.getId());
        senderUserMessage.setStatus("DELIVERED");
        senderUserMessage.setTimestamp(new Date());
        senderUserMessage.setValue(value);
        senderUserMessage.setUser(sender);
        List<UserMessages> userMessagesList = sender.getMessages();
        userMessagesList.add(senderUserMessage);
        sender = userService.readUser(sender.getId());
        userMessageService.saveMessage(senderUserMessage);
        UserMessages recipientUserMessage = new UserMessages();
        recipientUserMessage.setRecipientId(sender.getId());
        recipientUserMessage.setValue(value);
        recipientUserMessage.setTimestamp(new Date());
        recipientUserMessage.setStatus("RECEIVED");
        recipientUserMessage.setUser(sender);
        List<UserMessages> recipientMessages = recipient.getMessages();
        recipientMessages.add(recipientUserMessage);
        recipient = userService.readUser(recipient.getId());
        userMessageService.saveMessage(recipientUserMessage);
        model.addAttribute("mainUser", sender);
        return "redirect:/messages/{url}";
    }
}
