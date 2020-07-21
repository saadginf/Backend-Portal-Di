package com.di.sd.backapi.services;

import com.di.sd.backapi.dao.EventTypeRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.TypeEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventTypeEvcImpl {
    @Autowired
    private EventTypeRepo eventTypeRepo;

    public TypeEvent addFormat(TypeEvent format){

        
        try {
            return eventTypeRepo.save(format);
        } catch (Exception e) {
           throw new LibbeleException("Cette Valeur existe déjà");
        }
    }
    public Iterable<TypeEvent> getAll(){
        return eventTypeRepo.findAll();
    }
}