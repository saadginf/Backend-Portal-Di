package com.di.sd.backapi.dao;

import com.di.sd.backapi.modals.Personne;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepo extends CrudRepository<Personne, Long> {
    
}