package com.di.sd.backapi.services;

import java.util.Date;
import java.util.List;

import com.di.sd.backapi.dao.EmpruntRepo;
import com.di.sd.backapi.dao.ExemplaireRepo;
import com.di.sd.backapi.dao.UniteRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.Emprunt;
import com.di.sd.backapi.modals.Exemplaire;
import com.di.sd.backapi.modals.Unite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmprunSvcImpl {
    @Autowired
    ExemplaireRepo exRepo;
    @Autowired
    EmpruntRepo eptRepo;
    @Autowired
    UniteRepo unRepo;
    public  Emprunt borrowBook(Emprunt emprunt) {
    
 
  Exemplaire exemp   = exRepo.findById(emprunt.getExemplaire().getId()).get();
  if (exemp.isExiste()) {
    try {
      Emprunt ept = eptRepo.save(emprunt);
       
     exemp.setExiste(false);
     exRepo.save(exemp);
   
       return ept;
   
      } catch (Exception e) {
         throw new LibbeleException("Erreur du serveur");
    }
  } else {
   throw new RuntimeException("Cet Exemplaire est déjà pris");
  }
 
      
}

  public String returnBook(Long emprunt, Date dateRetour){
    Emprunt ept = eptRepo.findById(emprunt).get();
    Exemplaire exemp   = exRepo.findById(ept.getExemplaire().getId()).get();
    exemp.setExiste(true);
    exRepo.save(exemp);
    ept.setDateRetour(dateRetour);
    eptRepo.save(ept);
    return "done";
  }
   

    public List<Emprunt> getBorrowed(Long id){
      
      Unite unite = unRepo.findById(id).get();
     return eptRepo.findByExemplaire_UniteAndDateRetourIsNull(unite);

    }
}