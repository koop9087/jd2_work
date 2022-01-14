package by.academy.it.web.wrapper;

import javax.validation.constraints.Pattern;

public class SignWrapper {
    @Pattern(regexp = "[a-z]{6,18}", message = "User with this login not found")
    private String login;

    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "Incorrect password. User with this password not found")
    private String password;

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
}
