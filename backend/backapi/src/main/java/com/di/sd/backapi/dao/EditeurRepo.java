package com.di.sd.backapi.dao;

import com.di.sd.backapi.modals.Editeur;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditeurRepo extends CrudRepository<Editeur, Long> {

    Editeur findBylibbele(String ed);

}