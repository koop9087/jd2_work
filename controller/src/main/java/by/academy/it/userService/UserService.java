package by.academy.it.userService;

import data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.User;

@Service
public class UserService implements UserDaoService {
    @Autowired
    UserDao userDaoImplements;

    @Override
    public void update(User user) {
        userDaoImplements.updateUser(user);
    }
}
