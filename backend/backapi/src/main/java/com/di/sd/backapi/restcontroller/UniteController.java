package com.di.sd.backapi.restcontroller;

import javax.validation.Valid;
import com.di.sd.backapi.modals.Unite;
import com.di.sd.backapi.services.MapVAlidationErrorService;
import com.di.sd.backapi.services.UnitSvcImpl;
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
@RequestMapping("api/biblio/unite")
public class UniteController {
    @Autowired
    UnitSvcImpl uniteService;
    @Autowired
    MapVAlidationErrorService mVerrors;

    @PostMapping("")
    public ResponseEntity<?> addUnite(@Valid @RequestBody Unite ut,BindingResult result){
          
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Unite unite = uniteService.addUnite(ut);
        return new ResponseEntity<Unite>(unite,HttpStatus.OK);

    }
    @GetMapping("")
    public Iterable<Unite> getAllProjects(){

        return uniteService.getAll();

    } 
}