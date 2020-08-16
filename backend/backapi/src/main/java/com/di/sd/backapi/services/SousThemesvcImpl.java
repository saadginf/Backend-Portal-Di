package com.di.sd.backapi.services;

import com.di.sd.backapi.dao.SousThemeRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.SousTheme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SousThemesvcImpl {
    @Autowired
    private SousThemeRepo sousThemeRepo;

    public SousTheme addOrigine(SousTheme doc){

        
        try {
            return sousThemeRepo.save(doc);
        } catch (Exception e) {
           throw new LibbeleException("Erreur interne");
        }
    }
    public Iterable<SousTheme> getAll(){
        return sousThemeRepo.findAll();
    }
}