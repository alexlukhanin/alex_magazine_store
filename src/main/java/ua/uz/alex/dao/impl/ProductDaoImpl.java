package ua.uz.alex.dao.impl;

import org.apache.log4j.Logger;
import ua.uz.alex.dao.ProductDao;
import ua.uz.alex.domain.Product;
import ua.uz.alex.domain.User;
import ua.uz.alex.shared.FactoryManager;
import ua.uz.alex.utils.ConnectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static Logger LOGGER = Logger.getLogger(ProductDaoImpl.class);
    private EntityManager entityManager = FactoryManager.getEntityManager();

    @Override
    public Product create(Product product) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product readById(Integer id) {
        Product product = null;
        try {
            product = entityManager.find(Product.class, id);
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product readByString(String name) {

        throw new IllegalStateException("there is no need to read by name");
    }

    @Override
    public Product update(Product product) {
        try {
            Product productToUpdate = readById(product.getId());
            entityManager.getTransaction().begin();
            entityManager.merge(productToUpdate);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void delete(Integer id) {
        try {
           Product productToDelete = readById(id);
           entityManager.getTransaction().begin();
           entityManager.remove(productToDelete);
           entityManager.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> readAll() {
        List<Product> productRecords = null;
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT products FROM Product products");
            productRecords = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
        return productRecords;
    }
}
