package ua.uz.alex;

import ua.uz.alex.domain.User;
import ua.uz.alex.service.UserFormService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserFormService userFormService = UserFormService.getUserService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserFormService userFormService = UserFormService.getUserService();
        User user = userFormService.getUser(login);

        if(user == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        if(user.getPassword().equals(password)) {
            request.setAttribute("userEmail", login);
            request.getRequestDispatcher("cabinet.jsp").forward(request, response);
        }

       // request.getRequestDispatcher("login.jsp").forward(request, response);
        response.sendRedirect("/login.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
