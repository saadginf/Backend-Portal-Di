package com.di.sd.backapi.services;

import java.util.List;

import com.di.sd.backapi.dao.EmprunteurRepo;
import com.di.sd.backapi.dao.UniteRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.Emprunteur;
import com.di.sd.backapi.modals.Unite;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class EprunteurSvcImpl {
    @Autowired
    private EmprunteurRepo epteurRepo;
    @Autowired
    private UniteRepo uniteRepo;
    public Emprunteur addEmprunteur(Emprunteur auteur) {

        try {
            return epteurRepo.save(auteur);
        } catch (Exception e) {
            throw new LibbeleException("Cette Valeur existe déjà");
        }
    }

    public Iterable<Emprunteur> getAll() {
        return epteurRepo.findAll();
    }

    public List<Emprunteur> getEmByUnite(Long id) {


		Unite unite = uniteRepo.findById(id).get();
        if (unite == null) {
            throw new LibbeleException("Cet Unite n'existe pas");
        }
        List<Emprunteur> exemp = epteurRepo.findByUnite(unite);
        if (exemp == null) {
            throw new LibbeleException("Aucun exemplaire");
        }
        return exemp;
    }
}