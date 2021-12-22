package by.academy.it.service;

import by.academy.it.pojo.User;
import by.academy.it.pojo.UserRole;
import by.academy.it.repository.RoleDao;
import by.academy.it.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional(propagation = Propagation.NESTED)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserInfoValidator userInfoValidator;

    public Serializable saveUser(User user) {
        if (userInfoValidator.isLoginValid(user)
                && userInfoValidator.isPasswordValid(user)
                && userInfoValidator.isEmailValid(user)) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            Set<UserRole> roles = new HashSet<>();
            UserRole userRole = new UserRole();
            userRole.setUsers(user);
            userRole.setId(1L);
            userRole.setName("ROLE_USER");
            roles.add(userRole);
            user.setRoles(roles);
            roleDao.saveRole(userRole);
            return this.userDao.saveUser(user);
        } else throw new RuntimeException("cannot add user incorrect data");
    }

    public User readUser(Serializable id) {
        return this.userDao.readUser(id);
    }

    public void updateUser(User user) {
        if (userInfoValidator.isFirstNameValid(user)
                && userInfoValidator.isSecondNameValid(user)
                && userInfoValidator.isUserLinkValid(user)) {
            this.userDao.updateUser(user);
        } else {
            this.userDao.hardDeleteUser(user.getId());
            throw new RuntimeException("cannot update user incorrect data");
        }
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

    public User findByLogin(String login) {
        return this.userDao.findByLogin(login);
    }

    public List<User> getUsersByPage(int pageId, int total) {
        return this.userDao.getUsersByPage(pageId, total);
    }
}
