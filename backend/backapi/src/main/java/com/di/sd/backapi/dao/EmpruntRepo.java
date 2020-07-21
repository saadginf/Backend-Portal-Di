package com.di.sd.backapi.dao;

import com.di.sd.backapi.modals.Emprunt;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepo extends CrudRepository<Emprunt,Long>{
    
}