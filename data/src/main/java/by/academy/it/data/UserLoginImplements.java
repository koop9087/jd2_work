package by.academy.it.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import by.academy.it.pojo.UserLogin;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class UserLoginImplements implements UserLoginDao {
    public static final Logger logger = Logger.getLogger(
            UserLoginImplements.class.getName());
    public static final String MESSAGE_DELETED_OPERATION_IS_SUCCESSFUL = "DELETED OPERATION IS SUCCESSFUL";
    private final SessionFactory sessionFactory;

    public UserLoginImplements(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UserLoginImplements() {
        this(SessionFactoryHolder.getSessionFactory());
    }

    @Override
    public Serializable saveUserLogin(UserLogin user) {
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
    public void safeDeleteUserLogin(Serializable id) {
        Session session = sessionFactory.openSession();
        if (session.isDirty()) session.flush();
        Transaction tr = null;
        try {
            UserLogin loadUser = session.load(UserLogin.class, id);
            if (loadUser != null) {
                loadUser.setStatus("deleted");
                logger.log(Level.FINE, () -> MESSAGE_DELETED_OPERATION_IS_SUCCESSFUL);
            }
            tr = session.beginTransaction();
            session.save(loadUser);
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
    public void hardDeleteUserLogin(Serializable id) {
        Session session = sessionFactory.openSession();
        if (session.isDirty()) session.flush();
        Transaction tr = null;
        try {
            UserLogin loadUser = session.load(UserLogin.class, id);
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
    public UserLogin readUserLogin(Serializable id) {
        Session session = sessionFactory.openSession();
        if (session.isDirty()) session.flush();
        try {
            UserLogin loadUser = session.get(UserLogin.class, id);
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
    public void updateUserLogin(UserLogin user) {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        if (session.isDirty()) session.flush();
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
    }

    @Override
    public List<String> getAllUsersLoginsForCheck() {
        Session session = sessionFactory.openSession();
        String hql = "SELECT login FROM UserLogin";
        Query query = session.createQuery(hql);
        List<String> results = query.list();
        logger.log(Level.INFO, "execute is normal");
        session.close();
        return results;
    }

    public UserLogin readUserLoginByLoginAndPassword(String login, String password) {
        Session session = sessionFactory.openSession();
        String hql = "FROM UserLogin WHERE login=:login AND password=:password";
        Query query = session.createQuery(hql);
        query.setParameter("login", login);
        query.setParameter("password", password);
        return (UserLogin) query.getSingleResult();
    }
}
