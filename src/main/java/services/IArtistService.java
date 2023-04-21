package services;

import entities.Artist;

import java.util.List;

public interface IArtistService {
    Artist findById(Long id);
    List<Artist> findAll();
    Artist create(Artist artist);
    Artist update(Artist artist);
    void delete(Long id);
}
