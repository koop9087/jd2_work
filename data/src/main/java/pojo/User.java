package pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_USER")
public class User implements Serializable {
    static final long serialVersionUID = 4L;

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserLogin userLogin;

    private String firstName;

    private String secondName;

    private String userStatus;

    public User() {
    }

    public User(String firstName, String secondName, String userStatus) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.userStatus = userStatus;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
