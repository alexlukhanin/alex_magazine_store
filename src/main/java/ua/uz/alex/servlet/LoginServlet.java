package ua.uz.alex.servlet;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import ua.uz.alex.domain.User;
import ua.uz.alex.dto.UserLogin;
import ua.uz.alex.service.UserService;
import ua.uz.alex.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = UserServiceImpl.getUserService();
    private static Logger LOGGER = Logger.getLogger(LoginServlet.class);


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // test block!!!

        int integerValueForTest = 0;
        try {
            integerValueForTest = 5/0;
        } catch (Exception e) {
            LOGGER.error(e);
        }
        // ==============================


        User user = userService.readByString(email);

        if (user != null && user.getPassword().equals(password)) {
            UserLogin userLogin = new UserLogin();
            userLogin.destinationUrl = "cabinet.jsp";
            userLogin.userEmail = user.getEmail();
           /* String json = new Gson().toJson(userLogin);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);*/
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Login success");
        } else {
           // response.sendRedirect("/index.jsp");
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Login failed");
        }



    }
}
