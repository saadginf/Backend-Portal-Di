package com.di.sd.backapi.pftransapi.personnel;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.pftransapi.grade.GradeAvoir;
import com.di.sd.backapi.pftransapi.grade.GradePerso;
import com.di.sd.backapi.pftransapi.grade.GradePersoRepo;
import com.di.sd.backapi.pftransapi.grade.GradeRepoP;
import com.di.sd.backapi.pftransapi.infom.EchelleSolde;
import com.di.sd.backapi.pftransapi.infom.EchelleSoldeAvoir;
import com.di.sd.backapi.pftransapi.infom.EchelleSoldeAvoireRepo;
import com.di.sd.backapi.pftransapi.infom.EchelleSoldeRepo;
import com.di.sd.backapi.pftransapi.infom.Fonction;
import com.di.sd.backapi.pftransapi.infom.FonctionAvoir;
import com.di.sd.backapi.pftransapi.infom.FonctionAvoireRepo;
import com.di.sd.backapi.pftransapi.infom.FonctionRepo;
import com.di.sd.backapi.pftransapi.infom.InformField;
import com.di.sd.backapi.pftransapi.infom.NiveauInstRepo;
import com.di.sd.backapi.pftransapi.infom.NiveauInstruction;
import com.di.sd.backapi.pftransapi.infom.Notation;
import com.di.sd.backapi.pftransapi.infom.NotationsRepo;
import com.di.sd.backapi.pftransapi.infom.OriginePerso;
import com.di.sd.backapi.pftransapi.infom.OriginePersoRepo;
import com.di.sd.backapi.pftransapi.infom.Penalisation;
import com.di.sd.backapi.pftransapi.infom.Position;
import com.di.sd.backapi.pftransapi.infom.PositionRepo;
import com.di.sd.backapi.pftransapi.infom.Specialite;
import com.di.sd.backapi.pftransapi.infom.SpecialiteRepo;
import com.di.sd.backapi.pftransapi.unites.UniteAffAvoir;
import com.di.sd.backapi.pftransapi.unites.UniteAffPrepo;
import com.di.sd.backapi.pftransapi.unites.UniteAffRepo;
import com.di.sd.backapi.pftransapi.unites.UniteAffectation;
import com.di.sd.backapi.utils.Fiels;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
@Transactional
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
  @Autowired
  PenalisationRepo penalisationRepo;
  @Autowired
  EchelleSoldeRepo echRepo;
  @Autowired
  FonctionRepo fcRepo;
  @Autowired
  NiveauInstRepo nivRepo;
  @Autowired
  OriginePersoRepo orPerRepo;
  @Autowired
  SpecialiteRepo spRepo;
  @Autowired
  PositionRepo posRepo;
  @Autowired
  UniteAffPrepo unRepo;

  @Autowired
  GradeRepoP grRepo;

  public Personnel addPerso(Personnel ouv) {

    try {
      return persoRepo.save(ouv);
    } catch (Exception e) {
      throw new LibbeleException("Problème de base de données");
    }
  }

  public Iterable<Personnel> allPerso() {

    return persoRepo.findAll();

  }

  public Personnel getById(Long id) {
    Personnel pers = persoRepo.findById(id).get();

    if (pers == null) {
      throw new LibbeleException("Cet unite n'existe pas");
    }

    return pers;

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

  public Penalisation addPenalisation(Penalisation penalisation) {

    try {
      return penalisationRepo.save(penalisation);
    } catch (Exception e) {
      throw new LibbeleException("Problème de base de données");
    }

  }

  public List<Personnel> getPersonnelsByName(String mc) {

    List<Personnel> ouvs = persoRepo.findByNomContains(mc);

    return ouvs;
  }

  public List<Personnel> getPersonnelsByPrenom(String mc) {
    List<Personnel> ouvs = persoRepo.findByPrenomContains(mc);

    return ouvs;
  }

  public List<Personnel> getPersonnelsByMle(String mc) {
    List<Personnel> ouvs = persoRepo.findByMleContains(mc);

    return ouvs;
  }

  public List<Fiels> getAllPersonel() {
    List<Fiels> fields = new ArrayList<Fiels>();
    for (Personnel person : persoRepo.findAll()) {
      Fiels f = new Fiels();
      f.setLabel(person.getGradeActuelle().getLabel() + " " + person.getNom() + " " + person.getPrenom() + "  --  "
          + person.getCin());
      f.setValue(person.getId().toString());
      fields.add(f);
    }
    return fields;
  }

  public InformField getInfoForm() {
    InformField inf = new InformField();

    for (EchelleSolde e : echRepo.findAll()) {
      Fiels f = new Fiels();
      f.setLabel(e.getLabel());
      f.setValue(e.getValue().toString());
      inf.getEchelleSolde().add(f);
    }

    for (Fonction e : fcRepo.findAll()) {
      Fiels f = new Fiels();
      f.setLabel(e.getLabel());
      f.setValue(e.getValue().toString());
      inf.getFoctions().add(f);
    }
    for (NiveauInstruction e : nivRepo.findAll()) {
      Fiels f = new Fiels();
      f.setLabel(e.getLabel());
      f.setValue(e.getValue().toString());
      inf.getNiveauIns().add(f);
    }
    for (OriginePerso e : orPerRepo.findAll()) {
      Fiels f = new Fiels();
      f.setLabel(e.getLabel());
      f.setValue(e.getValue().toString());
      inf.getOrigine().add(f);
    }
    for (Specialite e : spRepo.findAll()) {
      Fiels f = new Fiels();
      f.setLabel(e.getLabel());
      f.setValue(e.getValue().toString());
      inf.getSpeialite().add(f);
    }
    for (GradePerso e : grRepo.findAll()) {
      Fiels f = new Fiels();
      f.setLabel(e.getLabel());
      f.setValue(e.getValue().toString());
      inf.getGrade().add(f);
    }
    for (Position e : posRepo.findAll()) {
      Fiels f = new Fiels();
      f.setLabel(e.getLabel());
      f.setValue(e.getValue().toString());
      inf.getPosition().add(f);
    }
    for (UniteAffectation e : unRepo.findAll()) {
      Fiels f = new Fiels();
      f.setLabel(e.getLabel());
      f.setValue(e.getValue().toString());
      inf.getUnite().add(f);
    }
    return inf;
  }
}
