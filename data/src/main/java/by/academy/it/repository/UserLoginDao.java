package by.academy.it.repository;

import by.academy.it.pojo.UserLogin;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

public interface UserLoginDao {
    Serializable saveUserLogin(UserLogin user);

    UserLogin readUserLogin(Serializable id);

    void updateUserLogin(UserLogin user);

    void hardDeleteUserLogin(Serializable id);

    List<UserLogin> getAllUsersLoginsForCheck();
}
