package com.di.sd.backapi.restcontroller;

import com.di.sd.backapi.services.FieldsDocSvcImpl;

import com.di.sd.backapi.utils.AllFieldsDoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/archive/fieldsDoc")
public class AllFieldsDocController {
   @Autowired
   FieldsDocSvcImpl fiSvc;
   
   
    @GetMapping("")
    public AllFieldsDoc getAllProjects() {

        return fiSvc.getAllFieldsDoc();

    }
}