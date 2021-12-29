package by.academy.it.service;

import by.academy.it.pojo.UserMessages;
import by.academy.it.repository.UserMessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional(propagation = Propagation.NESTED)
public class UserMessageServiceImpl implements UserMessageService {

    @Autowired
    UserMessageDao userMessageDao;

    @Override
    public Serializable saveMessage(UserMessages userMessages) {
        return this.userMessageDao.saveMessage(userMessages);
    }

    @Override
    public void deleteMessage(Serializable id) {
        this.userMessageDao.deleteMessage(id);
    }

    @Override
    public List<UserMessages> readMessage(Serializable senderId, Serializable recipientId) {
        return this.userMessageDao.readMessage(senderId, recipientId);
    }

    @Override
    public void updateMessage(UserMessages userMessages) {
        this.userMessageDao.updateMessage(userMessages);
    }
}
