package com.di.sd.backapi.dao;

import com.di.sd.backapi.modals.Utilisateur;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepo extends CrudRepository<Utilisateur,Long>{
    
}