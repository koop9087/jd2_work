package by.academy.it.web.wrapper;

import javax.validation.constraints.Pattern;

public class RegistrationWrapper {
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "Incorrect password. Repeat please")
    private String password;

    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Incorrect e-mail. Repeat please")
    private String email;

    @Pattern(regexp = "^[a-zA-Z]{1,100}$", message = "Incorrect first name. Repeat please")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]{1,50}$", message = "Incorrect second name. Repeat please")
    private String secondName;

    @Pattern(regexp = "[0-9]{1,7}", message = "Incorrect url. Repeat please")
    private String url;

    @Pattern(regexp = "^[a-zA-Z]{1,20}$", message = "Incorrect status. Repeat please")
    private String profileStatus;

    @Pattern(regexp = "^[a-zA-Z]{1,10}$", message = "Incorrect gender value. Repeat please")
    private String gender;

    @Pattern(regexp = "^[a-zA-Z]{1,14}$", message = "Incorrect country value. Repeat please")
    private String country;

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
