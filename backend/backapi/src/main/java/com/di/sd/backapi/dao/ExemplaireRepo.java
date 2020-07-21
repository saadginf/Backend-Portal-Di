package com.di.sd.backapi.dao;

import java.util.List;

import com.di.sd.backapi.modals.Exemplaire;
import com.di.sd.backapi.modals.Tome;
import com.di.sd.backapi.modals.Unite;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ExemplaireRepo extends CrudRepository<Exemplaire,Long> {
    Exemplaire findByRayonId(String rayonId);
    List<Exemplaire> findByUnite(Unite unite);
    Long countByUnite(Unite unite);
    Integer countByUniteAndTome(Unite unite, Tome tome);


    @Query(value="SELECT o.id, o.titre,ed.libbele,o.annee_publication FROM exemplaire e, ouvrage o, theme th, unite u, editeur ed, tome t where t.id=e.id_tome and o.id = t.id_ou and th.id = o.id_theme and u.id =e.id_unite and ed.id = o.id_editeur and th.id = ?1 and u.id= ?2 Group by th.libbele,o.id, o.titre, ed.libbele, o.annee_publication order by o.titre", nativeQuery = true)
    List<Long> generateStats(Long theme, Long unite);
}