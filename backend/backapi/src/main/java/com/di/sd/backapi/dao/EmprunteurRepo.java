package com.di.sd.backapi.dao;

import java.util.List;

import com.di.sd.backapi.modals.Emprunteur;
import com.di.sd.backapi.modals.Unite;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprunteurRepo extends CrudRepository<Emprunteur, Long> {
    List<Emprunteur> findByUnite(Unite unite);
}