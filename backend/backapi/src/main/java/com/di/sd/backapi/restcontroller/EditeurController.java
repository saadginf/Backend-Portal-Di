package com.di.sd.backapi.restcontroller;

import javax.validation.Valid;

import com.di.sd.backapi.modals.Editeur;
import com.di.sd.backapi.services.EditeurServiceImpl;
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
@RequestMapping("api/biblio/editeurs")
public class EditeurController {
    @Autowired
    EditeurServiceImpl editService;
    @Autowired
    MapVAlidationErrorService mVerrors;

    @PostMapping("")
    public ResponseEntity<?> addEditeur(@Valid @RequestBody Editeur edit,BindingResult result){
          
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Editeur editeur = editService.addEditeur(edit);
        return new ResponseEntity<Editeur>(editeur,HttpStatus.OK);

    }
    @GetMapping("")
    public Iterable<Editeur> getAllProjects() {

        return editService.getAll();

    } 
}