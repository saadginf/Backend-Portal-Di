package com.di.sd.backapi.dao;

import java.util.List;

import com.di.sd.backapi.modals.Emprunt;
import com.di.sd.backapi.modals.Unite;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepo extends CrudRepository<Emprunt,Long>{
    List<Emprunt> findByExemplaire_UniteAndDateRetourIsNull(Unite unite);
}