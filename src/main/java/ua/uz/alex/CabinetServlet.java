package ua.uz.alex;

import ua.uz.alex.domain.User;
import ua.uz.alex.service.*;
import ua.uz.alex.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cabinet")
public class CabinetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserFormService userFormService = UserFormService.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        User user = new User(email, firstName, lastName, password, "user"); //  role only "user" for now
//        userFormService.saveUser(user);


        UserService userService = new UserServiceImpl();
        userService.update(user); /// save to DB

        HttpSession session = request.getSession(true);
        session.setAttribute("userEmail", email);
        session.setAttribute("userFirstName", firstName);
        session.setAttribute("userLastName", lastName);
        session.setAttribute("userPassword", password);
        session.setAttribute("role", role);

       // request.getRequestDispatcher("/").forward(request, response);
        response.sendRedirect("/");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cabinet.jsp").forward(request, response);
    }
}
