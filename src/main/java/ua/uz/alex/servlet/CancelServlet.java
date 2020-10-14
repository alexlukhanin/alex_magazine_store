package ua.uz.alex.servlet;

import ua.uz.alex.domain.User;
import ua.uz.alex.service.UserService;
import ua.uz.alex.service.impl.UserServiceImpl;
import ua.uz.alex.utils.PrintHTML;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cancel")
public class CancelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = UserServiceImpl.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("login");
        String password = request.getParameter("password");

        User user = userService.readByString(email);
        if(!email.isEmpty()&& !password.isEmpty()) {
            if(user == null) {
                //response.sendRedirect("/login.jsp");
                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                PrintHTML.printHTMLBackWithBlock(out,"'<p>There is no user with this email address in DataBase. Try another one</p>'" );
            } else if(user.getPassword().equals(password)) {
                userService.delete(user.getId());
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                PrintHTML.printHTMLBackWithBlock(out,"'<p>Wrong password, try again, please</p>'" );
            }
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            PrintHTML.printHTMLBackWithBlock(out,"'<p>All fields must be not empty</p>'" );
        }
    }
}
