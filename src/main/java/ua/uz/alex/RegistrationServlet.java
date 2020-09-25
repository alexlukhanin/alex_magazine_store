package ua.uz.alex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = UserService.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        userService.saveUser(new User(firstName, lastName, email, password));

        HttpSession session = request.getSession(true);
        session.setAttribute("userEmail", email);
        session.setAttribute("userFirstName", firstName);
        session.setAttribute("userLastName", lastName);
        session.setAttribute("userPassword", password);

        request.getRequestDispatcher("cabinet.jsp").forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }
}
