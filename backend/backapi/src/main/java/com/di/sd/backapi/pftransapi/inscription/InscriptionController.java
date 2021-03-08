package com.di.sd.backapi.pftransapi.inscription;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

import com.di.sd.backapi.pftransapi.formations.TypeFormation;
import com.di.sd.backapi.utils.PDFGeneratorIns;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/inscription")
public class InscriptionController {
    @Autowired
    ImscrptionSvcImpl inSvc;

    @PostMapping("")
    public ResponseEntity<?> addInscription(@RequestParam Long idCycle, @RequestParam Long idFormation,
            @RequestParam Long personne, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateObt) {

        return new ResponseEntity<Inscription>(
                inSvc.addInscriptionBaseContinue(idCycle, idFormation, personne, dateObt), HttpStatus.OK);
    }

    @GetMapping("/fbasebypers/{id}")
    public List<Inscription> getInscriptionbypnf(@PathVariable("id") Long id, @RequestBody TypeFormation tyform) {
        return inSvc.getInscriptionBaseByPeson(id, tyform);

    }

    @GetMapping("/insbysession/{id}")
    public List<InscriptionResponse> getInscriptionbySession(@PathVariable("id") Long id) {

        return inSvc.getInscriptionBySession(id);

    }

    @PostMapping("/rejectstatus/{id}")
    public Boolean rejectStatus(@PathVariable("id") Long id, @RequestParam String motif) {

        return inSvc.rejectInscription(id, motif);

    }

    @GetMapping(value = "rejectedIns/{sid}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<?> getRejectedIns(@PathVariable Long sid) {

        ByteArrayInputStream bis = PDFGeneratorIns.customerPDFReport(inSvc.getSessionById(sid),
                inSvc.getInscriptionBySessionRejetee(sid), "Rejetées");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename= situation.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping(value = "retenuesIns/{sid}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<?> getRetenueIns(@PathVariable Long sid) {

        ByteArrayInputStream bis = PDFGeneratorIns.customerPDFReport(inSvc.getSessionById(sid),
                inSvc.getInscriptionBySessionRetenue(sid), "Retenues");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename= situation.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}