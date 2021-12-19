package by.academy.it.repository;

import by.academy.it.pojo.UserFriends;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class UserFriendsDaoImpl implements UserFriendsDao{
    public static final Logger logger = Logger.getLogger(
            UserFriendsDaoImpl.class.getName());
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Serializable addFriends(UserFriends userFriends) {
        Session session = this.sessionFactory.getCurrentSession();
        Serializable id = session.save(userFriends);
        logger.info("User had been saved : " + userFriends);
        return id;
    }

    @Override
    public void deleteFriends(Serializable id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserFriends userFriends = (UserFriends) session.load(UserFriends.class, id);
        userFriends.setStatus("deleted");
        if(userFriends != null) {
            session.update(userFriends);
            logger.info("User had been deleted" + userFriends);
        }
    }

    @Override
    public UserFriends readFriends(Serializable id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserFriends userFriends = (UserFriends) session
                .createQuery("from UserFriends where user.id=:id")
                .setParameter("id", id)
                .getSingleResult();
        logger.info("User had been readed successfully : " + userFriends);
        return userFriends;
    }

    @Override
    public void updateFriends(UserFriends userFriends) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(userFriends);
        logger.info("User had been updated :" + userFriends);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserFriends> getUserFriendsList() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserFriends> userFriends = session.createQuery("from UserFriends ").list();
        logger.info("UserLoginList is completed : " + userFriends);
        return userFriends;
    }
}
