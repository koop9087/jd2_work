package by.academy.it.validator;

import by.academy.it.pojo.User;
import by.academy.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class UserValidator implements Validator {

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserService.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Required");
        if(user.getLogin().length() < 4 || user.getLogin().length() > 8) {
            errors.rejectValue("login", "Size.userForm.login");
        }

        if(userService.findByLogin(user.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.userForm.login");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if(!user.getPassword().matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");
        if(!user.getPassword().matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")) {
            errors.rejectValue("email", "Different.userForm.password");
        }
    }
}
