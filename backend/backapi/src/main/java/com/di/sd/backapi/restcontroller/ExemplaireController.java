package com.di.sd.backapi.restcontroller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;
import org.springframework.http.HttpHeaders;
import com.di.sd.backapi.modals.Exemplaire;
import com.di.sd.backapi.modals.SumUpExemplaire;
import com.di.sd.backapi.modals.Theme;
import com.di.sd.backapi.modals.Unite;
import com.di.sd.backapi.services.ExmplaireServiceImpl;
import com.di.sd.backapi.services.MapVAlidationErrorService;
import com.di.sd.backapi.services.ThemScvImpl;
import com.di.sd.backapi.services.UnitSvcImpl;
import com.di.sd.backapi.utils.Inventaire;
import com.di.sd.backapi.utils.PDFGenerator;
import com.di.sd.backapi.utils.StatsOuvByUnite;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
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
@RequestMapping("api/biblio/exemplaires")
public class ExemplaireController {
    @Autowired
    ExmplaireServiceImpl exScv;
    @Autowired
    MapVAlidationErrorService mVerrors;
    @Autowired
    UnitSvcImpl uservice;
    @Autowired
    ThemScvImpl thService;

    @PostMapping("")
    public ResponseEntity<?> addExmp(@Valid @RequestBody Exemplaire exmp, BindingResult result) {

        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        Exemplaire exemplaire = exScv.addExemp(exmp);
        return new ResponseEntity<Exemplaire>(exemplaire, HttpStatus.OK);

    }

    @GetMapping("")
    public Iterable<Exemplaire> getAllProjects() {

        return exScv.getAll();

    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getOeuvre(@PathVariable String projectId) {
        Exemplaire p = exScv.getExemplaireByRayon(projectId);
        return new ResponseEntity<Exemplaire>(p, HttpStatus.OK);
    }

    @GetMapping("unite/{projectId}")
    public ResponseEntity<?> getOeuvreByUnite(@PathVariable Long projectId) {
        List<SumUpExemplaire> p = exScv.getExemplaireByUnite(projectId);
        return new ResponseEntity<List<SumUpExemplaire>>(p, HttpStatus.OK);
    }

    @GetMapping("tome/{projectId}")
    public ResponseEntity<?> getStatsBytomeId(@PathVariable Long projectId) {
        StatsOuvByUnite p = exScv.getnumberByUnite(projectId);
        return new ResponseEntity<StatsOuvByUnite>(p, HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId) {
        exScv.deleteProject(projectId);
        return new ResponseEntity<String>("Project Deleted", HttpStatus.OK);
    }

    @GetMapping(value = "unite/{unite}/{theme}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<?> getInventaire(@PathVariable Long unite, @PathVariable Long theme) throws IOException {
        List<Inventaire> p = exScv.getInventaire(theme, unite);
        Unite u = uservice.getUniteById(unite);
        Theme t = thService.getThemeById(theme);
        ByteArrayInputStream bis = PDFGenerator.customerPDFReport(p, u, t);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename= inventaire.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}