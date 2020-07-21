package com.di.sd.backapi.services;

import com.di.sd.backapi.dao.McRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.MotsClefs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotsClefsSvcImpl {
    @Autowired
    private  McRepo mcRepo;

    public MotsClefs addMc(MotsClefs mc) {

        
        try {
            return mcRepo.save(mc);
        } catch (Exception e) {
           throw new LibbeleException("Cette Valeur existe déjà");
        }
    }
    public Iterable<MotsClefs> getAll() {
        return mcRepo.findAll();
    }
}