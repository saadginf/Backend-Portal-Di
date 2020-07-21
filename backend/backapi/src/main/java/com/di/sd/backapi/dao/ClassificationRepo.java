package com.di.sd.backapi.dao;

import com.di.sd.backapi.modals.Classification;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepo extends CrudRepository<Classification, Long> {
    
}