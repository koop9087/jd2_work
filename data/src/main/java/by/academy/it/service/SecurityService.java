package by.academy.it.service;

public interface SecurityService {

    String findLoggedInLogin();

    void autoLogin(String login, String password);
}
