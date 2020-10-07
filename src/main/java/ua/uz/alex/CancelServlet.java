package ua.uz.alex;

import ua.uz.alex.domain.User;
import ua.uz.alex.service.UserFormService;
import ua.uz.alex.service.UserService;
import ua.uz.alex.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cancel")
public class CancelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 //   private UserFormService userFormService = UserFormService.getUserService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("login");
        String password = request.getParameter("password");

      //  UserFormService userFormService = UserFormService.getUserService();
      //  User user = userFormService.getUser(login);
        UserService userService = new UserServiceImpl();
        User user = userService.readByString(email);

        if(user == null) {
            //response.sendRedirect("/login.jsp");
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("document.write('<p>There is no user with this email address in DataBase. Try another one</p>');");
            out.println("document.write('<a href=\"' + document.referrer + '\">Go Back</a>');");
            out.println("</script>");
        } else if(user.getPassword().equals(password)) {
           /* HttpSession session = request.getSession(true);
            session.setAttribute("userEmail", email);
            session.setAttribute("userFirstName", user.getFirstName());
            session.setAttribute("userLastName", user.getLastName());
            session.setAttribute("role", user.getRole());
            session.setAttribute("userPassword", password);*/

            userService.delete(user.getId());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
           // response.sendRedirect("/login.jsp");
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("document.write('<p>Wrong password, try again, please</p>');");
            out.println("document.write('<a href=\"' + document.referrer + '\">Go Back</a>');");
            out.println("</script>");

        }

       // request.getRequestDispatcher("login.jsp").forward(request, response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
