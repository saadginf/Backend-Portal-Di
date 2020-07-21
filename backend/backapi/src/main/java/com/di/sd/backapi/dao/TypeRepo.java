package com.di.sd.backapi.dao;

import com.di.sd.backapi.modals.Type;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepo extends CrudRepository<Type,Long> {
    
}