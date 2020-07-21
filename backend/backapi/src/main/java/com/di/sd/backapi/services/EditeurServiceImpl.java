package com.di.sd.backapi.services;

import com.di.sd.backapi.dao.EditeurRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.Editeur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditeurServiceImpl {
    @Autowired
    private EditeurRepo editeRepo;

    public Editeur addEditeur(Editeur editeur) {

        
        try {
            return editeRepo.save(editeur);
        } catch (Exception e) {
           throw new LibbeleException("Ajoutez un Editeur qui n'existe pas");
        }
    }
    public Iterable<Editeur> getAll(){
        return editeRepo.findAll();
    }
}