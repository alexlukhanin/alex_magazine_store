package ua.uz.alex.servlet;

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

@WebServlet("/cabinet")
public class CabinetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = UserServiceImpl.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String role = UserRole.USER.toString();
        User user = new User(email, firstName, lastName, password, role);

        if(!email.isEmpty()&& !firstName.isEmpty()&&!lastName.isEmpty()&&!password.isEmpty()) {
            userService.update(user); /// save to DB
            HttpSession session = request.getSession(true);
            session.setAttribute("userEmail", email);
            session.setAttribute("userFirstName", firstName);
            session.setAttribute("userLastName", lastName);
            session.setAttribute("userPassword", password);
            session.setAttribute("role", role);
            response.sendRedirect("/");
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            PrintHTML.printHTMLBackWithBlock(out,"'<p>All fields must be not empty</p>'" );
        }
    }
}
