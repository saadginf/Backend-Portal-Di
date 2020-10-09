package com.di.sd.backapi.pftransapi.personnel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonnelRepo extends JpaRepository<Personnel,Long>{
    List<Personnel> findByNomContains(String mc);
    List<Personnel> findByPrenomContains(String mc);
    List<Personnel> findByMleContains(String mc);
}
