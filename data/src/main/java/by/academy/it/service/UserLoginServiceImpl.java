package by.academy.it.service;

import by.academy.it.pojo.UserLogin;
import by.academy.it.repository.UserLoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional(propagation = Propagation.NESTED)
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginDao userLoginDao;

    public Serializable saveUserLogin(UserLogin user) {
        return this.userLoginDao.saveUserLogin(user);
    }


    public UserLogin readUserLogin(Serializable id) {
        return this.userLoginDao.readUserLogin(id);
    }


    public void updateUserLogin(UserLogin user) {
        this.userLoginDao.updateUserLogin(user);
    }


    public void hardDeleteUserLogin(Serializable id) {
        this.userLoginDao.hardDeleteUserLogin(id);
    }


    public List<UserLogin> getAllUsersLoginsForCheck() {
        return this.userLoginDao.getAllUsersLoginsForCheck();
    }
}
