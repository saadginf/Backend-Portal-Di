package com.di.sd.backapi.services;

import com.di.sd.backapi.dao.GradeRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.Grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeSvcImpl {
    @Autowired
    private GradeRepo grDocRepo;

    public Grade addGrade(Grade doc){

        
        try {
            return grDocRepo.save(doc);
        } catch (Exception e) {
           throw new LibbeleException("Cette Valeur existe déjà");
        }
    }
    public Iterable<Grade> getAll(){
        return grDocRepo.findAll();
    }
}