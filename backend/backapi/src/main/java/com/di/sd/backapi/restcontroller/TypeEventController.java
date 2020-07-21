package com.di.sd.backapi.restcontroller;

import javax.validation.Valid;

import com.di.sd.backapi.modals.TypeEvent;
import com.di.sd.backapi.services.EventTypeEvcImpl;
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
@RequestMapping("api/biblio/typeEvent")
public class TypeEventController {
    @Autowired
    EventTypeEvcImpl eventTypeSvc;
    @Autowired
    MapVAlidationErrorService mVerrors;

    @PostMapping("")
    public ResponseEntity<?> addType(@Valid @RequestBody TypeEvent form,BindingResult result){
          
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if(errorMap != null) return errorMap;
        TypeEvent format = eventTypeSvc.addFormat(form);
        return new ResponseEntity<TypeEvent>(format,HttpStatus.OK);

    }
    @GetMapping("")
    public Iterable<TypeEvent> getAllProjects(){

        return eventTypeSvc.getAll();

    } 
}