package groupwork.dao.db;


import groupwork.dao.api.IGenreDao;
import groupwork.dao.db.orm.api.IManager;
import groupwork.entity.Genre;


import javax.persistence.EntityManager;
import java.util.List;

public class GenreDaoDB implements IGenreDao {
    private IManager manager;

    public GenreDaoDB(IManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Genre> get() {
        EntityManager entityManager = null;
        List<Genre> resultList;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            resultList = entityManager.createQuery("from Genre", Genre.class).getResultList();
            entityManager.getTransaction().commit();
            return resultList;

        } catch (Exception e) {
            throw new RuntimeException("DataBase error", e);
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
            Genre genreEntity = entityManager.find(Genre.class, id);
            entityManager.getTransaction().commit();
            return genreEntity != null;

        } catch (Exception e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void delete(Genre genreEntity) {
        long id = genreEntity.getId();
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            genreEntity = entityManager.find(Genre.class, id);
            if (genreEntity == null) {
                throw new NullPointerException("Delete is not possible. The singer wasn't found in the database");
            }
                entityManager.remove(genreEntity);
                entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void insert(Genre genreEntity) {
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(genreEntity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void update(Genre genreEntity) {
        long id = genreEntity.getId();
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();

            Genre genreEntityDB = entityManager.find(Genre.class, id);

            if (genreEntityDB == null) {
                throw new NullPointerException("Update is not possible. The genre wasn't found in the database");
            }
            entityManager.merge(genreEntity);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public Genre get(long id) {
        EntityManager entityManager = null;
        Genre genreEntity;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            genreEntity = entityManager.find(Genre.class, id);
            entityManager.getTransaction().commit();
            if (genreEntity == null) {
                throw new NullPointerException("The genre wasn't found in the database");
            }
            return genreEntity;
        } catch (Exception e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null  && entityManager.isOpen()) {
                entityManager.close();
            }
        }

    }
}

