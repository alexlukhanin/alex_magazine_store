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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
   // private UserFormService userFormService = UserFormService.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String role =  "user"; //request.getParameter("role");

      //  userFormService.saveUser(new User(email, firstName, lastName, password, role));
        UserService userService = new UserServiceImpl();



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
                e.printStackTrace();

                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                out.println("<script type=\"text/javascript\">");
                out.println("document.write('<p>There is user with this email in Database already. Try another email to register.</p>');");
                out.println("document.write('<a href=\"' + document.referrer + '\">Go Back</a>');");
                out.println("</script>");

            }
        }


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }
}
