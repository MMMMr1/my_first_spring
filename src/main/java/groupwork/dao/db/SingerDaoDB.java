package groupwork.dao.db;

import groupwork.dao.api.ISingerDao;
import groupwork.dao.orm.api.IManager;
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
            throw new RuntimeException("Exception in the database", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
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
            throw new RuntimeException("Exception in the database", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
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
            Singer singer = entityManager.find(Singer.class, id);
            if (singer == null) {
                throw new NullPointerException("Delete is not possible." +
                        "The performer with id = "+id+
                        " was not found in the database");
            }
//            if (singer.getVersion() != singerEntity.getVersion()) {
//                throw new OptimisticLockException("version is incorrect");
//            }
            entityManager.remove(singer);
            entityManager.getTransaction().commit();
        }catch (NullPointerException e){
            throw e;
        } catch (Exception e) {
            if(entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Exception in the database", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
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
            throw new RuntimeException("Exception in the database", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
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

            Singer singer = entityManager.find(Singer.class, id);

            if (singer == null) {
                throw new NullPointerException("Update is not possible. "+
                        "The performer with id = "+id+
                        " was not found in the database");
            }
//            if (singer.getVersion() != singerEntity.getVersion()) {
//                throw new OptimisticLockException("try again");
//            }
            entityManager.merge(singerEntity);
            entityManager.getTransaction().commit();
        }catch (NullPointerException e){
            throw e;
        } catch (Exception e) {
            if(entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Exception in the database", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
    @Override
    public Singer get(long id) {
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            Singer singer = entityManager.find(Singer.class, id);
            entityManager.getTransaction().commit();
            if (singer == null) {
                throw new NullPointerException("The performer with id = "+id+
                        " was not found in the database");
            }
            return singer;
        }catch (NullPointerException e){
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Exception in the database", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
