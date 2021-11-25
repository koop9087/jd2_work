package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.UserLogin;
import userService.UserLoginController;

import java.io.IOException;

@WebServlet(name = "userLoginServlet", urlPatterns = "/login")
public class UserLoginServlet extends HttpServlet {
    UserLoginController userLoginController = new UserLoginController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/_user_login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("add-new-user-login".equals(req.getParameter("command"))) {
            UserLogin userLogin = new UserLogin(
                    req.getParameter("login"),
                    req.getParameter("password"),
                    req.getParameter("email")
            );
            if(userLoginController.isLoginValidForRegistration(userLogin.getLogin())) {
                userLoginController.save(userLogin);
            }
        }
    }
}
