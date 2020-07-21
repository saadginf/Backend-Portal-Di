package com.di.sd.backapi.restcontroller;

import javax.validation.Valid;

import com.di.sd.backapi.modals.Auteur;
import com.di.sd.backapi.services.AuteurServiceImpl;
import com.di.sd.backapi.services.MapVAlidationErrorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("api/biblio/auteurs")
public class AuteurController {
    @Autowired
    AuteurServiceImpl autService;
    @Autowired
    MapVAlidationErrorService mVerrors;

    @PostMapping("")
    public ResponseEntity<?> addAuteur(@Valid @RequestBody Auteur aut,BindingResult result){
          
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Auteur auteur = autService.addAuteur(aut);
        return new ResponseEntity<Auteur>(auteur,HttpStatus.OK);

    }
    @GetMapping("")
    public Iterable<Auteur> getAllProjects(){

        return autService.getAll();

    } 
}