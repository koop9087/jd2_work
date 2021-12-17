package by.academy.it.web;

import by.academy.it.dto.CheckLoginDto;
import by.academy.it.pojo.User;
import by.academy.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/check")
public class CheckController {

    @Autowired
    UserService userService;

    @GetMapping
    @ResponseBody
    public CheckLoginDto checkLogin(@RequestParam String login) {
        CheckLoginDto checkLoginDto = new CheckLoginDto();
        checkLoginDto.setMessage("");
        checkLoginDto.setSuccessful(false);
        List<User> userLoginsList = userService.getAllUsers();
        for (User user : userLoginsList) {
            if (user.getLogin().equals(login)) {
                checkLoginDto.setMessage("this login is exists");
                checkLoginDto.setSuccessful(true);
            }
        }
        return checkLoginDto;
    }
}