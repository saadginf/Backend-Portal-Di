package com.di.sd.backapi.dao;

import com.di.sd.backapi.modals.Unite;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniteRepo extends CrudRepository<Unite, Long> {
    
}