package com.di.sd.backapi.Excel;

import org.springframework.http.HttpStatus;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.di.sd.backapi.dao.ExemplaireRepo;
import com.di.sd.backapi.dao.FormatRepo;
import com.di.sd.backapi.dao.OuvrageRepo;
import com.di.sd.backapi.dao.ThemeDocRepo;
import com.di.sd.backapi.dao.ThemeRepository;
import com.di.sd.backapi.dao.TomeRepo;
import com.di.sd.backapi.dao.UniteRepo;
import com.di.sd.backapi.modals.Exemplaire;
import com.di.sd.backapi.modals.Format;
import com.di.sd.backapi.modals.Ouvrage;
import com.di.sd.backapi.modals.Theme;
import com.di.sd.backapi.modals.ThemeDoc;
import com.di.sd.backapi.modals.Tome;
import com.di.sd.backapi.services.ExmplaireServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("http://localhost:8081")
@Controller
@RequestMapping("/api/excel")
public class ExcelController {

    @Autowired
    ExcelService fileService;
    @Autowired
    OuvrageRepo ouvRepo;
    @Autowired
    ThemeRepository thRepo;
    @Autowired
    TomeRepo trepo;
    @Autowired
    FormatRepo fRepo;
    @Autowired
    UniteRepo uRepo;
    @Autowired
    ExmplaireServiceImpl exService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) throws ParseException {
        String message = "";

        if (ExcelHelper.hasExcelFormat(file)) {
            // try {
            fileService.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            // } catch (Exception e) {
            /// message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            // return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new
            // ResponseMessage(message));
            // }
        }

        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    // @GetMapping("/tutorials")
    // public ResponseEntity<List<Book>> getAllTutorials() {
    // try {
    // List<Book> tutorials = fileService.getAllTutorials();

    // if (tutorials.isEmpty()) {
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

    // return new ResponseEntity<>(tutorials, HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    @GetMapping("/tutorials")
    public ResponseEntity<String> getAllTutorials() {

        for (Long i = 1200L; i < 1449L; i++) {
            System.out.println(i);

            Optional<Ouvrage> ouvs = ouvRepo.findById(i);

            if (!ouvs.isPresent()) {
                continue;
            }
            if (ouvs.get().getTomes().isEmpty()) {
                continue;
            }
            Tome tome = ouvs.get().getTomes().iterator().next();

            Exemplaire ex = new Exemplaire();
            Date date = new Date();
            ex.setDateAcquisition(date);
            ex.setEtat("Très Bon");
            Format f = fRepo.findById(24L).get();
            ex.setFormat(f);
            ex.setReference("Aucune");
            ex.setRayonId("TTA");
            ex.setTome(tome);
            ex.setUnite(uRepo.findById(42L).get());
            exService.addExemp(ex);

        }

        return new ResponseEntity<String>("Done", HttpStatus.ACCEPTED);

    }
}
