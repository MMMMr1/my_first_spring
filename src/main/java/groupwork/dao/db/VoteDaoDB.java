package groupwork.dao.db;

import groupwork.dao.api.IVoteDao;
import groupwork.dao.db.orm.api.IManager;
import groupwork.entity.SavedVoice;

import javax.persistence.EntityManager;
import java.util.List;
public class VoteDaoDB implements IVoteDao {
    private final IManager manager;

    public VoteDaoDB(IManager manager) {
        this.manager = manager;
    }

    @Override
    public List<SavedVoice> get() {
        EntityManager entityManager = null;
        List<SavedVoice> savedVoices;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            savedVoices  = entityManager.createQuery("FROM SavedVoice", SavedVoice.class).getResultList();
            entityManager.getTransaction().commit();
            return savedVoices;
        } catch (Exception e) {
            throw new RuntimeException("SQL exception", e.getCause());
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public long save(SavedVoice voice) {

        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(voice);
            entityManager.getTransaction().commit();
            entityManager.close();
            return voice.getId();
        } catch (Exception e) {
            throw new RuntimeException("SQL exception", e.getCause());
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
