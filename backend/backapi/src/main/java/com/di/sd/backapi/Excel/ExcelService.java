package com.di.sd.backapi.Excel;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.di.sd.backapi.dao.OuvrageRepo;
import com.di.sd.backapi.modals.Ouvrage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExcelService {
    @Autowired
    OuvrageRepo repository;
    @Autowired
    ExcelHelper excelHelper;

    public void save(MultipartFile file) throws ParseException {
        try {
            List<Ouvrage> tutorials = excelHelper.excelToTutorials(file.getInputStream());
            for (Ouvrage book : tutorials) {
                repository.save(book);
            }

        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    // public List<Book> getAllTutorials() {
    // return repository.findAll();
    // }
}