package com.di.sd.backapi.restcontroller;

import java.util.List;

import javax.validation.Valid;

import com.di.sd.backapi.modals.Events;
import com.di.sd.backapi.services.EventSvcImpl;
import com.di.sd.backapi.services.MapVAlidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("api/biblio/events")
public class EventsController {
    @Autowired
    EventSvcImpl eservice;
    @Autowired
    MapVAlidationErrorService mVerrors;

    @PostMapping("")
    public ResponseEntity<?> addEditeur(@Valid @RequestBody Events edit,BindingResult result){
          
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Events editeur = eservice.addEditeur(edit);
        return new ResponseEntity<Events>(editeur,HttpStatus.OK);

    }
    @GetMapping("")
    public Iterable<Events> getAllProjects() {

        return eservice.getAll();

    } 
    @GetMapping("/top10")
    public List<Events> top10() {

        return eservice.getTop10();

    } 
    @GetMapping("/top5")
    public List<Events> top5() {

        return eservice.getTop5();

    } 
    @GetMapping("/top2")
    public List<Events> top2() {

        return eservice.getTop2();

    } 
    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable Long projectId) {
        eservice.deleteExemplaire(projectId);
        return new ResponseEntity<String>("Project Deleted", HttpStatus.OK);
    }
}