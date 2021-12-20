package by.academy.it.service;

import by.academy.it.pojo.User;

public interface UserInfoValidator {
    boolean isLoginValid(User user);

    boolean isPasswordValid(User user);

    boolean isEmailValid(User user);

    boolean isFirstNameValid(User user);

    boolean isSecondNameValid(User user);

    boolean isUserLinkValid(User user);
}
