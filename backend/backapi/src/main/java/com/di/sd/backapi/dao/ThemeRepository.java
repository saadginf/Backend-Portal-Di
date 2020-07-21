package com.di.sd.backapi.dao;

import java.util.List;

import com.di.sd.backapi.modals.Theme;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ThemeRepository extends CrudRepository<Theme, Long>{
    


    @Query(value="SELECT distinct th.id,th.libbele FROM exemplaire e,unite u, tome t , ouvrage o, theme th  Where e.id_tome= t.id and t.id_ou = o.id and th.id=id_theme and u.id=e.id_unite and u.id = ?1", nativeQuery = true)
    List<Object[]> getThemeByUnite(Long gr);

}