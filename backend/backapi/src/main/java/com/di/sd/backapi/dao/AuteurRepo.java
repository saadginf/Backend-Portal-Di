package com.di.sd.backapi.dao;

import com.di.sd.backapi.modals.Auteur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepo extends JpaRepository<Auteur, Long> {
    Auteur findBylibbele(String nom);
}