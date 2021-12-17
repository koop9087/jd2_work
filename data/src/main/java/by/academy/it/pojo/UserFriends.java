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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userFriends", cascade = CascadeType.ALL)
    @JoinColumn(name = "user_USER_LOGIN_id")
    private User user;

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

}
