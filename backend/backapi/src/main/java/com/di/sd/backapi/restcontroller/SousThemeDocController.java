package com.di.sd.backapi.restcontroller;

import javax.validation.Valid;

import com.di.sd.backapi.modals.SousTheme;
import com.di.sd.backapi.services.MapVAlidationErrorService;
import com.di.sd.backapi.services.SousThemesvcImpl;


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
@RequestMapping("api/archive/sousthemedoc")
public class SousThemeDocController {
    @Autowired
    SousThemesvcImpl themeDocRepo;
    @Autowired
    MapVAlidationErrorService mVerrors;

    @PostMapping("")
    public ResponseEntity<?> addClassification(@Valid @RequestBody SousTheme classs,BindingResult result){
          
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if(errorMap != null) return errorMap;
        SousTheme cl = themeDocRepo.addOrigine(classs);
        return new ResponseEntity<SousTheme>(cl,HttpStatus.OK);

    }
    @GetMapping("")
    public Iterable<SousTheme> getAllProjects(){

        return themeDocRepo.getAll();

    } 
}