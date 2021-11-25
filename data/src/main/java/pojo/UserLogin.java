package pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_USER_LOGIN")
public class UserLogin implements Serializable {
    static final long serialVersionUID = 3L;

    @Id
    @Column(name = "USER_LOGIN_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @OneToOne
    private User user;

    private String login;

    private String password;  //только в базе данных (убрать)

    private String email;

    private Date date;

    private String status;

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public UserLogin(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.date = new Date();
        this.status = "new";
        //this.user = new User();
    }

    public UserLogin() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
