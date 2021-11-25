package userService;

import data.UserLoginImplements;
import pojo.UserLogin;

import java.io.Serializable;
import java.util.List;

public class UserLoginController {
    UserLoginImplements userLoginImplements = new UserLoginImplements();

    public Serializable save(UserLogin userLogin) {
        return userLoginImplements.saveUserLogin(userLogin);
    }

    public boolean isLoginValidForRegistration(String login) {
        List<String> stringLoginsList = userLoginImplements.getAllUsersLoginsForCheck();
        for(String usersLogin : stringLoginsList) {
            if(usersLogin.equals(login)) {
                return false;
            }
        }
        return true;
    }
}
