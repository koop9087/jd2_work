package by.academy.it.service;

import by.academy.it.pojo.UserLogin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


public interface UserLoginService {
    Serializable saveUserLogin(UserLogin user);

    UserLogin readUserLogin(Serializable id);

    void updateUserLogin(UserLogin user);

    void hardDeleteUserLogin(Serializable id);

    List<UserLogin> getAllUsersLoginsForCheck();
}
