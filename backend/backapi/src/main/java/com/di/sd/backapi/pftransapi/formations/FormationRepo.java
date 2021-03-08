package com.di.sd.backapi.pftransapi.formations;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface FormationRepo extends JpaRepository<Formations, Long> {
    List<Formations> findByCategorieFormation(CategorieFormation categorieFormation);

    List<Formations> findByTypeFormation(TypeFormation typeFormation);
}