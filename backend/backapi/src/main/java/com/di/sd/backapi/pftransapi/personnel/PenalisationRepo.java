package com.di.sd.backapi.pftransapi.personnel;

import com.di.sd.backapi.pftransapi.infom.Penalisation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PenalisationRepo extends JpaRepository<Penalisation, Long> {

}
