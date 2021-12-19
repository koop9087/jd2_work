package by.academy.it.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_USER_FRIENDS")
public class UserFriends implements Serializable {
    static final long serialVersionUID = 3L;

    @Id
    @Column(name = "USER_FRIENDS_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    private String friendId;

    private String status;

    public UserFriends() {
    }

    public UserFriends(User user) {
        this.user = user;
        this.status = "has";
    }

    public User getUserLogin() {
        return user;
    }

    public void setUserLogin(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }
}
