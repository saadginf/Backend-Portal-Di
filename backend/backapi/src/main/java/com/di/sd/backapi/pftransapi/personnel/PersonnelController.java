package com.di.sd.backapi.pftransapi.personnel;

import java.util.List;

import javax.validation.Valid;

import com.di.sd.backapi.pftransapi.grade.GradeAvoir;
import com.di.sd.backapi.pftransapi.infom.EchelleSoldeAvoir;
import com.di.sd.backapi.pftransapi.infom.FonctionAvoir;
import com.di.sd.backapi.pftransapi.infom.Notation;
import com.di.sd.backapi.pftransapi.infom.Penalisation;
import com.di.sd.backapi.pftransapi.unites.UniteAffAvoir;
import com.di.sd.backapi.services.MapVAlidationErrorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("api/rh/perso")
public class PersonnelController {


    @Autowired
    MapVAlidationErrorService mVerrors;
    @Autowired
    PersonnelSvcImpl persosvc;

    @PostMapping("")
    public ResponseEntity<?> addPerso(@Valid @RequestBody Personnel perso, BindingResult result) {

        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
       Personnel personel = persosvc.addPerso(perso);
        return new ResponseEntity<Personnel>(personel, HttpStatus.OK);

    }
    @GetMapping("")
    public Iterable<Personnel> addPerso() {

        return persosvc.allPerso();

    }
    @PostMapping("/addGrade")
    public ResponseEntity<?> addGrade(@Valid @RequestBody GradeAvoir gAvoir, BindingResult result) {
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
       GradeAvoir personel = persosvc.addGrade(gAvoir);
      
        return new ResponseEntity<GradeAvoir>(personel, HttpStatus.OK);

    }

    @PostMapping("/addUnite")
    public ResponseEntity<?> addUnite(@Valid @RequestBody UniteAffAvoir gAvoir, BindingResult result) {
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
       UniteAffAvoir personel = persosvc.addUnite(gAvoir);
      
        return new ResponseEntity<UniteAffAvoir>(personel, HttpStatus.OK);

    }
    @PostMapping("/addFunc")
    public ResponseEntity<?> addFunc(@Valid @RequestBody FonctionAvoir fAvoir, BindingResult result) {
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
       FonctionAvoir personel = persosvc.addFonction(fAvoir);
      
        return new ResponseEntity<FonctionAvoir>(personel, HttpStatus.OK);

    }
    @PostMapping("/addEs")
    public ResponseEntity<?> addEs(@Valid @RequestBody EchelleSoldeAvoir fAvoir, BindingResult result) {
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        EchelleSoldeAvoir personel = persosvc.addEs(fAvoir);
        return new ResponseEntity<EchelleSoldeAvoir>(personel, HttpStatus.OK);

    }
    @PostMapping("/addNote")
    public ResponseEntity<?> addNote(@Valid @RequestBody Notation note, BindingResult result) {
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        Notation notes = persosvc.addNotation(note);
        return new ResponseEntity<Notation>(notes, HttpStatus.OK);

    }
    @PostMapping("/addPen")
    public ResponseEntity<?> addPen(@Valid @RequestBody Penalisation pen, BindingResult result) {
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        Penalisation pens = persosvc.addPenalisation(pen);
        return new ResponseEntity<Penalisation>(pens, HttpStatus.OK);

    }
    @GetMapping("searchByName/{projectId}")
    public ResponseEntity<?> getByName(@PathVariable String projectId) {
        List<Personnel> p = persosvc.getPersonnelsByName(projectId);
        return new ResponseEntity<List<Personnel>>(p, HttpStatus.OK);
    }
    @GetMapping("searchByPrenom/{projectId}")
    public ResponseEntity<?> getByPrenom(@PathVariable String projectId) {
        List<Personnel> p = persosvc.getPersonnelsByPrenom(projectId);
        return new ResponseEntity<List<Personnel>>(p, HttpStatus.OK);
    }
    @GetMapping("searchByMle/{projectId}")
    public ResponseEntity<?> getByMle(@PathVariable String projectId) {
        List<Personnel> p = persosvc.getPersonnelsByMle(projectId);
        return new ResponseEntity<List<Personnel>>(p, HttpStatus.OK);
    }
    @GetMapping("getById/{projectId}")
    public ResponseEntity<?> getById(@PathVariable Long projectId) {
        Personnel p = persosvc.getById(projectId);
        return new ResponseEntity<Personnel>(p, HttpStatus.OK);
    }
}