package by.academy.it.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import by.academy.it.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class UserDaoImplements implements UserDao {
    public static final Logger logger = Logger.getLogger(
            UserDaoImplements.class.getName());

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Serializable saveUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        Serializable id = session.save(user);
        logger.info("User saved : " + user);
        return id;
    }

    @Override
    public void deleteUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        if(user != null) {
            session.delete(user);
        }
        logger.info("User removed : " + user);
    }

    @Override
    public User readUser(Serializable id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        logger.info("User had readed :" + user);
        return user;
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        logger.info("User had updated" + user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUserList() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();

        for(User user : userList) {
            logger.info("User list : " + user);
        }
        return userList;
    }
}
