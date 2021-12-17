package by.academy.it.service;

import by.academy.it.pojo.User;
import by.academy.it.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional(propagation = Propagation.NESTED)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public Serializable saveUser(User user) {
        return this.userDao.saveUser(user);
    }


    public User readUser(Serializable id) {
        return this.userDao.readUser(id);
    }


    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }


    public void hardDeleteUser(Serializable id) {
        this.userDao.hardDeleteUser(id);
    }


    public List<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }

    public User readUserFromUrl(String url) {
        return this.userDao.readUserFromUrl(url);
    }
}
