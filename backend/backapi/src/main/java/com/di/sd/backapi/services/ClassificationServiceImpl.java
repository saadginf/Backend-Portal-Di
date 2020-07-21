package com.di.sd.backapi.services;

import com.di.sd.backapi.dao.ClassificationRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.Classification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassificationServiceImpl {
    @Autowired
    private ClassificationRepo classificationRepo;

    public Classification addClassification(Classification classs){

        
        try {
            return classificationRepo.save(classs);
        } catch (Exception e) {
           throw new LibbeleException("Cette Valeur existe déjà");
        }
    }
    public Iterable<Classification> getAll() {
        return classificationRepo.findAll();
    }
}