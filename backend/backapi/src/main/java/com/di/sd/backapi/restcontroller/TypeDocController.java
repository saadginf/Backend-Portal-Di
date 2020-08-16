package com.di.sd.backapi.restcontroller;

import javax.validation.Valid;

import com.di.sd.backapi.modals.TypeDoc;
import com.di.sd.backapi.services.MapVAlidationErrorService;
import com.di.sd.backapi.services.TypeDocSvcImpl;

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
@RequestMapping("api/archive/typedoc")
public class TypeDocController {
    @Autowired
    TypeDocSvcImpl typeDocSvc;
    @Autowired
    MapVAlidationErrorService mVerrors;

    @PostMapping("")
    public ResponseEntity<?> addClassification(@Valid @RequestBody TypeDoc classs,BindingResult result){
          
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if(errorMap != null) return errorMap;
        TypeDoc cl = typeDocSvc.addOrigine(classs);
        return new ResponseEntity<TypeDoc>(cl,HttpStatus.OK);

    }
    @GetMapping("")
    public Iterable<TypeDoc> getAllProjects(){

        return typeDocSvc.getAll();

    } 
}