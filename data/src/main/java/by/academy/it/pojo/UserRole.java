package by.academy.it.pojo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserRole{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", users=").append(users);
        sb.append('}');
        return sb.toString();
    }
}
