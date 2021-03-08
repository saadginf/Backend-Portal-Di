package com.di.sd.backapi.pftransapi.inscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutRepository extends JpaRepository<Statutinscription, Long> {

}