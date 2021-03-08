package com.di.sd.backapi.pftransapi.formations;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface SessionFormationRepo extends JpaRepository<SessionFormation, Long> {
    List<SessionFormation> findByActiveTrue();

    List<SessionFormation> findByActiveTrueAndPlanificationTrue();

    List<SessionFormation> findByFormationAndCycleScolaire(Formations formation, CycleScolaire cycleScolaire);
}