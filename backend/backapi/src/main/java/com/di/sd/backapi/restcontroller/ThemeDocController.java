package com.di.sd.backapi.restcontroller;

import javax.validation.Valid;

import com.di.sd.backapi.modals.ThemeDoc;
import com.di.sd.backapi.services.MapVAlidationErrorService;
import com.di.sd.backapi.services.ThemedocSvcImpl;


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
@RequestMapping("api/archive/themedoc")
public class ThemeDocController {
    @Autowired
    ThemedocSvcImpl themeDocRepo;
    @Autowired
    MapVAlidationErrorService mVerrors;

    @PostMapping("")
    public ResponseEntity<?> addClassification(@Valid @RequestBody ThemeDoc classs,BindingResult result){
          
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if(errorMap != null) return errorMap;
        ThemeDoc cl = themeDocRepo.addOrigine(classs);
        return new ResponseEntity<ThemeDoc>(cl,HttpStatus.OK);

    }
    @GetMapping("")
    public Iterable<ThemeDoc> getAllProjects(){

        return themeDocRepo.getAll();

    } 
}