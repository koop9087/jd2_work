package data;

import pojo.User;

import java.io.Serializable;

public interface UserDao {
    Serializable saveUser(User user);

    void deleteUser(int id);

    User readUser(int id);

    void updateUser(User user);
}
