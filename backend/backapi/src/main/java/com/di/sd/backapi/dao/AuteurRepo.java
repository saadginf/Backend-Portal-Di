package com.di.sd.backapi.dao;

import com.di.sd.backapi.modals.Auteur;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepo extends CrudRepository<Auteur, Long> {
    
}