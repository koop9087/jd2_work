package data.service;

public interface UserProfileValidation {

    boolean checkLoginField(String loginField);

    boolean checkPasswordField(String passwordField);

    boolean checkEmailField(String emailField);
}
