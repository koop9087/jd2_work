package by.academy.it.service;

import by.academy.it.pojo.UserFriends;

import java.io.Serializable;
import java.util.List;

public interface UserFriendsService {
    Serializable addFriends(UserFriends userFriends);

    void deleteFriends(Serializable id);

    UserFriends readFriends(Serializable id);

    void updateFriends(UserFriends userFriends);

    List<UserFriends> getUserFriendsList();
}
