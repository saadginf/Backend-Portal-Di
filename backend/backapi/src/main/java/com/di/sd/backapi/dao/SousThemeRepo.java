package com.di.sd.backapi.dao;


import com.di.sd.backapi.modals.SousTheme;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SousThemeRepo extends CrudRepository<SousTheme, Long> {
    
}