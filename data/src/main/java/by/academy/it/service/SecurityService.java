package by.academy.it.service;

public interface SecurityService {

    String findLoggedInLogin();

    boolean autoLogin(String login, String password);
}
