package by.academy.it.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {
    static final long serialVersionUID = 3L;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserFriends> userFriends;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
    private Set<UserRole> roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMessages> messages;

    private String login;

    private String password;

    private String email;

    private Date date;

    private String status;

    private String firstName;

    private String secondName;

    private String userLink;

    private String profileStatus;

    private String gender;

    private String country;

    public User() {
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.date = new Date();
        this.status = "active";
        this.userFriends = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.profileStatus = "";
        this.gender = "";
        this.country = "";
    }

    public String getId() {
        return id;
    }

    public List<UserMessages> getMessages() {
        return messages;
    }

    public void setMessages(List<UserMessages> messages) {
        this.messages = messages;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public List<UserFriends> getUserFriends() {
        return userFriends;
    }

    public void setUserFriends(List<UserFriends> userFriends) {
        this.userFriends = userFriends;
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

    public String getUserLink() {
        return userLink;
    }

    public void setUserLink(String userLink) {
        this.userLink = userLink;
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

    public String getProfileStatus() {
        return profileStatus;
    }

    public void setProfileStatus(String profileStatus) {
        this.profileStatus = profileStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
