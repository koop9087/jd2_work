package by.academy.it.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import by.academy.it.pojo.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class UserLoginImplements implements UserLoginDao {
    public static final Logger logger = Logger.getLogger(
            UserLoginImplements.class.getName());
    public static final String MESSAGE_DELETED_OPERATION_IS_SUCCESSFUL = "DELETED OPERATION IS SUCCESSFUL";

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Serializable saveUserLogin(UserLogin user) {
        Session session = this.sessionFactory.getCurrentSession();
        Serializable id = session.save(user);
        logger.info("User had been saved : " + user);
        return id;
    }

    @Override
    public void hardDeleteUserLogin(Serializable id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserLogin userLogin = (UserLogin) session.load(UserLogin.class, id);
        if(userLogin != null) {
            session.delete(userLogin);
            logger.info("User had been deleted" + userLogin);
        }
    }

    @Override
    public UserLogin readUserLogin(Serializable id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserLogin userLoginLoaded = (UserLogin) session.load(UserLogin.class, id);
        logger.info("User had been readed successfully : " + userLoginLoaded);
        return userLoginLoaded;
    }

    @Override
    public void updateUserLogin(UserLogin user) {
        Session session = this.sessionFactory.getCurrentSession();
        logger.info("User had been updated :" + user);
        session.saveOrUpdate(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserLogin> getAllUsersLoginsForCheck() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserLogin> userLogins = session.createQuery("from UserLogin").list();
        logger.info("UserLoginList is completed : " + userLogins);
        return userLogins;
    }
}
