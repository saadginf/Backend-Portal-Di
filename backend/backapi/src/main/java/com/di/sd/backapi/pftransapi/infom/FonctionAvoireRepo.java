package com.di.sd.backapi.pftransapi.infom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FonctionAvoireRepo extends JpaRepository<FonctionAvoir, Long> {
    
}