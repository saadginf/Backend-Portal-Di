package com.di.sd.backapi.services;


import com.di.sd.backapi.modals.Auteur;
import com.di.sd.backapi.modals.Classification;
import com.di.sd.backapi.modals.Editeur;
import com.di.sd.backapi.modals.Format;
import com.di.sd.backapi.modals.Origine;
import com.di.sd.backapi.modals.Ouvrage;
import com.di.sd.backapi.modals.Theme;
import com.di.sd.backapi.modals.Type;
import com.di.sd.backapi.modals.Unite;
import com.di.sd.backapi.utils.AllFields;
import com.di.sd.backapi.utils.Fiels;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldsSvcImpl {
     @Autowired
   OrigineSvcImpl orSvc;
   @Autowired
   ThemScvImpl thSvc;
   @Autowired
   TypeServiceImpl tySvc;
   @Autowired
   ClassificationServiceImpl claSvc;
   @Autowired
   AuteurServiceImpl autSvc;
   @Autowired
   EditeurServiceImpl edSvc;
   @Autowired
   OuvrageSvcImpl ouvService;
    @Autowired
   FormatServiceImpl fmService;
   @Autowired
   UnitSvcImpl unSvc;

   public AllFields getAllFields() {
    AllFields allFields = new AllFields();
    
    Iterable<Origine> origines = orSvc.getAll();
    for (Origine origine : origines) {
        Fiels fiels = new Fiels();
        fiels.setLabel(origine.getLibbele());
        fiels.setValue(origine.getId().toString());
        allFields.getOrigine().add(fiels);
    }
    Iterable<Theme> themes = thSvc.getAll();
    for (Theme theme : themes) {
        Fiels fiels = new Fiels();
        fiels.setLabel(theme.getLibbele());
        fiels.setValue(theme.getId().toString());
        allFields.getTheme().add(fiels);
    }
    Iterable<Type> types = tySvc.getAll();
    for (Type type : types) {
        Fiels fiels = new Fiels();
        fiels.setLabel(type.getLibbele());
        fiels.setValue(type.getId().toString());
        allFields.getType().add(fiels);
    }
    Iterable<Classification> classifications = claSvc.getAll();
    for (Classification type : classifications) {
        Fiels fiels = new Fiels();
        fiels.setLabel(type.getLibbele());
        fiels.setValue(type.getId().toString());
        allFields.getClassification().add(fiels);
    }
    Iterable<Auteur> auteurs = autSvc.getAll();
    for (Auteur type : auteurs) {
        Fiels fiels = new Fiels();
        fiels.setLabel(type.getLibbele());
        fiels.setValue(type.getId().toString());
        allFields.getAuteurs().add(fiels);
    }
    Iterable<Editeur> editeurs = edSvc.getAll();
    for (Editeur type : editeurs) {
        Fiels fiels = new Fiels();
        fiels.setLabel(type.getLibbele());
        fiels.setValue(type.getId().toString());
        allFields.getEditeur().add(fiels);
    }
    Iterable<Ouvrage> e = ouvService.getAll();
    for (Ouvrage ouvrage : e) {
        Fiels fiels = new Fiels();
        fiels.setLabel(ouvrage.getTitre());
        fiels.setValue(ouvrage.getId().toString());
        allFields.getOuvrages().add(fiels);
    }
    Iterable<Format> fm = fmService.getAll();
    for (Format ouvrage : fm) {
        Fiels fiels = new Fiels();
        fiels.setLabel(ouvrage.getLibbele());
        fiels.setValue(ouvrage.getId().toString());
        allFields.getFormats().add(fiels);
    }    
    
    Iterable<Unite> un = unSvc.getAll();
    for (Unite ouvrage : un) {
        Fiels fiels = new Fiels();
        fiels.setLabel(ouvrage.getLibbele());
        fiels.setValue(ouvrage.getId().toString());
        allFields.getUnites().add(fiels);
    }    




    return allFields;

   }
 
}