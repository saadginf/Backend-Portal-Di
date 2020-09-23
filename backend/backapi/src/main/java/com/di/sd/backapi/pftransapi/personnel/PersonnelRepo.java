package com.di.sd.backapi.pftransapi.personnel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonnelRepo extends JpaRepository<Personnel,Long>{

}
