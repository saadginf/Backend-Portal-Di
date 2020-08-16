package com.di.sd.backapi.dao;

import java.util.List;

import com.di.sd.backapi.modals.Document;
import com.di.sd.backapi.modals.SousTheme;
import com.di.sd.backapi.modals.TypeDoc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepo extends CrudRepository<Document, Long> {
    List<Document> findByTypedocumentAndSousThemeOrderByDateArrivee(TypeDoc typedocument, SousTheme soustheme);
}