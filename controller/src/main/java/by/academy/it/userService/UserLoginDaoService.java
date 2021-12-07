package by.academy.it.userService;

import by.academy.it.pojo.UserLogin;

import java.io.Serializable;

public interface UserLoginDaoService {
    Serializable save(UserLogin userLogin);

    boolean isLoginValidForRegistration(String login);

    UserLogin read(Serializable id);
}
