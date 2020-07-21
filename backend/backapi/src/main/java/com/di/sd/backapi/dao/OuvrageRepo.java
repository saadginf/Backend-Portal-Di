package com.di.sd.backapi.dao;

import java.util.List;

import com.di.sd.backapi.modals.Ouvrage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OuvrageRepo extends CrudRepository<Ouvrage,Long>{
    List<Ouvrage> findByTitre(String titre);
    List<Ouvrage> findByTitreContains(String mc);

    public List<Ouvrage> findTop10ByOrderByCreatedAtDesc();
}