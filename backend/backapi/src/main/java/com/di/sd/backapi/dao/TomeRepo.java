package com.di.sd.backapi.dao;

import java.util.List;

import com.di.sd.backapi.modals.Ouvrage;
import com.di.sd.backapi.modals.Tome;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TomeRepo extends CrudRepository<Tome,Long> {
    List<Tome> findByOuvrageOrderByLibbele(Ouvrage ouvrage);
}