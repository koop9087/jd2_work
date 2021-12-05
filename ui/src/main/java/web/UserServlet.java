package web;

import data.UserDaoImplements;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojo.User;


import java.io.IOException;
import java.io.Serializable;

@WebServlet(name = "userServlet", urlPatterns = "/login/addedInfo")
public class UserServlet extends HttpServlet {
    UserDaoImplements userDaoImplements = new UserDaoImplements();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("add-new-user-info".equals(req.getParameter("command"))) {
            HttpSession session = req.getSession();
            Serializable id = (Serializable) session.getAttribute("id");
            User user = userDaoImplements.readUser(id);
            user.setFirstName(req.getParameter("firstName"));
            user.setSecondName(req.getParameter("secondName"));
            user.setUserStatus("created");
            user.setRole("user");
            userDaoImplements.updateUser(user);
        }
    }
}
