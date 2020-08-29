package com.di.sd.backapi.services;


import com.di.sd.backapi.dao.ExemplaireRepo;
import com.di.sd.backapi.dao.OuvrageRepo;
import com.di.sd.backapi.dao.UniteRepo;
import com.di.sd.backapi.modals.StatsBiblio;
import com.di.sd.backapi.modals.Unite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StatsServiceImpl {
    @Autowired
    ExemplaireRepo expRepo;
    @Autowired
    UniteRepo uniter;
    @Autowired
    OuvrageRepo ouvRepo;
    @Autowired 
    OuvrageSvcImpl ouvrageSvcImpl;
    public StatsBiblio getStates(){
        StatsBiblio stsBiblio = new StatsBiblio(); 
        stsBiblio.setTotal( expRepo.count());
        Iterable<Unite> unites = uniter.findAll();
        for (Unite unite : unites) {
          
            if(unite.getLibbele().equals("INSP")) stsBiblio.setUniteInsp(expRepo.countByUnite(unite));
            else if(unite.getLibbele().equals("7BT")) stsBiblio.setUnite7Bt(expRepo.countByUnite(unite));
            else if (unite.getLibbele().equals("3BT")) stsBiblio.setUnit3Bt(expRepo.countByUnite(unite)); 
            else if (unite.getLibbele().equals("2BT")) stsBiblio.setUnite2Bt(expRepo.countByUnite(unite)); 
            else if (unite.getLibbele().equals("BST")) stsBiblio.setUniteBst(expRepo.countByUnite(unite));
            else if (unite.getLibbele().equals("ECT")) stsBiblio.setIniteEct(expRepo.countByUnite(unite));
            else if (unite.getLibbele().equals("CIT")) stsBiblio.setUniteCit(expRepo.countByUnite(unite));
            else if (unite.getLibbele().equals("BGE")) stsBiblio.setUniteBge(expRepo.countByUnite(unite));
        }
        
        
        stsBiblio.setBestOuvrages(ouvrageSvcImpl.getLast());
        stsBiblio.setLastOuvrages(ouvrageSvcImpl.getLast());
        return stsBiblio;

    }
}