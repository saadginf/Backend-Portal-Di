package com.di.sd.backapi.dao;

import com.di.sd.backapi.modals.MotsClefs;

import org.springframework.data.repository.CrudRepository;

public interface McRepo extends CrudRepository<MotsClefs, Long>{
    
}