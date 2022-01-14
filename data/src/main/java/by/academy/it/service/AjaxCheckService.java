package by.academy.it.service;

import by.academy.it.dto.CheckLoginDto;
import by.academy.it.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AjaxCheckService {

    public CheckLoginDto ajaxCheckFieldInDatabase(UserService userService,
                                                  String checkFieldValue,
                                                  Boolean fieldPattern) {
        CheckLoginDto checkLoginDto = new CheckLoginDto();
        List<User> userLoginsList = userService.getAllUsers();
        for (User user : userLoginsList) {
            if(fieldPattern) {
                checkField(user.getLogin(),checkFieldValue,checkLoginDto);
            } else {
                checkField(user.getUserLink(),checkFieldValue,checkLoginDto);
            }
        }
        return checkLoginDto;
    }

    private void checkField(String fieldInDB, String fieldLocal, CheckLoginDto checkLoginDto) {
        if (fieldInDB.equals(fieldLocal)) {
            checkLoginDto.setSuccessful(true);
        }
    }
}
