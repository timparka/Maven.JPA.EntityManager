package services;

import entities.CD;

import java.util.List;

public interface ICDService {
    CD findById(Long id);
    List<CD> findAll();
    CD create(CD cd);
    CD update(CD cd);
    void delete(Long id);
}
