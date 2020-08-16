package com.di.sd.backapi.services;

import com.di.sd.backapi.dao.TypeDocRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.TypeDoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeDocSvcImpl {
    @Autowired
    private TypeDocRepo typDocRepo;

    public TypeDoc addOrigine(TypeDoc doc){

        
        try {
            return typDocRepo.save(doc);
        } catch (Exception e) {
           throw new LibbeleException("Cette Valeur existe déjà");
        }
    }
    public Iterable<TypeDoc> getAll(){
        return typDocRepo.findAll();
    }
}