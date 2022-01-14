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
public class UserFriendsDaoImpl implements UserFriendsDao {
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
    public void deleteFriends(Serializable senderId, Serializable recipientId) {
        Session session = this.sessionFactory.getCurrentSession();
        UserFriends userFriendsSender = (UserFriends) session.createQuery("from UserFriends where friendId=:senderId and user.id=:recipientId")
                .setParameter("senderId", senderId)
                .setParameter("recipientId", recipientId)
                .getSingleResult();
        UserFriends userFriendsRecipient = (UserFriends) session.createQuery("from UserFriends where friendId=:recipientId and user.id=:senderId")
                .setParameter("recipientId", recipientId)
                .setParameter("senderId", senderId)
                .getSingleResult();
        session.delete(userFriendsSender);
        session.delete(userFriendsRecipient);
        logger.info("User had been deleted" + userFriendsSender + userFriendsRecipient);
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
