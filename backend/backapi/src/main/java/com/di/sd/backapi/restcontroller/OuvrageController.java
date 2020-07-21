package com.di.sd.backapi.restcontroller;

import java.util.List;

import javax.validation.Valid;

import com.di.sd.backapi.modals.Ouvrage;
import com.di.sd.backapi.services.MapVAlidationErrorService;
import com.di.sd.backapi.services.OuvrageSvcImpl;
import com.di.sd.backapi.utils.StatsOuvByUnite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/biblio/ouvrages")
public class OuvrageController {
    @Autowired
    OuvrageSvcImpl ouvService;
    @Autowired
    MapVAlidationErrorService mVerrors;

    @PostMapping("")
    public ResponseEntity<?> addAuteur(@Valid @RequestBody Ouvrage ouv, BindingResult result) {

        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        Ouvrage ouvrage = ouvService.addOuvrage(ouv);
        return new ResponseEntity<Ouvrage>(ouvrage, HttpStatus.OK);

    }

    @GetMapping("")
    public Iterable<Ouvrage> getAllProjects() {

        return ouvService.getAll();

    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getOuvrageByname(@PathVariable String projectId) {
        List<Ouvrage> p = ouvService.getOuvrageByTitre(projectId);
        return new ResponseEntity<List<Ouvrage>>(p, HttpStatus.OK);
    }

    @GetMapping("id/{projectId}")
    public ResponseEntity<?> getOuvrageByID(@PathVariable Long projectId) {
        Ouvrage p = ouvService.getOuvrageById(projectId);
        return new ResponseEntity<Ouvrage>(p, HttpStatus.OK);
    }

    @GetMapping("last")
    public ResponseEntity<?> getOuvrageLast() {
        List<Ouvrage> p = ouvService.getLast();
        return new ResponseEntity<List<Ouvrage>>(p, HttpStatus.OK);
    }

    @GetMapping("stats/{projectId}")
    public ResponseEntity<?> getStatsOuvrageByID(@PathVariable Long projectId) {
        List<StatsOuvByUnite> p = ouvService.getStatsOuvrageById(projectId);
        return new ResponseEntity<List<StatsOuvByUnite>>(p, HttpStatus.OK);
    }
}