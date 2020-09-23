package com.di.sd.backapi.pftransapi.unites;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UniteAffRepo extends JpaRepository<UniteAffAvoir, Long>{
    
}