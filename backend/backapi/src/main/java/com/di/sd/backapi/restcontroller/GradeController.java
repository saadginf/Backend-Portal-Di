package com.di.sd.backapi.restcontroller;

import javax.validation.Valid;

import com.di.sd.backapi.modals.Grade;
import com.di.sd.backapi.services.GradeSvcImpl;
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
@RequestMapping("api/rh/grade")
public class GradeController {
    @Autowired
    GradeSvcImpl grSvc;
    @Autowired
    MapVAlidationErrorService mVerrors;

    @PostMapping("")
    public ResponseEntity<?> addGrade(@Valid @RequestBody Grade classs,BindingResult result){
          
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Grade cl = grSvc.addGrade(classs);
        return new ResponseEntity<Grade>(cl,HttpStatus.OK);

    }
    @GetMapping("")
    public Iterable<Grade> getAllProjects() {

        return grSvc.getAll();

    } 
}