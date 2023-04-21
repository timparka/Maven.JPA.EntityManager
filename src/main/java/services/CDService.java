package services;

import entities.CD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CDService implements ICDService {
    private EntityManagerFactory emf;
    private EntityManager em;

    public CDService() {
        emf = Persistence.createEntityManagerFactory("musicPU");
        em = emf.createEntityManager();
    }

    @Override
    public CD findById(Long id) {
        return em.find(CD.class, id);
    }

    @Override
    public List<CD> findAll() {
        Query query = em.createQuery("SELECT c FROM CD c");
        return query.getResultList();
    }

    @Override
    public CD create(CD cd) {
        em.getTransaction().begin();
        em.persist(cd);
        em.getTransaction().commit();
        return cd;
    }

    @Override
    public CD update(CD cd) {
        em.getTransaction().begin();
        em.merge(cd);
        em.getTransaction().commit();
        return cd;
    }

    @Override
    public void delete(Long id) {
        CD cd = em.find(CD.class, id);
        if (cd != null) {
            em.getTransaction().begin();
            em.remove(cd);
            em.getTransaction().commit();
        }
    }
}