package com.di.sd.backapi.services;

import java.util.List;

import com.di.sd.backapi.dao.OuvrageRepo;
import com.di.sd.backapi.dao.TomeRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.Ouvrage;
import com.di.sd.backapi.modals.Tome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TomeSvcImpl {
    @Autowired
    private TomeRepo tomeRepo;
    @Autowired
    private OuvrageRepo oRepo;
    public Tome addAuteur(Tome tome){

        
        try {
            return tomeRepo.save(tome);
        } catch (Exception e) {
           throw new LibbeleException("Ce Tome existe déjà");
        }
    }
    public Iterable<Tome> getAll() {
        Iterable<Tome> tomes =tomeRepo.findAll();
        for (Tome tome : tomes) {
            tome.setOuvrage(null);
        }
        return tomes;
    }
    public List<Tome> findByOuvrage(Long id){
        Ouvrage ouvrage = oRepo.findById(id).get();
        List<Tome> tomes= tomeRepo.findByOuvrageOrderByLibbele(ouvrage);
        for (Tome tome : tomes) {
            tome.setOuvrage(null);
        }
        return tomes;
    }
}