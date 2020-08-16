package com.di.sd.backapi.services;



import com.di.sd.backapi.dao.DocumentRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentSvcImpl {
    @Autowired
    private DocumentRepo editeRepo;

    public Document addEditeur(Document editeur) {

        
        try {
            System.out.println(editeur);
            return editeRepo.save(editeur);
           
        } catch (Exception e) {
           throw new LibbeleException("Erreur de base de donnée");
        }
    }
    public Iterable<Document> getAll(){
        
        Iterable<Document> Document = editeRepo.findAll();
       
        return Document;
    }
    public void deleteExemplaire(Long id) {

     

        try {
            Document exemp = editeRepo.findById(id).get();
            editeRepo.delete(exemp);
        } catch (Exception e) {
           throw new LibbeleException("Erreur de base de donnée");
        }
        

    }
   
}