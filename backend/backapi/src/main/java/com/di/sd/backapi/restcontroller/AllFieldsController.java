package com.di.sd.backapi.restcontroller;

import com.di.sd.backapi.services.FieldsSvcImpl;
import com.di.sd.backapi.utils.AllFields;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/biblio/fields")
public class AllFieldsController {
   @Autowired
   FieldsSvcImpl fiSvc;
   
   
    @GetMapping("")
    public AllFields getAllProjects() {

        return fiSvc.getAllFields();

    }
}