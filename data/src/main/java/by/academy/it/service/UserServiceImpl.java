package by.academy.it.service;

import by.academy.it.pojo.User;
import by.academy.it.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public Serializable saveUser(User user) {
        return this.userDao.saveUser(user);
    }

    public void deleteUser(int id) {
        this.userDao.deleteUser(id);
    }


    public User readUser(Serializable id) {
        return this.userDao.readUser(id);
    }

    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    public List<User> getUserList() {
        return this.userDao.getUserList();
    }
}
