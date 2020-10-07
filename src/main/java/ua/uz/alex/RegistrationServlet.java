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
import java.io.PrintWriter;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserFormService userFormService = UserFormService.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String role =  "user"; //request.getParameter("role");

        userFormService.saveUser(new User(email, firstName, lastName, password, role));
        UserService userService = new UserServiceImpl();

        User checkUser = userService.read(email);
        if (userService.read(email)==null) {
            userService.create(new User(email, firstName, lastName, password, role));

            HttpSession session = request.getSession(true);
            session.setAttribute("userEmail", email);
            session.setAttribute("userFirstName", firstName);
            session.setAttribute("userLastName", lastName);
            session.setAttribute("role", role);
            session.setAttribute("userPassword", password);

            response.sendRedirect("/cabinet.jsp");
//servlet code
            

        } else {
            try {
                throw new Exception("There is user with this email-address in Database already. Try another email to register.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }
}
