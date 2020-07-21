package com.di.sd.backapi.restcontroller;

import java.util.List;

import javax.validation.Valid;

import com.di.sd.backapi.modals.Theme;

import com.di.sd.backapi.services.MapVAlidationErrorService;
import com.di.sd.backapi.services.ThemScvImpl;

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
@RequestMapping("api/biblio/themes")
public class ThemeController {
    @Autowired
    ThemScvImpl themSvc;
    @Autowired
    MapVAlidationErrorService mVerrors;

    @PostMapping("")
    public ResponseEntity<?> addTheme(@Valid @RequestBody Theme thm,BindingResult result){
          
        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Theme theme = themSvc.addTheme(thm);
        return new ResponseEntity<Theme>(theme,HttpStatus.OK);

    }
    @GetMapping("")
    public Iterable<Theme> getAllProjects() {

        return themSvc.getAll();

    } 
    @GetMapping("/unite/{projectId}")
    public List<Object[]> getAllThemeUnite(@PathVariable Long projectId) {

        return themSvc.getThemeByUnite(projectId);

    } 
}