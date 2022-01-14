package by.academy.it.service;

import by.academy.it.pojo.UserFriends;

import java.io.Serializable;
import java.util.List;

public interface UserFriendsService {
    Serializable addFriends(UserFriends userFriends);

    void deleteFriends(Serializable senderId, Serializable recipientId);

    UserFriends readFriends(Serializable id);

    void updateFriends(UserFriends userFriends);

    List<UserFriends> getUserFriendsList();
}
