package ua.uz.alex.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.uz.alex.dao.ProductDao;
import ua.uz.alex.dao.impl.ProductDaoImpl;
import ua.uz.alex.domain.Product;
import ua.uz.alex.service.ProductService;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    public ProductServiceImpl() {

        try {
            productDao = new ProductDaoImpl();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Product create(Product t) {
        return productDao.create(t);
    }

    @Override
    public Product read(Integer id) {
        return null;
    }

    @Override
    public Product read(String name) {
        return null;
    }


    @Override
    public Product update(Product t) {
        return productDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        productDao.delete(id);
    }

    @Override
    public List<Product> readAll() {
        return productDao.readAll();
    }

}