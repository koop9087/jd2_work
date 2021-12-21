package by.academy.it.repository;

import by.academy.it.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class UserDaoImplements implements UserDao {
    public static final Logger logger = Logger.getLogger(
            UserDaoImplements.class.getName());
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
        if (user != null) {
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
        User user = (User) session.createQuery("from User where userLink=:userLink")
                .setParameter("userLink", userLink)
                .getSingleResult();
        logger.info("User completely loaded by url : " + user);
        return user;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUsersByPage(int pageId, int total) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from User")
                .setFirstResult(pageId - 1)
                .setMaxResults(total).list();
    }

    @Override
    public User findByLogin(String login) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.createQuery("from User where login=:login")
                .setParameter("login", login)
                .getSingleResult();
        logger.info("User completely loaded by login : " + user);
        return user;
    }
}
