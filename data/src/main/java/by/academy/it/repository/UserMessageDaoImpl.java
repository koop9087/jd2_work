package by.academy.it.repository;

import by.academy.it.pojo.UserFriends;
import by.academy.it.pojo.UserMessages;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class UserMessageDaoImpl implements UserMessageDao {
    public static final Logger logger = Logger.getLogger(
            UserMessageDaoImpl.class.getName());

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Serializable saveMessage(UserMessages userMessages) {
        Session session = this.sessionFactory.getCurrentSession();
        Serializable id = session.save(userMessages);
        logger.info("Message had been saved + " + userMessages.getValue());
        return id;
    }

    @Override
    public void deleteMessage(Serializable id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserMessages loadedUserMessage = (UserMessages) session.load(UserMessages.class, id);
        session.delete(loadedUserMessage);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserMessages> readMessage(Serializable senderId, Serializable recipientId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserMessages> messages = session
                .createQuery("from UserMessages where (user.id=:senderId and recipientId=:recipientId) " +
                        "or (user.id=:recipientId and recipientId=:senderId)")
                .setParameter("senderId", senderId)
                .setParameter("recipientId", recipientId)
                .list();
        logger.info("User had been readed successfully : " + messages);
        return messages;
    }

    @Override
    public void updateMessage(UserMessages userMessages) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(userMessages);
    }
}
