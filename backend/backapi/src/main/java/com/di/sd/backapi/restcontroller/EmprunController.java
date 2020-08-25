package com.di.sd.backapi.restcontroller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.di.sd.backapi.modals.Emprunt;
import com.di.sd.backapi.services.EmprunSvcImpl;
import com.di.sd.backapi.services.MapVAlidationErrorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
@RequestMapping("api/biblio/emprunt")
public class EmprunController {
    @Autowired
    EmprunSvcImpl epSvc;

    @Autowired
    MapVAlidationErrorService mVerrors;
    
    @PostMapping("/borrow")
    public ResponseEntity<?> addAuteur(@Valid @RequestBody Emprunt aut,BindingResult result){
          
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Emprunt auteur = epSvc.borrowBook(aut);
        return new ResponseEntity<Emprunt>(auteur,HttpStatus.OK);

    }
    @PostMapping("/return")
    public ResponseEntity<?> returnEx(@RequestParam Long emp, @RequestParam  @DateTimeFormat(pattern="yyyy-MM-dd")Date dateRetour){
          
      
        
       String  auteur = epSvc.returnBook(emp, dateRetour);
       
        return new ResponseEntity<String>(auteur,HttpStatus.OK);

    }
    @GetMapping("")
    public Iterable<Emprunt> getAllProjects() {

        return null;

    }
    @GetMapping("unite/{projectId}")
    public ResponseEntity<?> getOeuvreByUnite(@PathVariable Long projectId) {
        List<Emprunt> p = epSvc.getBorrowed(projectId);
        for (Emprunt emprunt : p) {
            emprunt.getExemplaire().setTome(null);
        }
    return new ResponseEntity<List<Emprunt>>(p, HttpStatus.OK);

    } 
}