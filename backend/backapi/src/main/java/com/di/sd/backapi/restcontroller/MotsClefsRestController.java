package com.di.sd.backapi.restcontroller;

import javax.validation.Valid;

import com.di.sd.backapi.modals.MotsClefs;
import com.di.sd.backapi.services.MapVAlidationErrorService;
import com.di.sd.backapi.services.MotsClefsSvcImpl;
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
@RequestMapping("api/biblio/motsClefs")
public class MotsClefsRestController {
    @Autowired
    MotsClefsSvcImpl mcService;
    @Autowired
    MapVAlidationErrorService mVerrors;

    @PostMapping("")
    public ResponseEntity<?> addMc(@Valid @RequestBody MotsClefs mc,BindingResult result){
          
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if(errorMap != null) return errorMap;
        MotsClefs motClefs = mcService.addMc(mc);
        return new ResponseEntity<MotsClefs>(motClefs,HttpStatus.OK);

    }
    @GetMapping("")
    public Iterable<MotsClefs> getAllProjects(){

        return mcService.getAll();

    } 
}