package com.di.sd.backapi.services;

import com.di.sd.backapi.dao.TypeRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl {
    @Autowired
    private TypeRepo typeRepo;

    public Type addType(Type type){

        
        try {
            return typeRepo.save(type);
        } catch (Exception e) {
           throw new LibbeleException("Ajoutez un Type qui n'existe pas");
        }
    }
    public Iterable<Type> getAll(){
        return typeRepo.findAll();
    }
}