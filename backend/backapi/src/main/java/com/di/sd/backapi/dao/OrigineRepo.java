package com.di.sd.backapi.dao;



import com.di.sd.backapi.modals.Origine;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrigineRepo extends CrudRepository<Origine,Long>{
    
}