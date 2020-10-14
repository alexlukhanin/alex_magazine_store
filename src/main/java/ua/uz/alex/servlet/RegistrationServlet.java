package ua.uz.alex.servlet;

import org.apache.log4j.Logger;
import ua.uz.alex.domain.User;
import ua.uz.alex.domain.UserRole;
import ua.uz.alex.service.*;
import ua.uz.alex.service.impl.*;
import ua.uz.alex.utils.PrintHTML;

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
    private static Logger LOGGER = Logger.getLogger(RegistrationServlet.class);
    private UserService userService = UserServiceImpl.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String role =  UserRole.USER.toString();

        if(!email.isEmpty()&& !firstName.isEmpty()&&!lastName.isEmpty()&&!password.isEmpty()) {
            if (userService.readByString(email)==null) {
                userService.create(new User(email, firstName, lastName, password, role));

                HttpSession session = request.getSession(true);
                session.setAttribute("userEmail", email);
                session.setAttribute("userFirstName", firstName);
                session.setAttribute("userLastName", lastName);
                session.setAttribute("role", role);
                session.setAttribute("userPassword", password);

                response.sendRedirect("/cabinet.jsp");
            } else {
                try {
                    throw new Exception("There is user with this email-address in Database already. Try another email to register.");
                } catch (Exception e) {
                    LOGGER.error(e);
                    PrintWriter out = response.getWriter();
                    response.setContentType("text/html");
                    PrintHTML.printHTMLBackWithBlock(out,"'<p>There is user with this email in Database already. Try another email to register.</p>'" );
                }
            }
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            PrintHTML.printHTMLBackWithBlock(out,"'<p>All fields must be not empty</p>'" );
        }
    }
}
