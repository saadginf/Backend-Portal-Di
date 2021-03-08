package com.di.sd.backapi.pftransapi.planification;

import java.util.List;

import com.di.sd.backapi.utils.Fiels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/formation/planification")
public class PlanificationController {
    @Autowired
    PlanificationSvcImpl pSvc;

    @PostMapping("cdc/{id}")
    public ResponseEntity<?> addPerso(@RequestBody Fiels[] perso, @PathVariable Long id) {
        for (Fiels fiels : perso) {
            System.out.println(fiels.getLabel());
        }
        List<PlanficationReponse> inscriptions = pSvc.planificationCDC(perso, id);
        return new ResponseEntity<List<PlanficationReponse>>(inscriptions, HttpStatus.OK);

    }
}