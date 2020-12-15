package ua.uz.alex.dao.impl;

import org.apache.log4j.Logger;
import ua.uz.alex.dao.BucketDao;
import ua.uz.alex.domain.Bucket;
import ua.uz.alex.shared.FactoryManager;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
public class BucketDaoImpl implements BucketDao {

    private static Logger LOGGER = Logger.getLogger(BucketDaoImpl.class);
    private EntityManager entityManager = FactoryManager.getEntityManager();

    @Override
    public Bucket create(Bucket bucket) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(bucket);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
        return bucket;
    }

    @Override
    public Bucket readById(Integer id) {
        Bucket bucket = null;
        try {
            bucket = entityManager.find(Bucket.class, id);
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
        return bucket;
    }

    @Override
    public Bucket readByString(String string) {
        throw new IllegalStateException("there is no need to read by string yet");
    }

    @Override
    public Bucket update(Bucket bucket) {
        throw new IllegalStateException("there is no update for bucket");
        // return null;
    }

    @Override
    public void delete(Integer id) {
        try {
           Bucket bucket = readById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(bucket);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
    }

    @Override
    public List<Bucket> readAll() {
        Query query = null;
        try {
            query = entityManager.createQuery("SELECT  buckets FROM Bucket buckets");
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
        return query.getResultList();
    }
}
