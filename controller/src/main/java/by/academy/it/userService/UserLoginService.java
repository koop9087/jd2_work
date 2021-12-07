package by.academy.it.userService;

import by.academy.it.data.UserLoginImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.academy.it.pojo.UserLogin;

import java.io.Serializable;
import java.util.List;

@Service
public class UserLoginService implements UserLoginDaoService {

    @Autowired
    UserLoginImplements userLoginImplements;

    @Override
    public Serializable save(UserLogin userLogin) {
        return userLoginImplements.saveUserLogin(userLogin);
    }

    @Override
    public UserLogin read(Serializable id) {
        return userLoginImplements.readUserLogin(id);
    }

    @Override
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
