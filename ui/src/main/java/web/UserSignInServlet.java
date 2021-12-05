package web;

import data.UserDaoImplements;
import data.UserLoginImplements;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.UserLogin;

import java.io.IOException;

@WebServlet(name = "signInServlet", urlPatterns = "/sign")
public class UserSignInServlet extends HttpServlet {
    UserLoginImplements userLoginImplements = new UserLoginImplements();
    UserDaoImplements userDaoImplements = new UserDaoImplements();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/_user_sign_in.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("user-sign-in".equals(req.getParameter("command"))) {
            UserLogin userLogin = userLoginImplements.readUserLoginByLoginAndPassword(
                    req.getParameter("login"),
                    req.getParameter("password"));
            if (userLogin != null) {
                req.setAttribute("user", userDaoImplements.getUserList(userLogin.getUser().getId()));
                req.getRequestDispatcher("WEB-INF/_user_profile_info.jsp").forward(req, resp);
            }
        }
    }
}
