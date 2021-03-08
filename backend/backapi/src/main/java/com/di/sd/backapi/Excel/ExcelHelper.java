package com.di.sd.backapi.Excel;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.di.sd.backapi.dao.AuteurRepo;
import com.di.sd.backapi.dao.ClassificationRepo;
import com.di.sd.backapi.dao.EditeurRepo;
import com.di.sd.backapi.dao.OrigineRepo;
import com.di.sd.backapi.dao.OuvrageRepo;
import com.di.sd.backapi.dao.ThemeRepository;
import com.di.sd.backapi.dao.TypeRepo;
import com.di.sd.backapi.modals.Auteur;
import com.di.sd.backapi.modals.Classification;
import com.di.sd.backapi.modals.Editeur;
import com.di.sd.backapi.modals.Origine;
import com.di.sd.backapi.modals.Ouvrage;
import com.di.sd.backapi.modals.Theme;
import com.di.sd.backapi.modals.Type;
import com.di.sd.backapi.services.AuteurServiceImpl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Id", "Title", "Description", "Published" };
    static String SHEET = "pfe";

    @Autowired
    OuvrageRepo ouvRepo;

    @Autowired(required = true)
    AuteurRepo autRepo;

    @Autowired
    ThemeRepository threpo;

    @Autowired
    OrigineRepo orRepo;

    @Autowired
    TypeRepo tyRepo;

    @Autowired
    ClassificationRepo clsRepo;

    @Autowired
    EditeurRepo edRepo;

    @Autowired
    AuteurServiceImpl autsvc;

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public List<Ouvrage> excelToTutorials(InputStream is) throws ParseException {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<Ouvrage> tutorials = new ArrayList<Ouvrage>();
            int i = 1;
            int rowNumber = 0;
            while (rows.hasNext()) {
                System.out.println(i);
                Row currentRow = rows.next();

                if (rowNumber == 0) {
                    rowNumber++;

                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Ouvrage ouvrage = new Ouvrage();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    System.out.println(cellIdx);
                    switch (cellIdx) {
                        case 0:
                            String titre = currentCell.getStringCellValue();

                            // if (ouvRepo.findByTitre(titre).isEmpty()) {
                            ouvrage.setTitre(titre);
                            /// } else {
                            // System.out.println("Ouvrage Existant");
                            // }
                            break;

                        case 1:
                            String auteur = currentCell.getStringCellValue();
                            String[] auteurs = auteur.split(",");
                            System.out.println(auteurs.length);
                            Set<Auteur> auts = new HashSet<>();
                            for (String string : auteurs) {
                                if (autRepo.findBylibbele(string) == null) {
                                    Auteur aut = new Auteur();
                                    aut.setLibbele(string);

                                    Auteur savedAut = autsvc.addAuteur(aut);
                                    auts.add(savedAut);
                                } else {
                                    Auteur auti = autRepo.findBylibbele(string);
                                    auts.add(auti);
                                }
                            }
                            ouvrage.setAuteurs(auts);
                            break;
                        case 2:
                            String sDate1 = currentCell.getStringCellValue();
                            Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(sDate1);
                            ouvrage.setAnneePublication(date1);
                            break;
                        case 3:
                            String descriptif = currentCell.getStringCellValue();
                            ouvrage.setDescriptif(descriptif);
                            break;

                        case 4:
                            Long theme = (long) currentCell.getNumericCellValue();
                            Theme th = threpo.findById(theme).get();
                            ouvrage.setTheme(th);
                            break;
                        case 5:
                            Long or = (long) currentCell.getNumericCellValue();
                            Origine origine = orRepo.findById(or).get();
                            ouvrage.setOrigine(origine);
                            break;
                        case 6:
                            Long ty = (long) currentCell.getNumericCellValue();
                            Type type = tyRepo.findById(ty).get();
                            ouvrage.setType(type);
                            break;
                        case 7:
                            Long cls = (long) currentCell.getNumericCellValue();
                            Classification clss = clsRepo.findById(cls).get();
                            ouvrage.setClassification(clss);
                            break;
                        case 8:
                            String ed = currentCell.getStringCellValue();
                            Editeur check = edRepo.findBylibbele(ed);
                            if (check == null) {
                                Editeur edit = new Editeur();
                                edit.setLibbele(ed);
                                Editeur savedEditeur = edRepo.save(edit);
                                ouvrage.setEditeur(savedEditeur);
                            } else {
                                ouvrage.setEditeur(check);
                            }
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }
                i++;
                tutorials.add(ouvrage);
            }

            workbook.close();

            return tutorials;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}