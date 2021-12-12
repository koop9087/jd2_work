package by.academy.it.service;

import by.academy.it.pojo.User;

import java.io.Serializable;
import java.util.List;

public interface UserService {
    Serializable saveUser(User user);

    void deleteUser(int id);

    User readUser(Serializable id);

    void updateUser(User user);

    List<User> getUserList();
}
