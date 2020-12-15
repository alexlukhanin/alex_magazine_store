package ua.uz.alex;

import ua.uz.alex.dao.impl.ProductDaoImpl;
import ua.uz.alex.domain.Bucket;
import ua.uz.alex.domain.Product;
import ua.uz.alex.domain.User;
import ua.uz.alex.domain.UserRole;
import ua.uz.alex.service.BucketService;
import ua.uz.alex.service.ProductService;
import ua.uz.alex.service.UserService;
import ua.uz.alex.service.impl.BucketServiceImpl;
import ua.uz.alex.service.impl.ProductServiceImpl;
import ua.uz.alex.service.impl.UserServiceImpl;


// testing main class - enter point
public class Main {

    public static void main(String[] args) {

        ProductService productService = ProductServiceImpl.getProductService();
        BucketService bucketService = BucketServiceImpl.getBucketService();
        UserService userService = UserServiceImpl.getUserService();


        Product product = new Product();
        product.setName("Austin Star2");
        product.setDescription("Lone Star State's periodical");
        product.setPrice(120.0);
        productService.create(product);

        //productService.delete(28);
       // System.out.println(productService.readById(27));
       /* List<Product> productList = productService.readAll();
        for (Product p :
                productList) {
            System.out.println(p.getName() + " " + p.getDescription() + " "  + p.getPrice());
        }*/


    }
}
