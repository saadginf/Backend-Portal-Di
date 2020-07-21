package com.di.sd.backapi.services;

import com.di.sd.backapi.dao.FormatRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.Format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormatServiceImpl {
    @Autowired
    private FormatRepo formatRepo;

    public Format addFormat(Format format){

        
        try {
            return formatRepo.save(format);
        } catch (Exception e) {
           throw new LibbeleException("Cette Valeur existe déjà");
        }
    }
    public Iterable<Format> getAll(){
        return formatRepo.findAll();
    }
}