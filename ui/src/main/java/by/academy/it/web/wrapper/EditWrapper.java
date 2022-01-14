package by.academy.it.web.wrapper;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EditWrapper {
    @Size(max = 100)
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Incorrect first name. Repeat please")
    private String wrapperFirstName;

    @Size(max = 50)
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Incorrect second name. Repeat please")
    private String wrapperSecondName;

    @Pattern(regexp = "(^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$)|(^$)", message = "Incorrect e-mail. Repeat please")
    private String wrapperEmail;

    @Size(max = 7)
    @Pattern(regexp = "[0-9]*", message = "Incorrect url. Repeat please")
    private String wrapperUrl;

    @Size(max = 20)
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Incorrect status. Repeat please")
    private String wrapperProfileStatus;

    @Size(max = 10)
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Incorrect gender value. Repeat please")
    private String wrapperGender;

    @Size(max = 14)
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Incorrect country value. Repeat please")
    private String wrapperCountry;

    public String getWrapperFirstName() {
        return wrapperFirstName;
    }

    public void setWrapperFirstName(String wrapperFirstName) {
        this.wrapperFirstName = wrapperFirstName;
    }

    public String getWrapperSecondName() {
        return wrapperSecondName;
    }

    public void setWrapperSecondName(String wrapperSecondName) {
        this.wrapperSecondName = wrapperSecondName;
    }

    public String getWrapperEmail() {
        return wrapperEmail;
    }

    public void setWrapperEmail(String wrapperEmail) {
        this.wrapperEmail = wrapperEmail;
    }

    public String getWrapperUrl() {
        return wrapperUrl;
    }

    public void setWrapperUrl(String wrapperUrl) {
        this.wrapperUrl = wrapperUrl;
    }

    public String getWrapperProfileStatus() {
        return wrapperProfileStatus;
    }

    public void setWrapperProfileStatus(String wrapperProfileStatus) {
        this.wrapperProfileStatus = wrapperProfileStatus;
    }

    public String getWrapperGender() {
        return wrapperGender;
    }

    public void setWrapperGender(String wrapperGender) {
        this.wrapperGender = wrapperGender;
    }

    public String getWrapperCountry() {
        return wrapperCountry;
    }

    public void setWrapperCountry(String wrapperCountry) {
        this.wrapperCountry = wrapperCountry;
    }
}
