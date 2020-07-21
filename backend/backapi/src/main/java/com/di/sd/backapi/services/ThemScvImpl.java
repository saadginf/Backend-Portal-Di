package com.di.sd.backapi.services;


import java.util.List;

import com.di.sd.backapi.dao.ThemeRepository;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.Theme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemScvImpl {
    @Autowired
    private ThemeRepository themRepo;

    public Theme addTheme(Theme theme){

        
        try {
            return themRepo.save(theme);
        } catch (Exception e) {
           throw new LibbeleException("Cette Valeur existe déjà");
        }
    }
    public Iterable<Theme> getAll(){
        
        return themRepo.findAll();
    }
    public List<Object[]> getThemeByUnite(Long id){
      
       
       
        return  themRepo.getThemeByUnite(id);
    }

    public Theme getThemeById(Long id) {

        Theme exemp = themRepo.findById(id).get();

        if (exemp == null) {
            throw new LibbeleException("Ce Theme n'existe pas");
        }
    
  
        return exemp;
    }
}