package com.di.sd.backapi.services;
import com.di.sd.backapi.dao.OrigineRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.Origine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrigineSvcImpl {
    @Autowired
    private OrigineRepo oriRepo;

    public Origine addOrigine(Origine origine){

        
        try {
            return oriRepo.save(origine);
        } catch (Exception e) {
           throw new LibbeleException("Cette Valeur existe déjà");
        }
    }
    public Iterable<Origine> getAll(){
        return oriRepo.findAll();
    }
}