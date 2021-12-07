package by.academy.it.data;

import by.academy.it.pojo.UserLogin;

import java.io.Serializable;
import java.util.List;

public interface UserLoginDao {
    Serializable saveUserLogin(UserLogin user);

    void safeDeleteUserLogin(Serializable id);

    UserLogin readUserLogin(Serializable id);

    void updateUserLogin(UserLogin user);

    void hardDeleteUserLogin(Serializable id);               //special interface for administrator

    List<String> getAllUsersLoginsForCheck();
}
