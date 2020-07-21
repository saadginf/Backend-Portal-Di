package com.di.sd.backapi.restcontroller;

import com.di.sd.backapi.modals.StatsBiblio;
import com.di.sd.backapi.services.StatsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("api/biblio/stats")
public class StatsConroller {
    @Autowired
    StatsServiceImpl stsSvc;
   
   
    @GetMapping("")
    public ResponseEntity<?> getStats() {
        StatsBiblio p = stsSvc.getStates();
        return new ResponseEntity<StatsBiblio>(p, HttpStatus.OK);
    }
}