package by.academy.it.web;

import by.academy.it.service.UserLoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
@RequestMapping("/check")
public class CheckController {

    @Autowired
    UserLoginService userLoginService;

    public void checkLogin(@RequestParam String login) {
        //todo
        //boolean checked = userLoginService.(lineLogin);
        //if(!checked) {
          //  resp.getWriter().write("this login is exists");
        //}
    }
}
