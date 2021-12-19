package by.academy.it.service;

import by.academy.it.pojo.UserFriends;
import by.academy.it.repository.UserFriendsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class UserFriendsServiceImpl implements UserFriendsService {
    @Autowired
    private UserFriendsDao userFriendsDao;

    @Override
    public Serializable addFriends(UserFriends userFriends) {
        return this.userFriendsDao.addFriends(userFriends);
    }

    @Override
    public void deleteFriends(Serializable id) {
        this.userFriendsDao.deleteFriends(id);
    }

    @Override
    public UserFriends readFriends(Serializable id) {
        return this.userFriendsDao.readFriends(id);
    }

    @Override
    public void updateFriends(UserFriends userFriends) {
        this.userFriendsDao.updateFriends(userFriends);
    }

    @Override
    public List<UserFriends> getUserFriendsList() {
        return this.userFriendsDao.getUserFriendsList();
    }
}
