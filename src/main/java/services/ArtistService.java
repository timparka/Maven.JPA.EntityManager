package services;

import entities.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ArtistService implements IArtistService {
    private EntityManagerFactory emf;
    private EntityManager em;

    public ArtistService() {
        emf = Persistence.createEntityManagerFactory("musicPU");
        em = emf.createEntityManager();
    }

    @Override
    public Artist findById(Long id) {
        return em.find(Artist.class, id);
    }

    @Override
    public List<Artist> findAll() {
        Query query = em.createQuery("SELECT a FROM Artist a");
        return query.getResultList();
    }

    @Override
    public Artist create(Artist artist) {
        em.getTransaction().begin();
        em.persist
                (artist);
        em.getTransaction().commit();
        return artist;
    }
    @Override
    public Artist update(Artist artist) {
        em.getTransaction().begin();
        em.merge(artist);
        em.getTransaction().commit();
        return artist;
    }

    @Override
    public void delete(Long id) {
        Artist artist = em.find(Artist.class, id);
        if (artist != null) {
            em.getTransaction().begin();
            em.remove(artist);
            em.getTransaction().commit();
        }
    }
}