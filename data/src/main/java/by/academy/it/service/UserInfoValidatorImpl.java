package by.academy.it.service;

import by.academy.it.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserInfoValidatorImpl implements UserInfoValidator {

    @Override
    public boolean isLoginValid(User user) {
        boolean status = false;
        if(user.getLogin().matches("[a-z]{4,10}")) {
            status = true;
        }
        return status;
    }

    @Override
    public boolean isPasswordValid(User user) {
        boolean status = false;
        if(user.getPassword().matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")) {
            status = true;
        }
        return status;
    }

    @Override
    public boolean isEmailValid(User user) {
        boolean status = false;
        if(user.getEmail().matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")) {
            status = true;
        }
        return status;
    }

    @Override
    public boolean isFirstNameValid(User user) {
        boolean status = false;
        if(user.getFirstName().matches("^[a-zA-Z]{1,100}$")) {
            status = true;
        }
        return status;
    }

    @Override
    public boolean isSecondNameValid(User user) {
        boolean status = false;
        if(user.getSecondName().matches("^[a-zA-Z]{1,50}$")) {
            status = true;
        }
        return status;
    }

    @Override
    public boolean isUserLinkValid(User user) {
        boolean status = false;
        if(user.getUserLink().matches("^[0-9]{1,7}")) {
            status = true;
        }
        return status;
    }
}
