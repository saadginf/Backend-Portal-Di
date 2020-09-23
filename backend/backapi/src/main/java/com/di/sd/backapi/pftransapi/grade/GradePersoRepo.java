package com.di.sd.backapi.pftransapi.grade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GradePersoRepo extends JpaRepository<GradeAvoir,Long> {
    
}