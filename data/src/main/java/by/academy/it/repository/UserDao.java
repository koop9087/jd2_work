package by.academy.it.repository;

import by.academy.it.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;

public interface UserDao {
    Serializable saveUser(User user);

    User readUser(Serializable id);

    void updateUser(User user);

    void softDeleteUser(Serializable id);

    void hardDeleteUser(User user);

    List<User> getAllUsers();

    User readUserFromUrl(String url);

    List<User> getUsersByPage(int pageId, int total);

    User findByLogin(String login);

    void banUser(Serializable id);

    void unbanUser(Serializable id);
}
