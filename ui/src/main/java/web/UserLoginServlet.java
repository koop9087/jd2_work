package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojo.UserLogin;
import by.academy.it.userService.UserLoginController;

import java.io.IOException;
import java.io.Serializable;

@WebServlet(name = "userLoginServlet", urlPatterns = "/login")
public class UserLoginServlet extends HttpServlet {
    UserLoginController userLoginController = new UserLoginController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/_user_login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if ("add-new-user-login".equals(req.getParameter("command"))) {
            UserLogin userLogin = new UserLogin(
                    req.getParameter("login"),
                    req.getParameter("password"),
                    req.getParameter("email")
            );
            if(userLoginController.isLoginValidForRegistration(userLogin.getLogin())) {
                Serializable id = userLoginController.save(userLogin);
                session.setAttribute("id", userLogin.getUser().getId());
                req.getRequestDispatcher("WEB-INF/_userAddInfo.jsp").forward(req, resp);
            }
        }
    }
}
