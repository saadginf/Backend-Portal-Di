package com.di.sd.backapi.restcontroller;

import java.util.List;

import javax.validation.Valid;

import com.di.sd.backapi.modals.Tome;
import com.di.sd.backapi.services.MapVAlidationErrorService;
import com.di.sd.backapi.services.TomeSvcImpl;

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
@RequestMapping("api/biblio/tomes")
public class TomController {
    @Autowired
    TomeSvcImpl tomService;
    @Autowired
    MapVAlidationErrorService mVerrors;

    @PostMapping("")
    public ResponseEntity<?> addTome(@Valid @RequestBody Tome tm, BindingResult result) {

        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        Tome tome = tomService.addAuteur(tm);
        return new ResponseEntity<Tome>(tome, HttpStatus.OK);

    }

    @GetMapping("")
    public Iterable<Tome> getAllProjects() {
        Iterable<Tome> tomes = tomService.getAll();

        return tomes;

    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getTomebyOuvrage(@PathVariable Long projectId) {
        List<Tome> p = tomService.findByOuvrage(projectId);
        return new ResponseEntity<List<Tome>>(p, HttpStatus.OK);
    }

}