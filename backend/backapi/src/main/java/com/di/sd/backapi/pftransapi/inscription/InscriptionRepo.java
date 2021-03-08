package com.di.sd.backapi.pftransapi.inscription;

import java.util.List;

import javax.transaction.Transactional;

import com.di.sd.backapi.pftransapi.formations.Formations;
import com.di.sd.backapi.pftransapi.formations.SessionFormation;
import com.di.sd.backapi.pftransapi.formations.TypeFormation;
import com.di.sd.backapi.pftransapi.personnel.Personnel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface InscriptionRepo extends JpaRepository<Inscription, Long> {
    List<Inscription> findByPersonneAndSformation_Formation_TypeFormation(Personnel personne, TypeFormation tyform);

    Inscription findByPersonneAndSformation_Formation_Label(Personnel personne, String label);

    Inscription findByPersonneAndSformation_Formation(Personnel personne, Formations formation);

    List<Inscription> findBySformation(SessionFormation sFormation);

    List<Inscription> findBySformationAndStatutNot(SessionFormation sFormation, Statutinscription st);

    List<Inscription> findBySformationAndStatut(SessionFormation sFormation, Statutinscription st);

}