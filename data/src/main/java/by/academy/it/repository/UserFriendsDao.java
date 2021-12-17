package by.academy.it.repository;

import by.academy.it.pojo.UserFriends;

import java.io.Serializable;
import java.util.List;

public interface UserFriendsDao {
    Serializable addFriends(UserFriends userFriends);

    void deleteFriends(Serializable id);

    UserFriends readFriends(Serializable id);

    void updateFriends(UserFriends userFriends);

    List<UserFriends> getUserFriendsList();
}
