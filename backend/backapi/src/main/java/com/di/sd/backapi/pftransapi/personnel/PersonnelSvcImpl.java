package com.di.sd.backapi.pftransapi.personnel;



import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.pftransapi.grade.GradeAvoir;
import com.di.sd.backapi.pftransapi.grade.GradePersoRepo;
import com.di.sd.backapi.pftransapi.infom.EchelleSoldeAvoir;
import com.di.sd.backapi.pftransapi.infom.EchelleSoldeAvoireRepo;
import com.di.sd.backapi.pftransapi.infom.FonctionAvoir;
import com.di.sd.backapi.pftransapi.infom.FonctionAvoireRepo;
import com.di.sd.backapi.pftransapi.infom.Notation;
import com.di.sd.backapi.pftransapi.infom.NotationsRepo;
import com.di.sd.backapi.pftransapi.unites.UniteAffAvoir;
import com.di.sd.backapi.pftransapi.unites.UniteAffRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PersonnelSvcImpl {
    @Autowired 
    PersonnelRepo persoRepo;
    @Autowired 
    GradePersoRepo gradeRepo;
    @Autowired
    UniteAffRepo uniteAffRepo;
    @Autowired
    FonctionAvoireRepo fonctionAvoireRepo;
    @Autowired
    EchelleSoldeAvoireRepo echelleSoldeAvoireRepo;
    @Autowired
    NotationsRepo notationsRepo;

    public Personnel addPerso(Personnel ouv) {

      try {
            return persoRepo.save(ouv);
       } catch (Exception e) {
          throw new LibbeleException("Problème de base de données");
        }
    }
    
    
    public Iterable<Personnel>  allPerso() {

    
            return persoRepo.findAll();
       
    }
    
    
    public GradeAvoir addGrade(GradeAvoir gradeAvoir) {
      try {
        return gradeRepo.save(gradeAvoir);
   } catch (Exception e) {
      throw new LibbeleException("Problème de base de données");
    }      

    }
    public UniteAffAvoir addUnite(UniteAffAvoir uniteAffAvoir) {
      try {
        return uniteAffRepo.save(uniteAffAvoir);
   } catch (Exception e) {
      throw new LibbeleException("Problème de base de données");
    }      

    }
    public FonctionAvoir addFonction(FonctionAvoir fonctionAvoir) {
      try {
        return fonctionAvoireRepo.save(fonctionAvoir);
   } catch (Exception e) {
      throw new LibbeleException("Problème de base de données");
    }      

    }
    public EchelleSoldeAvoir addEs(EchelleSoldeAvoir echelleSoldeAvoir) {
      try {
        return echelleSoldeAvoireRepo.save(echelleSoldeAvoir);
   } catch (Exception e) {
      throw new LibbeleException("Problème de base de données");
    }      

    }
    public Notation addNotation(Notation notations) {

        try {
      return notationsRepo.save(notations);
 } catch (Exception e) {
    throw new LibbeleException("Problème de base de données");
  }      

    }
}
