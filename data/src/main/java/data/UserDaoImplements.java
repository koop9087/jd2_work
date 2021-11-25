package data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.User;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDaoImplements implements UserDao {
    public static final Logger logger = Logger.getLogger(
            UserDaoImplements.class.getName());

    private final SessionFactory sessionFactory;

    public UserDaoImplements(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UserDaoImplements() {
        this(SessionFactoryHolder.getSessionFactory());
    }

    @Override
    public Serializable saveUser(User user) {
        Session session = sessionFactory.openSession();
        if (session.isDirty()) session.flush();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            id = session.save(user);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                logger.log(Level.WARNING, e.getMessage());
            }
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.openSession();
        if (session.isDirty()) session.flush();
        Transaction tr = null;
        try {
            User loadUser = session.load(User.class, id);
            tr = session.beginTransaction();
            session.delete(loadUser);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                logger.log(Level.WARNING, e.getMessage());
            }
        } finally {
            session.close();
        }
    }

    @Override
    public User readUser(int id) {
        Session session = sessionFactory.openSession();
        if (session.isDirty()) session.flush();
        try {
            User loadUser = session.load(User.class, id);
            if (loadUser != null) {
                return loadUser;
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        if(session.isDirty()) session.flush();
        try {
            tr = session.beginTransaction();
            session.saveOrUpdate(user);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                logger.log(Level.WARNING, e.getMessage());
            }
        } finally {
            session.close();
        }
        session.refresh(user); //???
    }
}