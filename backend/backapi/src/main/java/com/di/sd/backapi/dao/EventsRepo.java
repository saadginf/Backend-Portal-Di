package com.di.sd.backapi.dao;

import com.di.sd.backapi.modals.Events;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepo extends CrudRepository<Events,Long>{
    
}