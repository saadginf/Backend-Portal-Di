package com.di.sd.backapi.services;

import java.util.ArrayList;
import java.util.List;

import com.di.sd.backapi.dao.ExemplaireRepo;
import com.di.sd.backapi.dao.OuvrageRepo;
import com.di.sd.backapi.dao.UniteRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.Ouvrage;
import com.di.sd.backapi.modals.Tome;
import com.di.sd.backapi.modals.Unite;
import com.di.sd.backapi.utils.StatsOuvByUnite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OuvrageSvcImpl {
    @Autowired
    private ExemplaireRepo exemplaireRepo;
    @Autowired
    private OuvrageRepo ouvRepo;
    @Autowired
    private UniteRepo uniteRepo;
    public Ouvrage addOuvrage(Ouvrage ouv) {

        try {
            ouv.getTitre().toLowerCase();
            return ouvRepo.save(ouv);
        } catch (Exception e) {
            throw new LibbeleException("Cet Ouvrage existe déja");
        }
    }

    public Iterable<Ouvrage> getAll() {
        Iterable<Ouvrage> ouvs = ouvRepo.findAll();
        for (Ouvrage ouvrage : ouvs) {
            for (Tome tome : ouvrage.getTomes())
                tome.setOuvrage(null);
        }
        return ouvs;
    }

    public List<Ouvrage> getOuvrageByTitre(String mc) {
        List<Ouvrage> ouvs = ouvRepo.findByTitreContains(mc);
        for (Ouvrage ouvrage : ouvs) {
            for (Tome tome : ouvrage.getTomes())
                tome.setOuvrage(null);
        }
        return ouvs;
    }

    public Ouvrage getOuvrageById(Long mc) {
        Ouvrage ouvs = ouvRepo.findById(mc).get();
        for (Tome tome : ouvs.getTomes())
        tome.setOuvrage(null);
        return ouvs;
    }
    
    public List<Ouvrage> getLast() {
        List<Ouvrage> ouvs = ouvRepo.findTop10ByOrderByCreatedAtDesc();
        for (Ouvrage ouvrage : ouvs) {
            for (Tome tome : ouvrage.getTomes())
                tome.setOuvrage(null);
        }
        return ouvs;
    }
    public List<StatsOuvByUnite> getStatsOuvrageById(Long mc) {
        Iterable<Unite> unit = uniteRepo.findAll();
        Ouvrage ouvs = ouvRepo.findById(mc).get();
        List<StatsOuvByUnite> sobus= new ArrayList<StatsOuvByUnite>();
        for (Tome tome : ouvs.getTomes()){
            StatsOuvByUnite sobu =new StatsOuvByUnite();
            sobu.setTome(tome.getLibbele());
            for (Unite unite : unit) {
                if(unite.getLibbele().equals("INSP")) sobu.setUniteInsp(exemplaireRepo.countByUniteAndTome(unite, tome));
                else if(unite.getLibbele().equals("7BT")) sobu.setUnite7Bt(exemplaireRepo.countByUniteAndTome(unite, tome));
                else if (unite.getLibbele().equals("3BT")) sobu.setUnit3Bt(exemplaireRepo.countByUniteAndTome(unite, tome));
                else if (unite.getLibbele().equals("2BT")) sobu.setUnite2Bt(exemplaireRepo.countByUniteAndTome(unite, tome));
                else if (unite.getLibbele().equals("BST")) sobu.setUniteBst(exemplaireRepo.countByUniteAndTome(unite, tome));
                else if (unite.getLibbele().equals("ECT")) sobu.setIniteEct(exemplaireRepo.countByUniteAndTome(unite, tome));
                else if (unite.getLibbele().equals("CIT")) sobu.setUniteCit(exemplaireRepo.countByUniteAndTome(unite, tome));
            }
            sobus.add(sobu);

        }
       
       
        return sobus;
    }
}