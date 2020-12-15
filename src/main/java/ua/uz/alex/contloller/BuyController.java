package ua.uz.alex.contloller;

import ua.uz.alex.domain.Bucket;
import ua.uz.alex.domain.Product;
import ua.uz.alex.domain.User;
import ua.uz.alex.service.BucketService;
import ua.uz.alex.service.ProductService;
import ua.uz.alex.service.UserService;
import ua.uz.alex.service.impl.BucketServiceImpl;
import ua.uz.alex.service.impl.ProductServiceImpl;
import ua.uz.alex.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/buy")
public class BuyController extends HttpServlet {
    private BucketService bucketService = BucketServiceImpl.getBucketService();
    private ProductService productService = ProductServiceImpl.getProductService();
    private UserService userService = UserServiceImpl.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        Product product = productService.readById(Integer.parseInt(productId));

        HttpSession session = request.getSession(true);
        Integer userId = (Integer)session.getAttribute("id");
        User user = userService.readById(userId);

        Bucket bucket = new Bucket();
        bucket.setProduct(product);
        bucket.setUser(user);
        bucket.setPurchaseDate(new Date());
        bucketService.create(bucket);

        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bucketId = request.getParameter("bucketId");
        bucketService.delete(Integer.parseInt(bucketId));

        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }


}
