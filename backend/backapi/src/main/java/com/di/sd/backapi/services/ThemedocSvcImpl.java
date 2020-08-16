package com.di.sd.backapi.services;

import com.di.sd.backapi.dao.ThemeDocRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.ThemeDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemedocSvcImpl {
    @Autowired
    private ThemeDocRepo thDocRepo;

    public ThemeDoc addOrigine(ThemeDoc doc){

        
        try {
            return thDocRepo.save(doc);
        } catch (Exception e) {
           throw new LibbeleException("Cette Valeur existe déjà");
        }
    }
    public Iterable<ThemeDoc> getAll() {
        return thDocRepo.findAll();
    }
}