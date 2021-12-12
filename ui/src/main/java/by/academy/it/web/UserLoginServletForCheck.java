package by.academy.it.web;

import by.academy.it.service.UserLoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "servletCheck", urlPatterns = "/checkServlet")
public class UserLoginServletForCheck extends HttpServlet {

    UserLoginService userLoginService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lineLogin = req.getParameter("login");
        //boolean checked = userLoginService.(lineLogin);
        //if(!checked) {
          //  resp.getWriter().write("this login is exists");
        //}
    }
}
