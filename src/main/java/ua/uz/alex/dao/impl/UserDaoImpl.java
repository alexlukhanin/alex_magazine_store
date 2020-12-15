package ua.uz.alex.dao.impl;

import org.apache.log4j.Logger;
import ua.uz.alex.dao.UserDao;
import ua.uz.alex.domain.User;
import ua.uz.alex.shared.FactoryManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    private EntityManager entityManager = FactoryManager.getEntityManager();

    @Override
    public User create(User user) {
        try {
           entityManager.getTransaction().begin();
           entityManager.persist(user);
           entityManager.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User readById(Integer id) {
        User user = null;
        try {
           user= entityManager.find(User.class, id);
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User readByString(String email) {
        User user = null;
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> criteria = builder.createQuery(User.class);
            Root<User> from = criteria.from(User.class);
            criteria.select(from);
            criteria.where(builder.equal(from.get("email"), email));
            TypedQuery<User> typedQuery = entityManager.createQuery(criteria);
            user = typedQuery.getSingleResult();
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User update(User user) {
        try {
             User userToUpdate = readById(user.getId());
             entityManager.getTransaction().begin();
             entityManager.merge(userToUpdate);
             entityManager.getTransaction().commit();

        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void delete(Integer id) {
        try {
            User userToDelete = readById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(userToDelete);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
    }

    @Override
    public List<User> readAll() {
        List<User> users = null;
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT users FROM User users");
            users = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
        return users;
    }
}
