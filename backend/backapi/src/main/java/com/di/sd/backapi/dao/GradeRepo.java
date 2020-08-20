package com.di.sd.backapi.dao;

import com.di.sd.backapi.modals.Grade;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepo extends CrudRepository<Grade, Long> {
    
}