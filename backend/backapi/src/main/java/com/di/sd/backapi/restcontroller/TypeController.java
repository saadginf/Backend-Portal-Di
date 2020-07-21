package com.di.sd.backapi.restcontroller;

import javax.validation.Valid;

import com.di.sd.backapi.modals.Type;
import com.di.sd.backapi.services.MapVAlidationErrorService;
import com.di.sd.backapi.services.TypeServiceImpl;

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
@RequestMapping("api/biblio/types")
public class TypeController {
    @Autowired
    TypeServiceImpl typeService;
    @Autowired
    MapVAlidationErrorService mVerrors;

    @PostMapping("")
    public ResponseEntity<?> addType(@Valid @RequestBody Type tp,BindingResult result){
          
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Type type = typeService.addType(tp);
        return new ResponseEntity<Type>(type,HttpStatus.OK);

    }
    @GetMapping("")
    public Iterable<Type> getAllProjects() {

        return typeService.getAll();

    } 
}