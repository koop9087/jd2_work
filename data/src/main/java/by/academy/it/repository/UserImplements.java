package by.academy.it.repository;

import by.academy.it.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class UserImplements implements UserDao {
    public static final Logger logger = Logger.getLogger(
            UserImplements.class.getName());
    public static final String MESSAGE_DELETED_OPERATION_IS_SUCCESSFUL = "DELETED OPERATION IS SUCCESSFUL";

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Serializable saveUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        Serializable id = session.save(user);
        logger.info("User had been saved : " + user);
        return id;
    }

    @Override
    public void hardDeleteUser(Serializable id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        if(user != null) {
            session.delete(user);
            logger.info("User had been deleted" + user);
        }
    }

    @Override
    public User readUser(Serializable id) {
        Session session = this.sessionFactory.getCurrentSession();
        User userLoaded = (User) session.load(User.class, id);
        logger.info("User had been readed successfully : " + userLoaded);
        return userLoaded;
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        logger.info("User had been updated :" + user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from User").list();
        logger.info("UserList is completed : " + users);
        return users;
    }

    @Override
    public User readUserFromUrl(String userLink) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User)session.createQuery("from User where userLink=:userLink")
                .setParameter("userLink",userLink)
                .getSingleResult();
        logger.info("User completely loaded by url : " + user);
        return user;
    }
}
