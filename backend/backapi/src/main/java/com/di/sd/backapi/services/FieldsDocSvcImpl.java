package com.di.sd.backapi.services;



import com.di.sd.backapi.modals.Classification;
import com.di.sd.backapi.modals.Document;

import com.di.sd.backapi.modals.Origine;

import com.di.sd.backapi.modals.ThemeDoc;
import com.di.sd.backapi.modals.TypeDoc;
import com.di.sd.backapi.modals.Unite;

import com.di.sd.backapi.utils.AllFieldsDoc;
import com.di.sd.backapi.utils.Fiels;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldsDocSvcImpl {
    @Autowired
   OrigineSvcImpl orSvc;
   @Autowired
   ThemedocSvcImpl thSvc;
   @Autowired
   TypeDocSvcImpl tySvc;
   @Autowired
   ClassificationServiceImpl claSvc;
   @Autowired
   DocumentSvcImpl docSvc;
  
   @Autowired
   UnitSvcImpl unSvc;

   public AllFieldsDoc getAllFieldsDoc() {
    AllFieldsDoc allFields = new AllFieldsDoc();
    
    Iterable<Origine> origines = orSvc.getAll();
    for (Origine origine : origines) {
        Fiels fiels = new Fiels();
        fiels.setLabel(origine.getLibbele());
        fiels.setValue(origine.getId().toString());
        allFields.getOrigine().add(fiels);
    }
    Iterable<ThemeDoc> themes = thSvc.getAll();
    allFields.setThemes(themes);
    Iterable<TypeDoc> types = tySvc.getAll();
    allFields.setType(types);
    Iterable<Classification> classifications = claSvc.getAll();
    for (Classification type : classifications) {
        Fiels fiels = new Fiels();
        fiels.setLabel(type.getLibbele());
        fiels.setValue(type.getId().toString());
        allFields.getClassification().add(fiels);
    }
    Iterable<Document> documents = docSvc.getAll();
    for (Document type : documents) {
        Fiels fiels = new Fiels();
        fiels.setLabel(type.getMumero());
        fiels.setValue(type.getId().toString());
        allFields.getDocuments().add(fiels);
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