package com.di.sd.backapi.services;

import com.di.sd.backapi.dao.AuteurRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.Auteur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuteurServiceImpl {
    @Autowired
    private AuteurRepo autRepo;

    public Auteur addAuteur(Auteur auteur){

        
        try {
            return autRepo.save(auteur);
        } catch (Exception e) {
           throw new LibbeleException("Cette Valeur existe déjà");
        }
    }
    public Iterable<Auteur> getAll(){
        return autRepo.findAll();
    }
}