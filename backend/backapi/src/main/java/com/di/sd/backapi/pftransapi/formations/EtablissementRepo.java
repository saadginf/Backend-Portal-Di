package com.di.sd.backapi.pftransapi.formations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtablissementRepo extends JpaRepository<Etablissement, Long> {

}