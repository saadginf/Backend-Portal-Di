package com.di.sd.backapi.restcontroller;

import java.util.List;

import javax.validation.Valid;

import com.di.sd.backapi.modals.Emprunteur;
import com.di.sd.backapi.services.EprunteurSvcImpl;
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
@RequestMapping("api/biblio/emprunteur")
public class EmprunteurController {
    @Autowired
    EprunteurSvcImpl epSvc;

    @Autowired
    MapVAlidationErrorService mVerrors;
    
    @PostMapping("")
    public ResponseEntity<?> addAuteur(@Valid @RequestBody Emprunteur aut,BindingResult result){
          
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Emprunteur auteur = epSvc.addEmprunteur(aut);
        return new ResponseEntity<Emprunteur>(auteur,HttpStatus.OK);

    }
    @GetMapping("")
    public Iterable<Emprunteur> getAllProjects() {

        return epSvc.getAll();

    }
    @GetMapping("unite/{projectId}")
    public ResponseEntity<?> getOeuvreByUnite(@PathVariable Long projectId) {
        List<Emprunteur> p = epSvc.getEmByUnite(projectId);
        return new ResponseEntity<List<Emprunteur>>(p, HttpStatus.OK);
    } 
}