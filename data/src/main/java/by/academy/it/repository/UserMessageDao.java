package by.academy.it.repository;

import by.academy.it.pojo.UserFriends;
import by.academy.it.pojo.UserMessages;

import java.io.Serializable;
import java.util.List;

public interface UserMessageDao {
    Serializable saveMessage(UserMessages userMessages);

    void deleteMessage(Serializable id);

    List<UserMessages> readMessage(Serializable senderId, Serializable recipientId);

    void updateMessage(UserMessages userMessages);
}
