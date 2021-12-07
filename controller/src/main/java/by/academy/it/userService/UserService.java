package by.academy.it.userService;

import by.academy.it.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.academy.it.pojo.User;

@Service
public class UserService implements UserDaoService {
    @Autowired
    UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void update(User user) {
        userDao.updateUser(user);
    }
}
