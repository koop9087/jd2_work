package by.academy.it.web;

import by.academy.it.repository.UserImplements;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

                                //@WebServlet(name = "signInServlet", urlPatterns = "/sign")
//public class UserSignInServlet extends HttpServlet {
//    UserImplements userLoginImplements = new UserImplements();
//    UserDaoImplements userDaoImplements = new UserDaoImplements();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("WEB-INF/_user_sign_in.jsp").forward(req, resp);
//    }
//
////   @Override
////   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////       if ("user-sign-in".equals(req.getParameter("command"))) {
////           User userLogin = userLoginImplements.readUserLoginByLoginAndPassword(
////                   req.getParameter("login"),
////                   req.getParameter("password"));
////           if (userLogin != null) {
////               req.setAttribute("user", userDaoImplements.getUserList());
////               req.getRequestDispatcher("WEB-INF/_user_profile_info.jsp").forward(req, resp);
////           }
////       }
////   }
//}
