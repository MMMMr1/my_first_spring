package groupwork.dao.db;

import groupwork.dao.api.ISingerDao;
import groupwork.dao.db.orm.api.IManager;
import groupwork.entity.Singer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import java.util.List;

public class SingerDaoDB implements ISingerDao {
    static Logger logger = LogManager.getLogger();
    private final IManager manager;

    public SingerDaoDB(IManager manager) {
        this.manager = manager;
    }
    @Override
    public List<Singer> get() {
        EntityManager entityManager = null;
        List<Singer> resultList;
        logger.info("info");

        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            resultList = entityManager.createQuery("from Singer", Singer.class).getResultList();
            entityManager.getTransaction().commit();
            return resultList;
        } catch (Exception e) {
            logger.error("first log");
            throw new RuntimeException("DataBase error", e);
        } finally {
            if(entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean exist(long id) {
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            Singer singerEntity = entityManager.find(Singer.class, id);
            entityManager.getTransaction().commit();
            return singerEntity != null;

        } catch (Exception e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if(entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void delete(Singer singerEntity) {
        long id = singerEntity.getId();
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            singerEntity = entityManager.find(Singer.class, id);
            if(singerEntity == null) {
                throw new NullPointerException("Delete is not possible. The singer wasn't found in the database");
            }
                entityManager.remove(singerEntity);
                entityManager.getTransaction().commit();
        } catch ( Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("DataBase error", e);
        } finally {
            if(entityManager != null  && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void insert(Singer singerEntity) {
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(singerEntity);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if(entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void update(Singer singerEntity) {
        long id = singerEntity.getId();
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();

            Singer singerEntityDB = entityManager.find(Singer.class, id);

            if(singerEntityDB == null) {
                throw new NullPointerException("Update is not possible. The singer wasn't found in the database");
            }
                entityManager.merge(singerEntity);
                entityManager.getTransaction().commit();


        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("DataBase error", e);
        } finally {
            if(entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
    @Override
    public Singer get(long id) {
        EntityManager entityManager = null;
        Singer singerEntity;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            singerEntity = entityManager.find(Singer.class, id);
            entityManager.getTransaction().commit();

            if(singerEntity == null){
                throw new NullPointerException("The singer wasn't found in the database");
            }

        } catch (Exception e) {
            throw new RuntimeException("Ошибка БД", e);
        } finally {
            if(entityManager != null  && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return singerEntity;
    }
}
