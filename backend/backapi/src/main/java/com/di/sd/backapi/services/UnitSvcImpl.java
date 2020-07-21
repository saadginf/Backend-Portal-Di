package com.di.sd.backapi.services;
import com.di.sd.backapi.dao.UniteRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.Exemplaire;
import com.di.sd.backapi.modals.Unite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitSvcImpl {
    @Autowired
    private UniteRepo uniteRepo;

    public Unite addUnite(Unite unite) {

        
        try {
            return uniteRepo.save(unite);
        } catch (Exception e) {
           throw new LibbeleException("Cette Valeur existe déjà");
        }
    }
    public Iterable<Unite> getAll() {
        Iterable<Unite> ouvs = uniteRepo.findAll();
        for (Unite unites : ouvs) {
            for (Exemplaire tome : unites.getExeplaires())
               tome.setUnite(null); 
        }
        return ouvs;
    }
    public Unite getUniteById(Long id) {

        Unite exemp = uniteRepo.findById(id).get();

        if (exemp == null) {
            throw new LibbeleException("Cet unite n'existe pas");
        }
    
  
        return exemp;
    }
}