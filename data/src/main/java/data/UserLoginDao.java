package data;

import pojo.User;
import pojo.UserLogin;

import java.io.Serializable;

public interface UserLoginDao {
    Serializable saveUserLogin(UserLogin user);

    void safeDeleteUserLogin(int id);

    UserLogin readUserLogin(int id);

    void updateUserLogin(UserLogin user);

    void hardDeleteUserLogin(int id);               //special interface for administrator
}
