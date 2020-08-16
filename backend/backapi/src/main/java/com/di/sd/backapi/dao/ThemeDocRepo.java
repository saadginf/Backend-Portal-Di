package com.di.sd.backapi.dao;

import com.di.sd.backapi.modals.ThemeDoc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeDocRepo extends CrudRepository<ThemeDoc, Long> {
    
}