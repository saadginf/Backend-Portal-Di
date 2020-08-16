package com.di.sd.backapi.restcontroller;

import com.di.sd.backapi.dao.ClassificationRepo;
import com.di.sd.backapi.dao.DocumentRepo;
import com.di.sd.backapi.dao.OrigineRepo;
import com.di.sd.backapi.dao.SousThemeRepo;
import com.di.sd.backapi.dao.TypeDocRepo;
import com.di.sd.backapi.dao.UniteRepo;
import com.di.sd.backapi.modals.Classification;
import com.di.sd.backapi.modals.Document;
import com.di.sd.backapi.modals.Origine;
import com.di.sd.backapi.modals.SousTheme;
import com.di.sd.backapi.modals.TypeDoc;
import com.di.sd.backapi.services.ArchiveSvcImpl;
import com.di.sd.backapi.services.MapVAlidationErrorService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("api/archive/doc")
public class DocController {
  @Autowired
  DocumentRepo classService;
  @Autowired
  MapVAlidationErrorService mVerrors;
  @Autowired
  OrigineRepo orSvc;
  @Autowired
  TypeDocRepo tySvc;
  @Autowired
  ClassificationRepo classSvc;
  @Autowired
  UniteRepo unSvc;
  @Autowired
  SousThemeRepo sthSvc;
  @Value("${file.upload-archive}")
  private String path;
  @Autowired
  ArchiveSvcImpl achSvc;

  @PostMapping("")
  public ResponseEntity<?> addClassification(@RequestParam MultipartFile file, @RequestParam String objet,
      @RequestParam Long sousTheme, @RequestParam String mumero, @RequestParam String rayonId,
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date dateArrivee, @RequestParam Long origine, @RequestParam Long typedocument,
      @RequestParam Long classification, @RequestParam Long unite, @RequestParam Long[] reference)
     {
        Logger logger = Logger.getLogger(DocController.class.getName());
        MultipartFile files = file;
        if (!file.getContentType().equals("application/pdf")) {
          throw new RuntimeException("Fichier Invalid");
      }
        Origine orDoc = orSvc.findById(origine).get();
        TypeDoc tyDoc = tySvc.findById(typedocument).get();
        Classification classDoc = classSvc.findById(classification).get();
        
        SousTheme sThdoc= sthSvc.findById(sousTheme).get();
        List<Document> references= new ArrayList<Document>();
        for (int i = 0; i < reference.length-1; i++) {
          Document refDoc = classService.findById(reference[i]).get();
          references.add(refDoc);
        }
     
        Document toSaveDoc = new Document();
        toSaveDoc.setClassification(classDoc);
        toSaveDoc.setDateArrivee(dateArrivee);
        toSaveDoc.setMumero(mumero);
        toSaveDoc.setObjet(objet);
        toSaveDoc.setOrigine(orDoc);
        toSaveDoc.setRayonId(rayonId);
        toSaveDoc.setReferences(references);
        toSaveDoc.setSousTheme(sThdoc);
        toSaveDoc.setTypedocument(tyDoc);

      toSaveDoc.setFileDoc(file.getOriginalFilename());
        
      Document docsave = classService.save(toSaveDoc);
        


      System.out.println("'id:'"+docsave.getId());
       System.out.println("'sousTheme:'"+sousTheme);
       System.out.println("'mumero:'"+mumero);
       System.out.println("'objet:'"+objet);
       System.out.println("'dateArrivee:'"+dateArrivee);
       System.out.println("'origine:'"+origine);
       System.out.println("'type:'"+typedocument);
       System.out.println("'classification:'"+classification);
       System.out.println("'unite:'"+unite);
      for (int i = 0; i < reference.length-1; i++) {
       System.out.println("'unite"+i+":"+reference[i]);
       }

       
          try {
         Files.write(Paths.get(path + "/" + docsave.getId() + "_" + docsave.getFileDoc()), file.getBytes());
       } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
       }
       
     
       
        
        
        logger.info(reference.length+"File uploaded, summary = "+ objet+", fileSize = {} bytes"+ files.getOriginalFilename()+","+ files.getSize()+","+file.getContentType());
        return new ResponseEntity<String>("done",HttpStatus.OK);

    }
    @PostMapping("/search")
    public ResponseEntity<?> addEditeur(@RequestParam Long typeDocument, @RequestParam Long sousTheme ){
          
        List<Document> docs = achSvc.FindByTyAndSth(typeDocument, sousTheme);
        return new ResponseEntity<List<Document>>(docs,HttpStatus.OK);

    }
    @GetMapping(path="/download/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getFile(@PathVariable("id") Long id) throws Exception {
        Document u = classService.findById(id).get();
        return Files.readAllBytes(Paths.get(path+"/"+u.getId()+"_"+u.getFileDoc()));
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
          
        Iterable<Document> docs = achSvc.getAll();
        return new ResponseEntity<Iterable<Document>>(docs,HttpStatus.OK);

    }
}