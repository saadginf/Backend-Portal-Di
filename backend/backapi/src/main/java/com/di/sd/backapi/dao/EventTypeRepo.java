package com.di.sd.backapi.dao;

import com.di.sd.backapi.modals.TypeEvent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EventTypeRepo extends CrudRepository<TypeEvent, Long> {
    
}