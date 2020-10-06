package ua.uz.alex;

import ua.uz.alex.domain.Product;
import ua.uz.alex.domain.User;
import ua.uz.alex.service.ProductService;
import ua.uz.alex.service.UserService;
import ua.uz.alex.service.impl.ProductServiceImpl;
import ua.uz.alex.service.impl.UserServiceImpl;

public class MainTestApp {

    public static void main(String[] args) {

       /* UserService userService = new UserServiceImpl();
        userService.create(new User("user@test.com", "test", "test", "test", "test"));*/
        ProductService productService = new ProductServiceImpl();
        productService.create(new Product("Ipod", "Music player", 125.00));

    }

}
