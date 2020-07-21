package com.di.sd.backapi.restcontroller;

import javax.validation.Valid;

import com.di.sd.backapi.modals.Origine;
import com.di.sd.backapi.services.MapVAlidationErrorService;
import com.di.sd.backapi.services.OrigineSvcImpl;

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
@RequestMapping("api/biblio/origines")
public class OrigineController {
    @Autowired
    OrigineSvcImpl origineSvcImpl;
    @Autowired
    MapVAlidationErrorService mVerrors;

    @PostMapping("")
    public ResponseEntity<?> addOrigine(@Valid @RequestBody Origine ori,BindingResult result){
          
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Origine origine = origineSvcImpl.addOrigine(ori);
        return new ResponseEntity<Origine>(origine,HttpStatus.OK);

    }
    @GetMapping("")
    public Iterable<Origine> getAllProjects(){

        return origineSvcImpl.getAll();

    } 
}