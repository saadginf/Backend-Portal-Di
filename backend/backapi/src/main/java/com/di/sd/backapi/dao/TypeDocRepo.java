package com.di.sd.backapi.dao;


import com.di.sd.backapi.modals.TypeDoc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDocRepo extends CrudRepository<TypeDoc, Long> {
    
}