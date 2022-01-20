package by.academy.it.web.wrapper;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegistrationWrapper {
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "Incorrect password. Repeat please")
    private String password;

    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Incorrect e-mail. Repeat please")
    private String email;

    @Size(max = 100)
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Incorrect first name. Repeat please")
    private String firstName;

    @Size(max = 50)
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Incorrect second name. Repeat please")
    private String secondName;

    @Size(max = 7)
    @Pattern(regexp = "[0-9]*", message = "Incorrect url. Repeat please")
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
